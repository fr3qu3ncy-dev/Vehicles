package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.vehicles.VehiclesPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class VehicleInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity interacted = event.getRightClicked();

        Vehicle vehicle = VehiclesPlugin.getInstance().getVehicleManager().getVehicle(interacted);
        if (vehicle != null) {
            event.setCancelled(true);
            VehiclePart part = vehicle.getPart(interacted);
            System.out.println(part instanceof VehicleSeat);
            if (part != null) {
                part.onRightClick(player);
            }
        }
    }
}
