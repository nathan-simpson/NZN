/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.nznetwork.MinecraftPlugin.SubPlugin;


/**
 *
 * @author Nathan Simpson
 */
public interface nznPluginInterface {
    
    public Boolean Start();
    public Boolean Stop();
    public Boolean Restart();
    public void LoadConfig();
    public void SetupCommands();
    
}