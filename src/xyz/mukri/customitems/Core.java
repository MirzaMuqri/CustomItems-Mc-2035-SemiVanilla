package xyz.mukri.customitems;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.mukri.customitems.listeners.OnBreakBlocks;
import xyz.mukri.customitems.listeners.OnClickVillager;

/*
 * Items list:-
 * 
 * Items | Name | Ability | Price
 * 
 * Diamond Axe => Woodpecker => % of dropping 1 or more woods => 10 Gold Blocks
 * 
 * */

public class Core extends JavaPlugin {
	
	public Core instance;
	
	public void onEnable() {
		instance = this;
		
		registerListeners();
	}
	
	public void onDisable() {
		
	}
	
	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new OnClickVillager(this), this);
		getServer().getPluginManager().registerEvents(new OnBreakBlocks(this), this);
	}

}
