package me.specops.simplewand;

import net.minecraft.server.EntityFireball;
import net.minecraft.server.EntityLiving;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.util.Vector;

public class SimplewandPlayerListener extends PlayerListener {
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_AIR ){
			if(event.getItem() == null)
		return;	
			if (event.getMaterial() == Material.STICK) {	
				  if (!Simplewand.permissionHandler.has(player, "simplewand.fireball")) {
				      return;
				  }
		net.minecraft.server.World notchWorld = null;
		EntityFireball notchEntity = null;
		Vector velocity = null;
		CraftPlayer playerE = null;
		playerE = (CraftPlayer) player;
		Location location = player.getEyeLocation();
		notchWorld = ((CraftWorld) player.getWorld()).getHandle();
		EntityLiving playerEntity = playerE.getHandle();
		notchEntity = new EntityFireball(notchWorld, playerEntity,
		location.getX(), location.getY(), location.getZ());
		velocity = player.getEyeLocation().getDirection().multiply(5);
		notchWorld.addEntity(notchEntity);
		Entity Bukkitentity = notchEntity.getBukkitEntity();
		Bukkitentity.teleport(player.getEyeLocation());
		Bukkitentity.setVelocity(velocity);
		}
		}
	}
}