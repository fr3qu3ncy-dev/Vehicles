package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ConfigurableField
@Getter
public class SerializableVehiclePart implements Configurable<SerializableVehiclePart> {

    protected String name;
    protected int modelData;

    protected double x;
    protected double y;
    protected double z;

    protected List<VehiclePart> children = new ArrayList<>();

}
