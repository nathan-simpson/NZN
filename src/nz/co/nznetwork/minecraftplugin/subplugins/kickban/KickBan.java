package nz.co.nznetwork.minecraftplugin.subplugins.kickban;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import nz.co.nznetwork.minecraftplugin.NZNPlugin;
import nz.co.nznetwork.minecraftplugin.NZNSubplugin;

public class KickBan implements NZNSubplugin, CommandExecutor {

	private NZNPlugin plugin;
	@Override
	public void onEnable(NZNPlugin masterPlugin) {
		plugin = masterPlugin;
		plugin.getLogger().info("Subplugin KickBan Enabled");
	}
	@Override
	public void onDisable() {
		plugin.getLogger().info("Subplugin KickBan Disabled");
	}
	@Override
	public void reloadConfig() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
	
	public void kick(Player target, String reason) { //this is public because the chat filter and spam filter may want to call it
		target.kickPlayer(ChatColor.RED+"Kicked reason: "+ChatColor.GRAY+reason);
		plugin.getServer().broadcastMessage(plugin.getChatFormat().getColoredName(target)+ChatColor.RED+" was kicked. Reason: "+reason);
	}
	public void ban(Player target, String reason) {
		target.kickPlayer(ChatColor.DARK_RED+"Banned reason: "+ChatColor.GRAY+reason);
		//connect to database
		if(target.isOnline()) {
			plugin.getServer().broadcastMessage(plugin.getChatFormat().getColoredName(target)+ChatColor.DARK_RED+" was banned. Reason: "+reason);
		}
	}
	public void tempban(Player target, String reason, String time) {
		target.kickPlayer(ChatColor.DARK_RED+"Banned Until "+ChatColor.GRAY+"4:00pm 12th June\n"+ChatColor.DARK_RED+" Reason: "+ChatColor.GRAY+reason);
		//connect to database
		if(target.isOnline()) {
			plugin.getServer().broadcastMessage(plugin.getChatFormat().getColoredName(target)+ChatColor.DARK_RED+" was banned. Reason: "+reason);
		}
	}

}
