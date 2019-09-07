package xyz.mukri.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import xyz.mukri.customitems.Core;

public class CustomRecipe {

	public static void addDoorRecipe() {
		NamespacedKey lock = new NamespacedKey(Core.getInstance(), "lock_door");
		
		ItemStack item = new ItemStack(Material.IRON_DOOR);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("§cLockinator 6000");
		item.setItemMeta(meta);
		
		ShapedRecipe door = new ShapedRecipe(lock, item);
		
		door.shape("   ", "TDT", " R ");
		
		door.setIngredient('T', Material.TRIPWIRE_HOOK);
		door.setIngredient('D', Material.IRON_DOOR);
		door.setIngredient('R', Material.REDSTONE);
		
		Bukkit.addRecipe(door);
	}
	
}
