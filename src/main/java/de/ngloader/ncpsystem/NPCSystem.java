package de.ngloader.ncpsystem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import de.ngloader.ncpsystem.util.MCReflectionUtil;
import de.ngloader.ncpsystem.util.ReflectionUtil;

public class NPCSystem implements Listener {

	private static final Field ENTITY_COUNT_FIELD = ReflectionUtil.getField(MCReflectionUtil.getMinecraftServerClass("Entity"), "entityCount");

	private final Plugin plugin;

	private final Random random = new Random();

	private final AtomicInteger entityCount;
	protected final Set<Integer> entityCountIds = new HashSet<>();

	private final Set<Long> uuidInUse = new HashSet<>();
	protected final Map<Integer, NPC> npcByEntityId = new HashMap<>();

	protected final List<NPCRegistry> registries = new ArrayList<>();
	private final NPCRegistry defaultRegistry;

	private final NPCPacketListener packetListener;

	public NPCSystem(Plugin plugin) throws IllegalArgumentException, IllegalAccessException {
		this.plugin = plugin;

		this.entityCount = (AtomicInteger) ENTITY_COUNT_FIELD.get(null);

		this.defaultRegistry = new NPCRegistry(this);
		this.registries.add(this.defaultRegistry);

		this.packetListener = new NPCPacketListener(this);

		Bukkit.getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
			if (player.isOnline()) {
				this.defaultRegistry.showAll(event.getPlayer());
			}
		}, 20);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.registries.forEach(registry -> registry.hideAll(player));
	}

	public NPCRegistry createRegestry() {
		NPCRegistry registry = new NPCRegistry(this);
		this.registries.add(registry);
		return registry;
	}

	public UUID generateUUID() {
		long mostSigBits;
		do
			mostSigBits = this.random.nextLong();
		while (!uuidInUse.add(mostSigBits));
		return new UUID(mostSigBits, 0);
	}

	protected int nextEntityCount() {
		Iterator<Integer> iterator = this.entityCountIds.iterator();
		if (iterator.hasNext()) {
			int entityId = iterator.next();
			iterator.remove();
			return entityId;
		}
		return this.entityCount.incrementAndGet();
	}

	protected void disable() {
		this.packetListener.unregister();
		this.registries.forEach(NPCRegistry::remove);
	}

	public NPCRegistry getDefaultRegistry() {
		return this.defaultRegistry;
	}

	public List<NPCRegistry> getRegistries() {
		return this.registries;
	}

	public NPCPacketListener getPacketListener() {
		return this.packetListener;
	}

	public Plugin getPlugin() {
		return this.plugin;
	}
}