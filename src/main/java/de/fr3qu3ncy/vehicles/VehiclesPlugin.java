package de.fr3qu3ncy.vehicles;

import co.aikar.commands.PaperCommandManager;
import de.fr3qu3ncy.vehicles.command.VehicleCommand;
import de.fr3qu3ncy.vehicles.data.DataManager;
import de.fr3qu3ncy.vehicles.vehicle.VehicleManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class VehiclesPlugin extends JavaPlugin {

    private PaperCommandManager commandManager;

    @Getter
    private DataManager dataManager;

    @Getter
    private VehicleManager vehicleManager;

    @Override
    public void onEnable() {
        this.dataManager = new DataManager(this);

        this.vehicleManager = new VehicleManager();

        registerCommands();
    }

    private void registerCommands() {
        this.commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new VehicleCommand());
    }

    public static VehiclesPlugin getInstance() {
        return getPlugin(VehiclesPlugin.class);
    }
}
