package nz.co.nznetwork.minecraftplugin.subplugins.chatformat;

import nz.co.nznetwork.minecraftplugin.NZNPlugin;
import nz.co.nznetwork.minecraftplugin.NZNSubplugin;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ChatFormat implements NZNSubplugin {
	
	private final String configFile = "chatformat.yml";
	
	private NZNPlugin plugin;
	private FileConfiguration config;
	
	public ChatFormat(NZNPlugin masterPlugin) {
		plugin = masterPlugin;
		config = plugin.getConfig(configFile);
	}
	public String getColoredName(CommandSender sender){
		if(sender instanceof Player) {
			Player p = (Player) sender;
			return p.getDisplayName();
		}
		return getColoredMessage("&"+config.getString("nzn.chatformat.consolecolor")+config.getString("nzn.chatformat.consolename"));
		
	}
	public String getColoredLevelTag(Player p){return p.getDisplayName();}
	public String getColoredRankTag(Player p){return p.getDisplayName();}
	public String getColoredMessage(String message) { return message; }
	
	@Override
	public void onEnable(NZNPlugin masterPlugin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reloadConfig() {
		config = plugin.getConfig(configFile);
	}
}
