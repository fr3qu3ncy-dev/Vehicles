package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.configuration.Vector3;
import de.fr3qu3ncy.vehicles.configuration.SerializableVehiclePart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;

import java.util.List;

@NoArgsConstructor
@Getter
public class VehiclePart extends SerializableVehiclePart {

    public VehiclePart(String name, int modelData, Vector3 locationOffset, Vector3 rotationOffset,
                       PartFunction function, List<VehiclePart> children) {
        super(name, modelData, locationOffset, rotationOffset, function, children);
    }

    public VehiclePart(String name, int modelData, Vector3 locationOffset, Vector3 rotationOffset,
                       List<VehiclePart> children) {
        super(name, modelData, locationOffset, rotationOffset, PartFunction.NONE, children);
    }

    @Override
    public void spawn(Location location, Vector3 rotation) {
        super.spawn(location, rotation);
        getChildren().forEach(child -> child.spawn(location, rotation));
    }

    @Override
    public void remove() {
        super.remove();
        children.forEach(VehiclePart::remove);
    }
}
