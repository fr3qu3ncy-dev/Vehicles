package de.fr3qu3ncy.vehicles.util;

import de.fr3qu3ncy.vehicles.configuration.SerializableRotation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

public class ItemUtils {

    private ItemUtils() {}

    public static ArmorStand spawnArmorStand(Location location, SerializableRotation rotation, int customModelData) {
        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.getEquipment().setHelmet(createItem(customModelData));
        armorStand.setHeadPose(new EulerAngle(rotation.getRotationX(), rotation.getRotationY(), rotation.getRotationZ()));
        armorStand.setInvisible(true);
        armorStand.setGravity(false);

        return armorStand;
    }

    private static ItemStack createItem(int customModelData) {
        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(customModelData);
        item.setItemMeta(meta);

        return item;
    }

}
