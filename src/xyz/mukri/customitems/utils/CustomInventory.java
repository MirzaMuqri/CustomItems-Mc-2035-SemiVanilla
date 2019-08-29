package xyz.mukri.customitems.utils;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomInventory {

	public static void openStoreInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§8Si Bagang Shop");
		
		
		inv.addItem(createItem(Material.DIAMOND_AXE, 1, (short) 0, "§c§lWoodPecker", Arrays.asList("§7Extra Wood I", " ", "§cDo not repair or change the name", "§cof the items or it won't work!")));
		
		p.openInventory(inv);
	}
	
	public static ItemStack createItem(Material mat, int amt, short shrt, String name, List<String> lore) {
		ItemStack items = new ItemStack(mat, amt);
		ItemMeta meta = items.getItemMeta();
		
		meta.setDisplayName(name);
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		items.setItemMeta(meta);
		
		return items;
	}
	
}
