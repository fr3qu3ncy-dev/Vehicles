package de.fr3qu3ncy.vehicles.data;

import de.fr3qu3ncy.easyconfig.EasyConfig;
import de.fr3qu3ncy.easyconfig.register.ConfigRegister;
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
        ConfigRegister.register(Vehicle.class);
        ConfigRegister.register(VehiclePart.class);
    }
}
