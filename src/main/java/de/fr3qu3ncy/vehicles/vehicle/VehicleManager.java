package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.easyconfig.ConfigIO;
import de.fr3qu3ncy.easyconfig.EasyConfig;
import de.fr3qu3ncy.vehicles.VehiclesPlugin;
import de.fr3qu3ncy.vehicles.configuration.Vector3;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;
import java.util.*;

public class VehicleManager {

    public static final List<Vehicle> VEHICLES = new ArrayList<>();

    @Getter
    private final List<Vehicle> activeVehicles = new ArrayList<>();

    public void createVehicle(String name) {
        EasyConfig config = VehiclesPlugin.getInstance().getDataManager().createVehicleConfig(name);
        ConfigIO.set(config, "", Vehicle.class, new Vehicle("tank", List.of(
            new VehiclePart("body", 3,
                new Vector3(0, 0, 0),
                new Vector3(0, 0, 0),
                Collections.emptyList()),
            new VehicleSeat("turret", 1,
                new Vector3(0, 0, 0),
                new Vector3(0, 0, 0),
                List.of(
                    new VehiclePart("barrel", 2,
                        new Vector3(0, 0, 0),
                        new Vector3(0, 0, 0),
                        Collections.emptyList())
                ))
        )), null, null);
    }

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
        return VehicleManager.VEHICLES.stream()
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
