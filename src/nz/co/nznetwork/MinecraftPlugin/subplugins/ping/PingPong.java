package nz.co.nznetwork.MinecraftPlugin.subplugins.ping;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nz.co.nznetwork.MinecraftPlugin.NZNPlugin;
import nz.co.nznetwork.MinecraftPlugin.NZNSubplugin;

public class PingPong implements NZNSubplugin, CommandExecutor {

	private NZNPlugin plugin;
	@Override
	public void onEnable(NZNPlugin masterPlugin) {
		plugin = masterPlugin;
		plugin.getLogger().info("Subplugin PingPong Enabled");
	}
	@Override
	public void onDisable() {
		plugin.getLogger().info("Subplugin PingPong Disabled");
	}
	@Override
	public void reloadConfig() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ping")) {
			sender.sendMessage(ChatColor.AQUA+"Pong");
			return true;
		}
		//something really screwed up to get here
		return false;
	}

}
