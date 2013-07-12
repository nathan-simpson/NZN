package nz.co.nznetwork.minecraftplugin.subplugins.gamemode;

import nz.co.nznetwork.minecraftplugin.NZNPlugin;
import nz.co.nznetwork.minecraftplugin.NZNSubplugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMode implements NZNSubplugin, CommandExecutor {

    private NZNPlugin plugin;

    @Override
    public void onEnable(NZNPlugin masterPlugin) {
        plugin = masterPlugin;
        plugin.getLogger().info("Subplugin GameMode Enabled");
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Subplugin GameMode Disabled");
    }

    @Override
    public void reloadConfig() {
    } //dosn't use its own config

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "Only players may use this command");
                return true;
            }
            Player p = (Player) sender;
            if (args.length == 0 && plugin.getUtils().getPermision(p, "nzn.gm.self")) { //simplest case using gm on self
                toggleGM(p);
                return true;
            }
            if (args.length == 0) { //tried to use gm on self with no permission
                sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "You do not have permission to use this command");
                return true;
            }
            if (args.length == 1 && plugin.getUtils().getPermision(p, "nzn.gm.target")) {//use gm on another player
                p = plugin.getServer().getPlayer(args[0]);
                if (p == null) {
                    sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "Could not find player " + ChatColor.YELLOW + args[0]);
                    return true;
                }
                toggleGM(p);
                sender.sendMessage(ChatColor.WHITE + "Set " + plugin.getChatFormat().getColoredName(p) + "'s " + ChatColor.WHITE + " gamemode to " + p.getGameMode());
                return true;
            }
            if (args.length == 1) {//tried to use gm on another player with no permission
                if (plugin.getUtils().getPermision(p, "nzn.gm.self")) {//however can do gm on self
                    sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "You do not have permission to use this command on others, use /gm");
                    return true;
                }
                sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "You do not have permission to use this command");
                return true;
            }
            if (args.length > 1) {//had too many arguments
                if (plugin.getUtils().getPermision(p, "nzn.gm.self")) {
                    if (plugin.getUtils().getPermision(p, "nzn.gm.target")) {//has perms to use on others
                        sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "Too many arguments, use /gm <player>");
                        return true;
                    }
                    sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "You do not have permission to use this command on others, use /gm");
                    return true;
                }
            }
            sender.sendMessage(plugin.getUtils().ERROR_COLOUR + "You do not have permission to use this command");
            return true;
        }
        //something really screwed up to get here
        return false;
    }

    private void toggleGM(Player p) {
        if (p.getGameMode() == org.bukkit.GameMode.CREATIVE) {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
        } else {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
        }
    }
}
