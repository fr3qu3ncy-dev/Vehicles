package de.fr3qu3ncy.vehicles.vehicle;

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

    public VehiclePart(String name, int modelData, double x, double y, double z, List<VehiclePart> children) {
        super(name, modelData, x, y, z, children);
    }

    public void spawn(Location location) {
        this.entity = ItemUtils.spawnArmorStand(location.clone().add(x, y, z), modelData);
    }

    public void remove() {
        entity.remove();
    }
}
