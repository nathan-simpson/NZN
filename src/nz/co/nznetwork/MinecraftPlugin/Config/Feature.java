/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.nznetwork.MinecraftPlugin.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nathan Simpson
 * @website www.nznetwork.co.nz
 */
public class Feature {
    private Map<String, Boolean> Features = new HashMap<>();
    
    public Set<String> getFeatures(){
        return Features.keySet();
    }
    
    public Boolean getFeature(String name){
        return Features.get(name);
    }
    
    public void addFeature(String name, Boolean enabled){
        Features.put(name, enabled);
    }
    
    public void updateFeature(String name, Boolean enabled){
        Features.put(name, enabled);
    }
}
