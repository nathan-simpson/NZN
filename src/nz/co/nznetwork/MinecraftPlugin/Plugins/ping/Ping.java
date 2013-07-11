/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.co.nznetwork.MinecraftPlugin.Plugins.ping;

import java.util.List;
import nz.co.nznetwork.MinecraftPlugin.NZnetworkMinecraftPlugin;
import nz.co.nznetwork.MinecraftPlugin.NZnetworkMinecraftPlugin;
import nz.co.nznetwork.MinecraftPlugin.SubPlugin.nznPlugin;

/**
 *
 * @author Nathan Simpson
 * @website www.nznetwork.co.nz
 */
public class Ping extends nznPlugin {
    
    String pluginName = "Ping";
    
    /**
     *
     * @param plugin
     */
    public Ping(NZnetworkMinecraftPlugin plugin){
        super(plugin);
    }

    @Override
    public Boolean Start() {
        this.enabled = this.plugin.getConfig().getBoolean("Plugins." + this.pluginName, false);
        if(!this.enabled) {
            return false;
        }
        LoadConfig();
        SetupCommands();
        return true;
    }

    @Override
    public Boolean Stop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean Restart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void LoadConfig() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
