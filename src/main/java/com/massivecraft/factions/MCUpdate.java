package com.massivecraft.factions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MCUpdate implements Listener {

    private final String VERSION = "2.0";
    private final String BASE_URL = "https://report.mcupdate.org";

    /**
     * Server received information.
     */
    private JavaPlugin plugin;
    private MCUpdateServerResponse response;

    /**
     * Interval of time to ping (seconds)
     */
    private int PING_INTERVAL = 900;

    /**
     * The scheduled task
     */
    private volatile BukkitTask task = null;

    /**
     * Starts MCUpdate. The task is scheduled and started automatically.
     * @param plugin The plugin instance.
     */
    public MCUpdate(JavaPlugin plugin) throws IOException {
        this.plugin = plugin;
        // Start communicating with MCUpdate's server.
        start();
        // Register a listener so that we send messages on join.
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /**
     * @deprecated Use {@link MCUpdate#MCUpdate(JavaPlugin)} instead.
     * @see MCUpdate#MCUpdate(JavaPlugin)
     * @param plugin The plugin instance.
     * @param startTask Whether or not you want to start the task (now ignored).
     */
    public MCUpdate(JavaPlugin plugin, boolean startTask) throws IOException {
        this(plugin);
    }

    /**
     * Starts the routine data exchange with the MCUpdate server.
     */
    public void start() {
        // Prevent making multiple tasks
        if (task == null) {
            // Start reporting to the server.
            task = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new Runnable(){

                @Override
                public void run(){
                    report();

                    // Log a message to the console that there is an update.
                    if (!response.isUpToDate()) {
                        plugin.getServer().getConsoleSender().sendMessage(response.getUpdateMessage());
                    }
                }

            }, 0, PING_INTERVAL * 20);
        }
    }

    /**
     * Stops the routine data exchange with the MCUpdate server.
     */
    public void stop(){
        task.cancel();
        task = null;
    }

    /* Data collection / handling */
    private int getOnlinePlayers() {
        try {
            Method onlinePlayerMethod = Server.class.getMethod("getOnlinePlayers");
            if (onlinePlayerMethod.getReturnType().equals(Collection.class)) {
                return ((Collection<?>) onlinePlayerMethod.invoke(Bukkit.getServer())).size();
            } else {
                return ((Player[]) onlinePlayerMethod.invoke(Bukkit.getServer())).length;
            }
        } catch (Exception ex) {
            Bukkit.getLogger().warning("Unable to detect the amount of currently online players!");
        }
        return 0;
    }
    private String jsonify(String key, String value) {
        return "\"" + key + "\":\"" + value + "\"";
    }
    private String getString(String data, String key) {
        String dat = data.replace("{ \"Response\": {\"", "");
        dat = dat.replace("\"} }", "");
        List<String> list = Arrays.asList(dat.split("\",\""));

        for (String stub : list) {
            List<String> list2 = Arrays.asList(stub.split("\":\""));
            if (key.equals(list2.get(0))) {
                return list2.get(1);
            }
        }
        return null;
    }

    /* Report execution */
    private void report() {
        String ver = plugin.getDescription().getVersion();
        String name = plugin.getDescription().getName();
        int playersOnline = this.getOnlinePlayers();
        boolean onlineMode = plugin.getServer().getOnlineMode();
        String serverVersion = plugin.getServer().getVersion();

        String osname = System.getProperty("os.name");
        String osarch = System.getProperty("os.arch");
        String osversion = System.getProperty("os.version");
        String java_version = System.getProperty("java.version");
        int coreCount = Runtime.getRuntime().availableProcessors();

        String report = "{ \"report\": {";
        // Plugin information
        report += jsonify("plugin", name) + ",";
        report += jsonify("version", ver) + ",";
        // Spigot Information
        report += jsonify("playersonline", playersOnline + "") + ",";
        report += jsonify("onlinemode", onlineMode + "") + ",";
        report += jsonify("serverversion", serverVersion) + ",";
        // Java Information
        report += jsonify("javaversion", java_version) + ",";
        // OS Information
        report += jsonify("osname", osname) + ",";
        report += jsonify("osarch", osarch) + ",";
        report += jsonify("osversion", osversion) + ",";
        // CPU Information
        report += jsonify("corecount", coreCount + "") + "";
        report += "} }";

        byte[] data = report.getBytes();
        String updateMessage;
        boolean upToDate = true;

        try {

            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(2500);
            connection.setReadTimeout(3500);

            connection.addRequestProperty("User-Agent", "MCUPDATE/" + VERSION);
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Content-Length", Integer.toString(data.length));
            connection.addRequestProperty("Accept", "application/json");
            connection.addRequestProperty("Connection", "close");

            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(data);
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String endData = br.readLine().trim();

            String serverMessage = getString(endData, "message");
            String cVersion = getString(endData, "pl_Version");
            updateMessage = getString(endData, "update_Message");

            if (!serverMessage.equals("ERROR")) {
                if (!ver.equals(cVersion)) {
                    upToDate = false;
                }
            }
            br.close();

            response = new MCUpdateServerResponse(plugin, updateMessage, upToDate);

        } catch (IOException ignored) {
        }
    }

    /**
     * Allows adjusting the interval at which MCUpdate pings the server.
     * @param PING_INTERVAL The MCUpdate ping interval.
     */
    public void setPingInterval(int PING_INTERVAL) {
        this.PING_INTERVAL = PING_INTERVAL;
    }

    /* Messaging */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.isOp() && !response.isUpToDate()) {
            player.sendMessage(response.getUpdateMessage());
        }
    }
}

class MCUpdateServerResponse {

    private String updateMessage;
    private boolean upToDate;

    MCUpdateServerResponse(JavaPlugin plugin, String updateMessage, boolean upToDate) {
        this.updateMessage = ChatColor.translateAlternateColorCodes('&', updateMessage);
        this.upToDate = upToDate;
    }

    /**
     * If there is an update available, this will be the message returned by the server.
     * @return The server's update message.
     */
    public String getUpdateMessage() {
        return updateMessage;
    }

    /**
     * @return Whether or not the plugin is up to date.
     */
    public boolean isUpToDate() {
        return upToDate;
    }

}