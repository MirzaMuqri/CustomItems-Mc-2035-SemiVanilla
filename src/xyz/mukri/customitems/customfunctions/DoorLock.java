package xyz.mukri.customitems.customfunctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
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

		if (block == Material.OAK_DOOR) {
			String displayName = e.getItemInHand().getItemMeta().getDisplayName();

			if (displayName.equals("§cLockinator 6000")) {
				plugin.doorFile.addNewDoor(e.getBlock().getLocation(), p);
				plugin.doorFile.save();
			}

		}
	}

	@EventHandler
	public void onRedstone(BlockRedstoneEvent e) {
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				for (int z = -1; z < 2; z++) {
					if (e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().getBlockX() + x,
							e.getBlock().getLocation().getBlockY() + y, e.getBlock().getLocation().getBlockZ() + z)
							.getType() == Material.OAK_DOOR) {
						Bukkit.broadcastMessage("Finally found Redstonepower at Door!");
						e.setNewCurrent(100);
					}
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlaceTorch(BlockPlaceEvent e) {
		Block block = e.getBlock();
		
		if (block.getType() == Material.REDSTONE_TORCH) {
			if (block.getRelative(BlockFace.EAST).getType() == Material.OAK_DOOR) {
				e.setCancelled(true);
				
				BlockData doorData = block.getRelative(BlockFace.EAST).getBlockData();
				stopDoorFromOpening(doorData, block.getRelative(BlockFace.EAST));
			}
			
			if (block.getRelative(BlockFace.NORTH).getType() == Material.OAK_DOOR) {
				e.setCancelled(true);
				
				BlockData doorData = block.getRelative(BlockFace.NORTH).getBlockData();
				stopDoorFromOpening(doorData, block.getRelative(BlockFace.NORTH));
			}
			
			if (block.getRelative(BlockFace.SOUTH).getType() == Material.OAK_DOOR) {
				e.setCancelled(true);
				
				BlockData doorData = block.getRelative(BlockFace.SOUTH).getBlockData();
				stopDoorFromOpening(doorData, block.getRelative(BlockFace.SOUTH));
			}
			
			if (block.getRelative(BlockFace.WEST).getType() == Material.OAK_DOOR) {
				e.setCancelled(true);
				
				BlockData doorData = block.getRelative(BlockFace.WEST).getBlockData();
				stopDoorFromOpening(doorData, block.getRelative(BlockFace.WEST));
			}
		}
	}

	@EventHandler
	public void onBukaPintuAssalamualaikum(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block block = e.getClickedBlock();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (block.getType() == Material.OAK_DOOR) {

				if (plugin.doorFile.isDoorLocked(block.getLocation())) {
					p.sendMessage("yes");
				} else {
					p.sendMessage("no");
				}

				e.setCancelled(true);

				if (p.isSneaking()) {
					BlockData doorData = block.getBlockData();
					boolean doorOpen = false;
					Openable open = (Openable) doorData;

					if (open.isOpen()) {
						doorOpen = false;
					} else {
						doorOpen = true;
					}

					open.setOpen(doorOpen);
					block.setBlockData(doorData);
					block.getState().update();
				}

			}

		}
	}
	
	public void stopDoorFromOpening(BlockData doorData, Block block) {
		boolean doorOpen = false;
		Openable open = (Openable) doorData;

		if (open.isOpen()) {
			doorOpen = true;
		} else {
			doorOpen = false;
		}

		open.setOpen(doorOpen);
		block.setBlockData(doorData);
		block.getState().update();
	}

}
