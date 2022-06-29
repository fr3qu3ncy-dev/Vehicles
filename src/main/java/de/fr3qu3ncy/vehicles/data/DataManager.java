package de.fr3qu3ncy.vehicles.data;

import de.fr3qu3ncy.easyconfig.EasyConfig;
import de.fr3qu3ncy.easyconfig.register.ConfigRegistry;
import de.fr3qu3ncy.vehicles.configuration.SerializableLocation;
import de.fr3qu3ncy.vehicles.configuration.SerializableRotation;
import de.fr3qu3ncy.vehicles.configuration.VehiclesConfig;
import de.fr3qu3ncy.vehicles.vehicle.Vehicle;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class DataManager {

    @Getter
    private final EasyConfig vehiclesConfig;

    public DataManager(JavaPlugin plugin) {
        registerSerializers();

        this.vehiclesConfig = new EasyConfig(plugin, VehiclesConfig.class, "vehicles");
        this.vehiclesConfig.load();
    }

    private void registerSerializers() {
        ConfigRegistry.register(Vehicle.class);
        ConfigRegistry.register(VehiclePart.class);

        ConfigRegistry.register(SerializableLocation.class);
        ConfigRegistry.register(SerializableRotation.class);
    }
}
