package com.massivecraft.factions.struct;

import org.bukkit.inventory.ItemStack;

public class ChestLogInfo {

    private String user;
    private String time;
    private int amount;
    private ItemStack itemStack;


    public ChestLogInfo(String user, String time, int amount, ItemStack itemStack) {
        this.user = user;
        this.time = time;
        this.amount = amount;
        this.itemStack = itemStack;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
