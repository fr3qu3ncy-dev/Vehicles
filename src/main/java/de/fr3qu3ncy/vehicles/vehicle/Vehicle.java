package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.Vector3;
import de.fr3qu3ncy.vehicles.configuration.SerializableVehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;
import java.util.List;

@NoArgsConstructor
public class Vehicle extends SerializableVehicle {

    @Getter
    private Location spawnLocation;

    public Vehicle(String name, List<VehiclePart> parts) {
        super(name, parts);
    }

    public void spawn(Location location) {
        this.spawnLocation = location;
        parts.forEach(vehiclePart -> vehiclePart.spawn(location, Vector3.ZERO));
    }

    public void remove() {
        parts.forEach(VehiclePart::remove);
    }

    @Nullable
    public VehiclePart getPart(Entity entity) {
        return getParts().stream().filter(part -> entity.equals(part.getArmorStand())).findFirst().orElse(null);
    }
}
