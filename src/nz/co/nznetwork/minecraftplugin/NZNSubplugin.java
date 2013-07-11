package nz.co.nznetwork.minecraftplugin;

/**
 * @author Nathan Simpson, Andrew Davies
 * @website www.nznetwork.co.nz
 */
public interface NZNSubplugin {
	public void onEnable(NZNPlugin masterPlugin); //we could remove this method and aggree it is the constructor of the subplugin
	public void onDisable();
	public void reloadConfig();
}
