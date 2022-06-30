package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.VehiclesConfig;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManager {

    @Getter
    private final List<Vehicle> activeVehicles = new ArrayList<>();

    public void spawnVehicle(String name, Location location) {
        Vehicle vehicle = getVehicle(name);
        if (vehicle == null) return;

        vehicle.spawn(location);
        activeVehicles.add(vehicle);
    }

    public void respawnVehicles() {
        Map<String, Location> oldLocations = new HashMap<>();
        activeVehicles.forEach(vehicle -> {
            oldLocations.put(vehicle.getName(), vehicle.getSpawnLocation());
            vehicle.remove();
        });
        oldLocations.forEach(this::spawnVehicle);
    }

    @Nullable
    public Vehicle getVehicle(String name) {
        return VehiclesConfig.VEHICLES.stream()
            .filter(vehicle -> vehicle.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    @Nullable
    public Vehicle getVehicle(Entity entity) {
        return activeVehicles.stream()
            .filter(vehicle -> vehicle.getParts().stream().anyMatch(part -> entity.equals(part.getArmorStand())))
            .findFirst().orElse(null);
    }
}
