package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.SerializableLocation;
import de.fr3qu3ncy.vehicles.configuration.SerializableRotation;
import de.fr3qu3ncy.vehicles.configuration.SerializableVehiclePart;
import de.fr3qu3ncy.vehicles.util.ItemUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.List;

@NoArgsConstructor
@Getter
public class VehiclePart extends SerializableVehiclePart {

    private Entity entity;

    public VehiclePart(String name, int modelData,
                       SerializableLocation location,
                       SerializableRotation rotation,
                       List<VehiclePart> children) {
        super(name, modelData, location, rotation, children);
    }

    public void spawn(Location location) {
        location = location.clone().add(getLocation().toBukkitLocation(location.getWorld()).toVector());
        this.entity = ItemUtils.spawnArmorStand(location, getRotation(), modelData);
    }

    public void remove() {
        entity.remove();
    }
}
