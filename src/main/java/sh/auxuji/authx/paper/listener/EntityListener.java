package sh.auxuji.authx.paper.listener;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;
import sh.auxuji.authx.paper.AuthX;

public class EntityListener implements Listener {
	private final AuthX plugin;

	public EntityListener(AuthX plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onAirChange(EntityAirChangeEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onDamage(EntityDamageEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity())) {
			event.getEntity().setFireTicks(0);
			event.setDamage(0);
			event.setCancelled(true);
		}
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onDamageByOther(EntityDamageByEntityEvent event) {
		if (this.plugin.shouldCancelEvent(event.getDamager()) || this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public void onInteractHighestPriority(EntityInteractEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onInteractLowestPriority(EntityInteractEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onProjectileLaunch(ProjectileLaunchEvent event) {
		final Projectile bullet = event.getEntity();
		ProjectileSource shooter = bullet.getShooter();
		if ((shooter instanceof Player) && this.plugin.shouldCancelEvent((Player) shooter))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onRegainHealth(EntityRegainHealthEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onShootBow(EntityShootBowEvent event) {
		if (this.plugin.shouldCancelEvent(event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onTarget(EntityTargetEvent event) {
		if (this.plugin.shouldCancelEvent(event.getTarget()))
			event.setCancelled(true);
	}
}
