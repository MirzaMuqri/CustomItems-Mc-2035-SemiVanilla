package xyz.mukri.customitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import xyz.mukri.customitems.Core;

public class PotionEffects {

	public static void giveEffects() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), new Runnable() {

			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p == null)
						return;

					ItemStack itemMainHand = p.getInventory().getItemInMainHand();

					if (itemMainHand.getType() == null)
						return;

					if (itemMainHand.getType() == Material.IRON_SWORD) {
						if (itemMainHand.getItemMeta().getDisplayName().equals("§c§lLa Vitesse")) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
						}
					}
				}

			}
		}, 0L, 10L);
	}

}
