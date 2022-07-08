package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.Vector3;
import de.fr3qu3ncy.vehicles.util.ItemUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public interface Spawnable {

    default ArmorStand spawn(Location location, Vector3 rotation, int modelData) {
        return ItemUtils.spawnArmorStand(location, rotation, modelData);
    }
}
