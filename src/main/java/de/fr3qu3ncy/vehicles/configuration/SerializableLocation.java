package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.World;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ConfigurableField
public class SerializableLocation implements Configurable<SerializableLocation> {

    private double x;
    private double y;
    private double z;

    public Location toBukkitLocation(World world) {
        return new Location(world, x, y, z);
    }
}
