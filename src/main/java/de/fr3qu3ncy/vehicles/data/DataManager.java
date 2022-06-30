package de.fr3qu3ncy.vehicles.data;

import de.fr3qu3ncy.easyconfig.EasyConfig;
import de.fr3qu3ncy.easyconfig.register.ConfigRegistry;
import de.fr3qu3ncy.vehicles.configuration.SerializableVector;
import de.fr3qu3ncy.vehicles.configuration.VehiclesConfig;
import de.fr3qu3ncy.vehicles.vehicle.Vehicle;
import de.fr3qu3ncy.vehicles.vehicle.PartFunction;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import de.fr3qu3ncy.vehicles.vehicle.VehicleSeat;
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

        ConfigRegistry.register(SerializableVector.class);

        ConfigRegistry.registerVariableType(VehiclePart.class, location -> {
            PartFunction function = PartFunction.valueOf(location.getInSection("function"));
            System.out.println("Function: " + function);
            return switch (function) {
                case NONE -> VehiclePart.class;
                case SEAT -> VehicleSeat.class;
            };
        });
    }
}
