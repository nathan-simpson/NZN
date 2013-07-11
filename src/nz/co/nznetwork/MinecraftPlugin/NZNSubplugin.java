package nz.co.nznetwork.MinecraftPlugin;

/**
 * @author Nathan Simpson, Andrew Davies
 * @website www.nznetwork.co.nz
 */
public interface NZNSubplugin {
	public void onEnable(NZNPlugin masterPlugin);
	public void onDisable();
	public void reloadConfig();
}
