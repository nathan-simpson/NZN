package nz.co.nznetwork.minecraftplugin;
//andrew uni test 2
import java.io.File;
import java.util.ArrayList;

import nz.co.nznetwork.minecraftplugin.database.NZNDatabase;
import nz.co.nznetwork.minecraftplugin.subplugins.chatformat.ChatFormat;
import nz.co.nznetwork.minecraftplugin.utils.NZNUtils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nathan Simpson, Andrew Davies
 * @website www.nznetwork.co.nz
 */
public class NZNPlugin extends JavaPlugin {

    private ArrayList<NZNSubplugin> loadedSubPlugins;
    private NZNDatabase database;
    private NZNUtils utils;

    //chatformat is a subplugin and behaves like one but it has methods used bu other plugins
    //so it is here so that other plugins can access it;
    private ChatFormat chatFormat;

    @Override
    public void onEnable(){
        //read config
    	//create database object and connect to database
    	database = new NZNDatabase();
    	database.connect(getConfig("database.yml"));
    	loadedSubPlugins = new ArrayList<NZNSubplugin>();
    	utils = new NZNUtils(this);
    	chatFormat = new ChatFormat(this);
    	loadedSubPlugins.add(chatFormat);

    	//create subplugins (the ones enabled in config) and add them to array
    	//assign commands and events to subplugins
    	//call on onEnable() on each subplugin OR you could create all plugins and only call onEnable to the enabled ones
    	for(NZNSubplugin p : loadedSubPlugins) {
    		p.onEnable(this);
    	}
    }
    @Override
    public void onDisable() {
    	//call on onDisable() on each subplugin
    	for(NZNSubplugin p : loadedSubPlugins) {
    		p.onDisable();
    	}
    }
    public void reloadAllConfigs() {
    	reloadConfig();
    	//call reloadConfig() on each subplugin
    	for(NZNSubplugin p : loadedSubPlugins) {
    		p.reloadConfig();
    	}
    }

    /**
     * Gets a custom config from a filename
     * If a subplugin wants to use the default config it calls getConfig() with no arguments
     */
    public FileConfiguration getConfig(String filename) {
    	File configFile = new File(getDataFolder(), filename);
    	if(!configFile.exists()) {
    		//report error
    	}
    	return YamlConfiguration.loadConfiguration(configFile);
    }

    public NZNUtils getUtils() { return utils; }
    public NZNDatabase getNZNDatabase() {return database;}
    public ChatFormat getChatFormat() { return chatFormat; }
}
