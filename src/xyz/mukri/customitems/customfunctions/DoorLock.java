package xyz.mukri.customitems.customfunctions;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import xyz.mukri.customitems.Core;

public class DoorLock implements Listener {
	
	public Core plugin;
	
	public DoorLock(Core plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onAmpaiPintu(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Material block = e.getBlock().getType();
		
		if (block == Material.IRON_DOOR) {
			String displayName = e.getItemInHand().getItemMeta().getDisplayName();
			
			if (displayName.equals("§cLockinator 6000")) {
				p.sendMessage(displayName);
			}
			
		}
	}
	
	@EventHandler
	public void onBukaPintuAssalamualaikum(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block block = e.getClickedBlock();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if (block.getType() == Material.OAK_DOOR) {
				
				e.setCancelled(true);
				
				if (p.isSneaking()) {
					p.sendMessage("pass");
					BlockData doorData = block.getBlockData();
					boolean doorOpen = false;
					Openable open = (Openable) doorData;
					
					if (open.isOpen()) {
						doorOpen = false;
					}
					else {
						doorOpen = true;
					}
					
					open.setOpen(doorOpen);
					block.setBlockData(doorData);
					block.getState().update();
				}				

			}
			
		}
	}
	
}
