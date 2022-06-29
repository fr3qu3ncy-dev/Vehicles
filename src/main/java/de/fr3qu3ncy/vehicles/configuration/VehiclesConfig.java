package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigPath;
import de.fr3qu3ncy.vehicles.vehicle.Vehicle;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;

import java.util.Collections;
import java.util.List;

public class VehiclesConfig {

    private VehiclesConfig() {}

    @ConfigPath("vehicles")
    public static List<Vehicle> VEHICLES = List.of(
        new Vehicle("tank", List.of(
            new VehiclePart("body", 101,
                new SerializableLocation(0, 0, 0),
                new SerializableRotation(0, 0, 0),
                Collections.emptyList()),
            new VehiclePart("head", 102,
                new SerializableLocation(0, 0, 0),
                new SerializableRotation(0, 0, 0),
                Collections.emptyList())
        ))
    );
}
