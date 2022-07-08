package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.vehicles.configuration.Vector3;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;

import java.util.List;

@NoArgsConstructor
@ConfigurableField
@Getter
public class VehicleSeat extends VehiclePart implements Mountable {

    public VehicleSeat(String name, int modelData, Vector3 locationOffset,
                       Vector3 rotationOffset, List<VehiclePart> children) {
        super(name, modelData, locationOffset, rotationOffset, PartFunction.SEAT, children);
    }

    @Override
    public void enter(Player player) {
        if (getArmorStand() != null) getArmorStand().addPassenger(player);
    }

    @Override
    public void exit(Player player) {
        if (getArmorStand() != null) getArmorStand().removePassenger(player);
    }

    @Override
    public void onRightClick(Player player) {
        if (getArmorStand() != null) {
            if (!getArmorStand().getPassengers().contains(player)) {
                enter(player);
            } else {
                exit(player);
            }
        }
    }
}
