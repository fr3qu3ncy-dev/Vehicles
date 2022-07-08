package de.fr3qu3ncy.vehicles.util;

import de.fr3qu3ncy.vehicles.configuration.Vector3;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    private ItemUtils() {}

    public static ArmorStand spawnArmorStand(Location location, Vector3 rotationOffset, int customModelData) {
        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.getEquipment().setHelmet(createItem(customModelData));
        armorStand.setHeadPose(rotationOffset.toEuler());
        armorStand.setInvisible(true);
        armorStand.setGravity(false);

        return armorStand;
    }

    private static ItemStack createItem(int customModelData) {
        ItemStack item = new ItemStack(Material.RABBIT_HIDE);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(customModelData);
        item.setItemMeta(meta);

        return item;
    }

}
