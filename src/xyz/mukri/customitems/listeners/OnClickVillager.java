package xyz.mukri.customitems.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import xyz.mukri.customitems.Core;
import xyz.mukri.customitems.utils.CustomInventory;
import xyz.mukri.customitems.utils.Utils;

public class OnClickVillager implements Listener {

	public Core plugin;
	
	public OnClickVillager(Core plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClickVillager(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Villager) {
			Villager  v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();

			if (Utils.isVillagerInArea(v, plugin.loc1, plugin.loc2)) {
				e.setCancelled(true);
				
				CustomInventory.openStoreInv(p);
			}
		}
	}
	
}
