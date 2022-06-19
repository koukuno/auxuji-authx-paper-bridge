package sh.auxuji.authx.paper.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import sh.auxuji.authx.paper.AuthX;

public class InventoryListener implements Listener {
	private final AuthX plugin;

	public InventoryListener(AuthX plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onClick(InventoryClickEvent event) {
		if (this.plugin.shouldCancelEvent(event.getWhoClicked()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onOpen(InventoryOpenEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer())) {
			event.setCancelled(true);
			this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, event.getPlayer()::closeInventory, 1);
		}
	}
}
