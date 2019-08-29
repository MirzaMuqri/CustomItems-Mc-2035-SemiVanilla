package xyz.mukri.customitems.utils;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.entity.Villager;

public class Utils {
	public static boolean isVillagerInArea(Villager v, Location loc1, Location loc2) {
		double[] dim = new double[2];

		dim[0] = loc1.getX();
		dim[1] = loc2.getX();
		Arrays.sort(dim);
		if (v.getLocation().getX() > dim[1] || v.getLocation().getX() < dim[0])
			return false;

		dim[0] = loc1.getZ();
		dim[1] = loc2.getZ();
		Arrays.sort(dim);
		if (v.getLocation().getZ() > dim[1] || v.getLocation().getZ() < dim[0])
			return false;

		dim[0] = loc1.getY();
		dim[1] = loc2.getY();
		Arrays.sort(dim);
		if (v.getLocation().getY() > dim[1] || v.getLocation().getY() < dim[0])
			return false;

		return true;
	}
}
