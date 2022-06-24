package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.SerializableVehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;

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
        parts.forEach(vehiclePart -> vehiclePart.spawn(location));
    }

    public void remove() {
        parts.forEach(VehiclePart::remove);
    }
}
