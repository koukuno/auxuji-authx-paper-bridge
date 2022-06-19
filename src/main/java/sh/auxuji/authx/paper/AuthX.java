package sh.auxuji.authx.paper;

import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sh.auxuji.authx.paper.listener.BlockListener;
import sh.auxuji.authx.paper.listener.EntityListener;
import sh.auxuji.authx.paper.listener.InventoryListener;
import sh.auxuji.authx.paper.listener.PlayerListener;
import sh.auxuji.authx.paper.listener.PluginMessageListener;

public class AuthX extends JavaPlugin {
	public static final String CHANNEL = "authxv:main";

	private Set<UUID> frozenPlayers;

	private Server server;

	@Override
	public void onEnable() {
		this.server = this.getServer();

		// we only need to listen for incoming messages from the Velocity proxy
		// in order to for example, unfreeze the player character and let them see chunks after login
		this.server.getMessenger().registerIncomingPluginChannel(this, CHANNEL, new PluginMessageListener(this));
		this.server.getPluginManager().registerEvents(new BlockListener(this), this);
		this.server.getPluginManager().registerEvents(new EntityListener(this), this);
		this.server.getPluginManager().registerEvents(new InventoryListener(this), this);
		this.server.getPluginManager().registerEvents(new PlayerListener(this), this);

		this.frozenPlayers = new HashSet<UUID>();
		this.getLogger().info("|| AuthX Adapter Initialized ||");
	}

	public void processMessage(UUID uuid, String msg) {
		if (msg.equals("login"))
			this.frozenPlayers.remove(uuid);
	}

	public void freezePlayer(UUID uuid) {
		this.frozenPlayers.add(uuid);
	}

	public boolean isPlayerFrozen(UUID uuid) {
		return this.frozenPlayers.contains(uuid);
	}

	public boolean shouldCancelEvent(Entity entity) {
		return (entity instanceof Player) && this.shouldCancelEvent((Player) entity);
	}

	public boolean shouldCancelEvent(Player player) {
		return player != null && this.isPlayerFrozen(player.getUniqueId()) && !player.hasMetadata("NPC");
	}
}
