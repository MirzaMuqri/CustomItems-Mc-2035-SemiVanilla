package xyz.mukri.customitems;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.mukri.customitems.customfunctions.CreeeperCustom;
import xyz.mukri.customitems.listeners.InventoryClick;
import xyz.mukri.customitems.listeners.OnBreakBlocks;
import xyz.mukri.customitems.listeners.OnClickItems;
import xyz.mukri.customitems.listeners.OnClickVillager;
import xyz.mukri.customitems.utils.PotionEffects;

/*
 * Items list:-
 * 
 * Items | Name | Ability | Price
 * 
 * Diamond Axe => Woodpecker => % of dropping 1 or more woods => 10 Gold Blocks
 * 
 * */

public class Core extends JavaPlugin {
	
	public static Core instance;
	
	//Shop Locations
	public Location loc1;
	public Location loc2;
	
	public void onEnable() {
		instance = this;
		
		registerListeners();
		
		loc1 = new Location(Bukkit.getWorld("2035_smp"), -183, 63, 152);
		loc2 = new Location(Bukkit.getWorld("2035_smp"), -178, 67, 146);
		
		PotionEffects.giveEffects();
	}
	
	public void onDisable() {
		
	}
	
	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new OnClickVillager(this), this);
		getServer().getPluginManager().registerEvents(new OnBreakBlocks(this), this);
		getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
		getServer().getPluginManager().registerEvents(new OnClickItems(this), this);
		getServer().getPluginManager().registerEvents(new CreeeperCustom(this), this);
	}
	
	public static Core getInstance() {
		return instance;
	}

}
