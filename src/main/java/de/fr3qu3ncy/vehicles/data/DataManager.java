package de.fr3qu3ncy.vehicles.data;

import de.fr3qu3ncy.easyconfig.ConfigIO;
import de.fr3qu3ncy.easyconfig.EasyConfig;
import de.fr3qu3ncy.easyconfig.register.ConfigRegistry;
import de.fr3qu3ncy.vehicles.VehiclesPlugin;
import de.fr3qu3ncy.vehicles.configuration.Vector3;
import de.fr3qu3ncy.vehicles.vehicle.*;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    @Getter
    private final EasyConfig config;

    private final List<EasyConfig> vehicles = new ArrayList<>();

    public DataManager(JavaPlugin plugin) {
        registerSerializers();

        this.config = new EasyConfig(plugin, null, "config");
        this.config.load();

        loadVehicleFiles();
        loadVehicles();
    }

    private void loadVehicleFiles() {
        vehicles.addAll(EasyConfig.loadInDirectory(VehiclesPlugin.getInstance(), "vehicles"));
    }

    public void reloadVehicles() {
        VehicleManager.VEHICLES.clear();
        loadVehicleFiles();
        loadVehicles();
    }

    public EasyConfig createVehicleConfig(String name) {
        EasyConfig vehicleConfig = new EasyConfig(VehiclesPlugin.getInstance(), null, "vehicles", name);
        vehicleConfig.load();
        vehicles.add(vehicleConfig);

        return vehicleConfig;
    }

    private void loadVehicle(EasyConfig vehicleConfig) {
        VehicleManager.VEHICLES.add(ConfigIO.get(vehicleConfig, "", Vehicle.class, Vehicle.class, null));
    }

    private void loadVehicles() {
        vehicles.forEach(this::loadVehicle);
    }

    private void registerSerializers() {
        ConfigRegistry.register(Vehicle.class);
        ConfigRegistry.register(VehiclePart.class);

        ConfigRegistry.register(Vector3.class);

        ConfigRegistry.registerVariableType(VehiclePart.class, location -> {
            PartFunction function = PartFunction.valueOf(location.getInSection("function"));
            return switch (function) {
                case NONE -> VehiclePart.class;
                case SEAT -> VehicleSeat.class;
            };
        });
    }
}
