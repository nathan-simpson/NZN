/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * test edit by andrew
 */
package nz.co.nznetwork.MinecraftPlugin;

import nz.co.nznetwork.MinecraftPlugin.Config.Feature;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nathan Simpson
 * @website www.nznetwork.co.nz
 */
public final class NZnetworkMinecraftPlugin extends JavaPlugin {
    Feature features;
    
    public void init(){
        this.saveDefaultConfig();
        features = new Feature();
    }
    
    @Override
    public void onEnable(){
        // TODO Insert logic to be performed when the plugin is enabled
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    
}
