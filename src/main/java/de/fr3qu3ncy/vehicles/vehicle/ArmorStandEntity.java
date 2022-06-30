package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.easyconfig.annotation.ConfigIgnore;
import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import de.fr3qu3ncy.vehicles.configuration.SerializableVector;
import de.fr3qu3ncy.vehicles.util.ItemUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@NoArgsConstructor
@ConfigurableField
public abstract class ArmorStandEntity implements Spawnable, Configurable<ArmorStandEntity> {

    protected String name;
    private int modelData;

    protected SerializableVector locationOffset;
    protected SerializableVector rotationOffset;

    @ConfigIgnore
    @Nullable
    @Getter
    protected ArmorStand armorStand;

    protected ArmorStandEntity(String name, int modelData, SerializableVector locationOffset, SerializableVector rotationOffset) {
        this.name = name;
        this.modelData = modelData;
        this.locationOffset = locationOffset;
        this.rotationOffset = rotationOffset;
    }

    public void spawn(Location location, SerializableVector rotation) {
        Location finalLocation = location.clone().add(locationOffset.getX(), locationOffset.getY(), locationOffset.getZ());
        SerializableVector finalRotation = new SerializableVector(
            rotation.getX() + rotationOffset.getX(),
            rotation.getY() + rotationOffset.getY(),
            rotation.getZ() + rotationOffset.getZ());

        this.armorStand = ItemUtils.spawnArmorStand(finalLocation, finalRotation, modelData);
    }

    public void remove() {
        if (armorStand != null) armorStand.remove();
    }

    public void onRightClick(Player player) {}
}
