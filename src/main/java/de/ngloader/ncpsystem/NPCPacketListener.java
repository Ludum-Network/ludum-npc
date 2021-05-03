package de.ngloader.ncpsystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;

import de.ngloader.ncpsystem.event.NPCInteractEvent;

public class NPCPacketListener extends PacketAdapter {

	private final NPCSystem system;
	private final ProtocolManager protocolManager;
	private final PluginManager pluginManager;

	public NPCPacketListener(NPCSystem system) {
		super(system.getPlugin(), PacketType.Play.Client.USE_ENTITY);
		this.system = system;
		this.pluginManager = Bukkit.getPluginManager();
		this.protocolManager = ProtocolLibrary.getProtocolManager();

		this.protocolManager.addPacketListener(this);
	}

	public void unregister() {
		this.protocolManager.removePacketListener(this);
	}

	@Override
	public void onPacketReceiving(PacketEvent event) {
		PacketContainer packet = event.getPacket();
		NPC npc = this.system.npcByEntityId.get(packet.getIntegers().read(0));
		if (npc != null) {
			event.setCancelled(true);

			EntityUseAction action = packet.getEntityUseActions().read(0);
			if (action == EntityUseAction.ATTACK) {
				this.callEvent(new NPCInteractEvent(event.getPlayer(), npc, action, null));
			} else if (action == EntityUseAction.INTERACT) {
				this.callEvent(new NPCInteractEvent(event.getPlayer(), npc, action, packet.getHands().read(0)));
			}
		}
	}

	private void callEvent(Event event) {
		Bukkit.getScheduler().runTask(this.plugin, () -> this.pluginManager.callEvent(event));
	}
}