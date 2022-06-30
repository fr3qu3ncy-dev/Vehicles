package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.annotation.VariableType;
import de.fr3qu3ncy.vehicles.vehicle.ArmorStandEntity;
import de.fr3qu3ncy.vehicles.vehicle.PartFunction;
import de.fr3qu3ncy.vehicles.vehicle.VehiclePart;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ConfigurableField
@Getter
public class SerializableVehiclePart extends ArmorStandEntity {

    protected PartFunction function;

    @VariableType
    protected List<VehiclePart> children = new ArrayList<>();

    public SerializableVehiclePart(String name, int modelData, SerializableVector locationOffset,
                                   SerializableVector rotationOffset, PartFunction function, List<VehiclePart> children) {
        super(name, modelData, locationOffset, rotationOffset);
        this.function = function;
        this.children = children;
    }
}
