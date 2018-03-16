SavageFactions
====================

[![Discord](https://imgur.com/MFRRBn4.png)](https://discord.gg/JfQKSDh)



SavageFaction is a fork of FactionsUUID by drtshock, this fork is designed for competitive factions servers and has more features than the original. 

Current Features
1. /f tnt add/take <amount> - store tnt virtually into your faction.
2. /f rules add/remove/set - Set some rules for your faction to see. Can be useful for new members etc.
3. /f getvault - receive a vault item, place it in faction land
4. /f vault - remotely access placed vault.
5. /f upgrades - Upgrade crop growth, mob spawners, and exp drops in your claims
6. /f perms - Improved perms, fixed issue where options wouldnt set even though they appeared to.
7. /f near - View nearby Faction Members 
8. /f checkpoint - Go to your faction checkpoint (if set)
9. /f checkpoint set - Set your faction checkpoint 

</rant>

This plugin will allow the players on the server to create factions/guilds. The factions can claim territory that will be protected from non-members. Factions can forge alliances and declare themselves enemies with others. Land may be taken from other factions through war.

The goals of this plugin:

 * The players should be able to take care of anti-griefing themselves.
 * Inspire politics and intrigues on your server.
 * Guilding and team spirit! :)
 * Auto convert old 1.6.9.x versions to save with UUIDs.

Versioning
----------
All versions prefixed with `1.6.9.5` as that is the legacy version.
Followed by -U noting that it's the FactionsUUID fork.

FactionsUUID versioning: `U<major>.<minor>.<patch>-<tag>`

* Major version: Incompatible API changes
* Minor version: Add backwards compatible features
* Patch: Fixing bugs 
* SNAPSHOT: Version is in bug fixing stage
* Release Candidate (RC): Potentially a release

Usage
---------
<b>Read the full userguide here: [Factions Wiki](https://github.com/drtshock/Factions/wiki)</b>

The chat console command is:

 * `/f`

This command has subcommands like:

* `/f create MyFactionName`
* `/f invite MyFriendsName`
* `/f claim`
* `/f map`
* ... etc

You may also read the documentation ingame as the plugin ships with an ingame help manual. Read the help pages like this:

* `/f help 1`
* `/f help 2`
* `/f help 3`

Note that you may optionally skip the slash and just write

* `f`

Installing
----------
1. Download the latest release [on Spigot](https://www.spigotmc.org/resources/factionsuuid.1035/)<br>
1. Put Factions.jar in the plugins folder.

A default config file will be created on the first run.

License
----------
This project has a LGPL license just like the Bukkit project.<br>
This project uses [GSON](http://code.google.com/p/google-gson/) which has a [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0 ).

