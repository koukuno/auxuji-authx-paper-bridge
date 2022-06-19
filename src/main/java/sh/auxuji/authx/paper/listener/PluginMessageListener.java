package sh.auxuji.authx.paper.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import java.util.UUID;
import org.bukkit.entity.Player;
import sh.auxuji.authx.paper.AuthX;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {
	private final AuthX plugin;

	public PluginMessageListener(AuthX plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onPluginMessageReceived(String identifier, Player player, byte[] data) {
		this.plugin.getLogger().info(String.format("Received data from: %s", identifier));
		if (!identifier.equals("authxv:main"))
			return;

		ByteArrayDataInput stream = ByteStreams.newDataInput(data);

		String uuidstr = stream.readUTF();
		UUID uuid = UUID.fromString(uuidstr);

		String msg = stream.readUTF();

		this.plugin.getLogger().info(String.format("uuid:%s message:%s", uuid, msg));
		this.plugin.processMessage(uuid, msg);
	}
}
