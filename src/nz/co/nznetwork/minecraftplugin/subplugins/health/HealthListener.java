package nz.co.nznetwork.minecraftplugin.subplugins.health;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HealthListener implements Listener {
	
	private Health master;
	
	public HealthListener(Health healthPlugin) {
		master = healthPlugin;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if(e instanceof Player) {
			Player p = (Player) e;
			if(master.isGod(p)) {
				event.setCancelled(true);
			}
		}
	}
}
