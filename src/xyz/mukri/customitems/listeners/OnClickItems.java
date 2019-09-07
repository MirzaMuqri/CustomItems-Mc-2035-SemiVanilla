package xyz.mukri.customitems.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import xyz.mukri.customitems.Core;

public class OnClickItems implements Listener {

	public Core plugin;

	public OnClickItems(Core plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onClickItems(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack items = p.getInventory().getItemInMainHand();

			if (items.getType() == null || items.getType() == Material.AIR)
				return;

			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§c§lRocket LeBoost")) {

				items.setAmount(2);
			}

		}
	}

}
