package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.annotation.VariableType;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ConfigurableField
@Getter
public class SerializableVehicle implements Configurable<SerializableVehicle> {

    protected String name;

    @VariableType
    protected List<VehiclePart> parts;

}
