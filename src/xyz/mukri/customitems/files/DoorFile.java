package xyz.mukri.customitems.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import xyz.mukri.customitems.Core;

public class DoorFile {

	public File file;
	public FileConfiguration config;
	
	public DoorFile() {
		file = new File(Core.getInstance().getDataFolder(), "door.yml");
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public boolean isFileExists() {
		return file.exists();
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public void save() {
		try {
			
			config.save(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createNewFile() {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		try {
			
			file.createNewFile();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewDoor(Location loc, Player owner) {
		config.set("door." + locationToString(loc) + ".owner", owner.getName());
	}
	
	public void removeDoor(Location loc) {
		config.set("door." + locationToString(loc), null);
	}
	
	public boolean isDoorLocked(Location loc) {
		if (config.isSet("door." + locationToString(loc))) {
			return true;
		}
		
		loc.add(0, -1, 0);
		
		if (config.isSet("door." + locationToString(loc))) {
			return true;
		}
		
		return false;
	}
	
	public String getDoorOwner(Location loc) {
		return config.getString("door." + locationToString(loc) + ".owner");
	}
	
	public boolean isDoorOwner(Player p, Location loc) {
		return getDoorOwner(loc).equals(p.getName());
	}
	
	// Functions that we need for this class
	public String locationToString(Location loc) {
        return loc.getWorld().getName() + "|" + loc.getBlockX() + "|" + loc.getBlockY() + "|" + loc.getBlockZ();
    }
	
	public Location stringToLocation(String s) {
        String[] loc = s.split("|");
        return new Location(Bukkit.getWorld(loc[0]), Integer.parseInt(loc[1]), Integer.parseInt(loc[2]), Integer.parseInt(loc[3]));
    }
	
	
}
