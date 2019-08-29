package xyz.mukri.customitems.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import xyz.mukri.customitems.Core;

public class OnBreakBlocks implements Listener {
	
	public Core plugin;
	
	public OnBreakBlocks(Core plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBreakBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Material block = e.getBlock().getType();
		ItemStack items = p.getInventory().getItemInMainHand();
		
		if (items.getType() == null || items.getType() == Material.AIR) return;
		
		if (items.getItemMeta().getDisplayName().equals("§c§lWoodPecker")) {
			if (block == Material.OAK_LOG || block == Material.SPRUCE_LOG || block == Material.BIRCH_LOG || block == Material.JUNGLE_LOG || block == Material.ACACIA_LOG) {
				boolean chance = getChance(100, 0, 20);
				
				if (chance) {
					e.getBlock().getLocation().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0f, 0.2f);
					e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(e.getBlock().getType()));
				}
			}
		}
		
		
	}
	
	public boolean getChance(int max, int min, int chance) {
		int r = new Random().nextInt(max - min + 1) + min;
		
		Bukkit.broadcastMessage(r + " ");
		
		if (chance >= r) {
			return true;
		}
		
		return false;
	}

}
