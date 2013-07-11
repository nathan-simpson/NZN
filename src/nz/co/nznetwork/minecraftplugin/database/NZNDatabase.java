package nz.co.nznetwork.minecraftplugin.database;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author Nathan Simpson, Andrew Davies
 * @website www.nznetwork.co.nz
 */
public class NZNDatabase {
	//this could be moved to its own package if it extends past one class
	
	/**
	 * Connects to a database
	 * @param host The url of the database
	 * @param username The username to connect with
	 * @param password The password to use (hashed)
	 */
	public void connect(String host, String username, String password) {}
	/**
	 * Connects to a database
	 * @param config The file to load connection details from
	 */
	public void connect(FileConfiguration config) {}
	
	public void queueQuery(String query, DatabaseListener listener) {
		//execute query, add to queue, whatever
		listener.queryComplete();
	}
}
