package xyz.mukri.customitems.customfunctions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import xyz.mukri.customitems.Core;

public class CreeeperCustom implements Listener {
	
	List<Creeper> creeperList =  new ArrayList<Creeper>();
	
	public Core plugin;
	
	public CreeeperCustom(Core plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCreeperKanMelatup(ExplosionPrimeEvent e) {
		if (e.getEntity() instanceof Creeper) {
			final Creeper creeper = (Creeper) e.getEntity();
			
			if (!creeperList.contains(creeper)) {
				creeper.setCustomName("§cAllahu Akhbar!");
				creeper.setCustomNameVisible(true);
				
				creeperList.add(creeper);
				
				e.setCancelled(true);
				
				for (Entity ent : creeper.getNearbyEntities(10, 10, 10)) {
					if (ent instanceof Player) {												
						creeper.getWorld().playSound(creeper.getLocation(),  Sound.ENTITY_GHAST_HURT, 2.0f, 1.5f);
					}
				}
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						e.setCancelled(false);
						
						if (!creeper.isDead()) {
							creeper.setCustomName(null);
							creeper.setCustomNameVisible(false);
						}
						
						if (creeperList.contains(creeper)) {
							creeperList.remove(creeper);
						}
					}
				}, 60);
			}
		}
	}
	

}
