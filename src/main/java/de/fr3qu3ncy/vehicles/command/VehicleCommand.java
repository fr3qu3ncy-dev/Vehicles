package de.fr3qu3ncy.vehicles.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import de.fr3qu3ncy.vehicles.VehiclesPlugin;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

@CommandAlias("vehicles|v")
public class VehicleCommand extends BaseCommand {

    @Subcommand("create")
    public static void onCreate(Player player, String vehicleName) {
        if (VehiclesPlugin.getInstance().getVehicleManager().getVehicle(vehicleName) != null) {
            player.sendMessage("§cThis vehicle already exists!");
            return;
        }

        VehiclesPlugin.getInstance().getVehicleManager().createVehicle(vehicleName);
        player.sendMessage("§2Vehicle §f" + vehicleName + " §2has been created!");
    }

    @Subcommand("spawn")
    public static void onSpawn(Player player, String vehicleName) {
        Block targetBlock = player.getTargetBlockExact(50);
        if (targetBlock == null) {
            player.sendMessage("§cYou are not looking at a block!");
            return;
        }

        VehiclesPlugin.getInstance().getVehicleManager().spawnVehicle(vehicleName, targetBlock.getRelative(BlockFace.UP).getLocation());
    }

    @Subcommand("reload")
    public static void onReload(Player player) {
        VehiclesPlugin.getInstance().getDataManager().reloadVehicles();
        VehiclesPlugin.getInstance().getVehicleManager().respawnVehicles();
        player.sendMessage("§2Config has been reloaded.");
    }
}
