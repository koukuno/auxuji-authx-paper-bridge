package sh.auxuji.authx.paper.listener;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import sh.auxuji.authx.paper.AuthX;

public class PlayerListener implements Listener {
	private final AuthX plugin;

	public PlayerListener(AuthX plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onBedEnter(PlayerBedEnterEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onDropItem(PlayerDropItemEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onEditBook(PlayerEditBookEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onFish(PlayerFishEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onInteractAtEntity(PlayerInteractAtEntityEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onInteractEntity(PlayerInteractEntityEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onInteract(PlayerInteractEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onItemConsume(PlayerItemConsumeEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onItemHeld(PlayerItemHeldEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		if (!player.isOnline())
			this.plugin.freezePlayer(player.getUniqueId());
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onMove(PlayerMoveEvent event) {
		Location from = event.getFrom();
		Location to = event.getTo();
		if (to == null)
			return;

		if (from.getBlockX() == to.getBlockX() &&
			from.getBlockZ() == to.getBlockZ() &&
			from.getY() - to.getY() >= 0) {
			return;
		}

		Player player = event.getPlayer();
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setTo(event.getFrom());
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onPickupItem(PlayerPickupItemEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onShearEntity(PlayerShearEntityEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onSwapHandItems(PlayerSwapHandItemsEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}
}
