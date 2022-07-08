package de.fr3qu3ncy.vehicles.vehicle;

import de.fr3qu3ncy.easyconfig.annotation.ConfigIgnore;
import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import de.fr3qu3ncy.vehicles.configuration.Vector3;
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

    protected Vector3 locationOffset;
    protected Vector3 rotationOffset;

    @ConfigIgnore
    @Nullable
    @Getter
    protected ArmorStand armorStand;

    protected ArmorStandEntity(String name, int modelData, Vector3 locationOffset, Vector3 rotationOffset) {
        this.name = name;
        this.modelData = modelData;
        this.locationOffset = locationOffset;
        this.rotationOffset = rotationOffset;
    }

    public void spawn(Location location, Vector3 rotation) {
        Location finalLocation = location.clone().add(locationOffset.getX(), locationOffset.getY(), locationOffset.getZ());
        Vector3 finalRotation = new Vector3(
            rotation.getX() + rotationOffset.getX(),
            rotation.getY() + rotationOffset.getY(),
            rotation.getZ() + rotationOffset.getZ());

        this.armorStand = ItemUtils.spawnArmorStand(finalLocation, finalRotation, modelData);
    }

    public void rotate(Vector3 rotation) {
        rotationOffset.add(rotation);
        setRotation(rotationOffset);
    }

    public void setRotation(Vector3 rotation) {
        if (armorStand == null) return;
        this.rotationOffset = rotation;
        armorStand.setHeadPose(rotation.toEuler());
    }

    public void remove() {
        if (armorStand != null) armorStand.remove();
    }

    public void onRightClick(Player player) {}
}
