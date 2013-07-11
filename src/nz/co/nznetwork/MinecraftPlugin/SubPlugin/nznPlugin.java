/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.co.nznetwork.MinecraftPlugin.SubPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nz.co.nznetwork.MinecraftPlugin.NZnetworkMinecraftPlugin;

/**
 *
 * @author Nathan Simpson
 * @website www.nznetwork.co.nz
 */
public class nznPlugin implements nznPluginInterface{

    public NZnetworkMinecraftPlugin plugin;
    public nznCommandExecutor CommandExecutor;
    public Boolean enabled = false;
    public Boolean started = false;
    public Map<String, List<String>> Commands = new HashMap<>();
   
    
    String pluginName = "NoName";
        
    public nznPlugin(NZnetworkMinecraftPlugin plugin){
        this.plugin = plugin;
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
        if(!this.started){
            return true;
        }
        return true;
    }

    @Override
    public Boolean Restart() {
        return true;
    }

    @Override
    public void LoadConfig() {
        List<String> commands = this.plugin.getConfig().getStringList("Commands." + this.pluginName);
        for(String command : commands){
            this.Commands.put(command, this.plugin.getConfig().getStringList("Commands." + this.pluginName + "." + command));
        }
    }

    @Override
    public void SetupCommands() {
        if(!Commands.isEmpty()){
            this.CommandExecutor = new nznCommandExecutor();
            for(List<String> CommandNames : Commands.values()){
                for(String CommandName : CommandNames){
                    plugin.getCommand(CommandName).setExecutor(this.CommandExecutor);
                }
            }
        }
    }

}
