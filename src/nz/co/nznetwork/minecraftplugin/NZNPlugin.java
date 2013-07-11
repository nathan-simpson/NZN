package nz.co.nznetwork.minecraftplugin;

import java.io.File;
import java.util.ArrayList;

import nz.co.nznetwork.minecraftplugin.database.NZNDatabase;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nathan Simpson, Andrew Davies
 * @website www.nznetwork.co.nz
 */
public class NZNPlugin extends JavaPlugin {
    
    private ArrayList<NZNSubplugin> loadedSubPlugins;
    private NZNDatabase database;
    
    @Override
    public void onEnable(){
        //read config
    	//create database object and connect to database
    	database = new NZNDatabase();
    	database.connect(getConfig("database.yml"));
    	loadedSubPlugins = new ArrayList<NZNSubplugin>();
    	//create subplugins (the ones enabled in config) and add them to array
    	//assign commands
    	//call on onEnable() on each subplugin
    }
    @Override
    public void onDisable() {
    	//call on onDisable() on each subplugin
    }
    public NZNDatabase getNZNDatabase() {return database;}
    private void reloadAllConfigs() {
    	reloadConfig();
    	//call reloadConfig() on each subplugin
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
}
