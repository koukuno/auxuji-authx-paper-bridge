package sh.auxuji.authx.paper.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import sh.auxuji.authx.paper.AuthX;

public class BlockListener implements Listener {
	private final AuthX plugin;

	public BlockListener(AuthX plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlace(BlockPlaceEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true)
	public void onBreak(BlockBreakEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
	public void onSignChange(SignChangeEvent event) {
		if (this.plugin.shouldCancelEvent(event.getPlayer()))
			event.setCancelled(true);
	}
}
