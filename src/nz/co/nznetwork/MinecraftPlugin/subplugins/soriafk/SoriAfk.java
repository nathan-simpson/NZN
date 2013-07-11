package nz.co.nznetwork.MinecraftPlugin.subplugins.soriafk;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nz.co.nznetwork.MinecraftPlugin.NZNPlugin;
import nz.co.nznetwork.MinecraftPlugin.NZNSubplugin;

public class SoriAfk implements NZNSubplugin, CommandExecutor {

	private NZNPlugin plugin;
	@Override
	public void onEnable(NZNPlugin masterPlugin) {
		plugin = masterPlugin;
		plugin.getLogger().info("Subplugin SoriAfk Enabled");
	}
	@Override
	public void onDisable() {
		plugin.getLogger().info("Subplugin SoriAfk Disabled");
	}
	@Override
	public void reloadConfig() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("issoriafk")) {
			sender.sendMessage(ChatColor.AQUA+"Yes");
			return true;
		}
		//something really screwed up to get here
		return false;
	}

}
