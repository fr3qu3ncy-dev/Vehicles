package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigPath;
import de.fr3qu3ncy.vehicles.vehicle.Vehicle;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import de.fr3qu3ncy.vehicles.vehicle.VehicleSeat;

import java.util.Collections;
import java.util.List;

public class VehiclesConfig {

    private VehiclesConfig() {}

    @ConfigPath("vehicles")
    public static List<Vehicle> VEHICLES = List.of(
        new Vehicle("tank", List.of(
            new VehiclePart("body", 3,
                new SerializableVector(0, 0, 0),
                new SerializableVector(0, 0, 0),
                Collections.emptyList()),
            new VehicleSeat("turret", 1,
                new SerializableVector(0, 0, 0),
                new SerializableVector(0, 0, 0),
                List.of(
                    new VehiclePart("barrel", 2,
                        new SerializableVector(0, 0, 0),
                        new SerializableVector(0, 0, 0),
                        Collections.emptyList())
                ))
        ))
    );
}
