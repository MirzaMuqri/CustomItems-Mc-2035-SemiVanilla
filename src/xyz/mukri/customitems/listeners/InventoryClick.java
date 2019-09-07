package xyz.mukri.customitems.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import xyz.mukri.customitems.Core;

public class InventoryClick implements Listener {
	
	public Core plugin;
	
	public InventoryClick(Core plugin) {	
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClickInv(InventoryClickEvent e) {
		InventoryView view = e.getWhoClicked().getOpenInventory();
		Player p = (Player) e.getWhoClicked();
		
		if (view == null) return;
		
		if (view.getTitle().equals("§8Si Bagang Shop")) {
			e.setCancelled(true);
			
			if (e.getSlot() == 0) {
				int price = 32;
				purchaseItems(p, price, e.getCurrentItem());
			}
			
			if (e.getSlot() == 1) {
				int price = 32;
				purchaseItems(p, price, e.getCurrentItem());
			}
			
			if (e.getSlot() == 2) {
				int price = 100;
				purchaseItems(p, price, e.getCurrentItem());
			}
		}
	}
	
	public void purchaseItems(Player p, int price, ItemStack purchasedItems) {
		int amt = 0;
		
		for (ItemStack items : p.getInventory().getContents()) {
			if (items == null) continue; 
			
			if (items.getType() == Material.GOLD_BLOCK) {
				amt += items.getAmount();
			}
		}
		
		if (amt >= price) {
			if (p.getInventory().firstEmpty() == -1) {
				p.closeInventory();
				p.sendMessage("§7Your inventory is full!");
			}
			else {
				p.closeInventory();
				p.getInventory().removeItem(new ItemStack(Material.GOLD_BLOCK, price));
				p.getInventory().addItem(purchasedItems);
				p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 0.5f);
			}
		}
		else {
			p.closeInventory();
			p.sendMessage("§7You don't have enough gold!");
		}
	}

}
