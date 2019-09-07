package xyz.mukri.customitems.files;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
	
	
	
}
