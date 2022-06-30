package de.fr3qu3ncy.vehicles.configuration;

import de.fr3qu3ncy.easyconfig.annotation.ConfigIgnore;
import de.fr3qu3ncy.easyconfig.annotation.ConfigurableField;
import de.fr3qu3ncy.easyconfig.serialization.Configurable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.util.EulerAngle;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ConfigurableField
public class SerializableVector implements Configurable<SerializableVector> {

    @ConfigIgnore
    public static SerializableVector ZERO = new SerializableVector(0, 0, 0);

    private double x;
    private double y;
    private double z;

    public EulerAngle toEuler() {
        double factor = Math.PI / 180;
        return new EulerAngle(x * factor, y * factor, z * factor);
    }
}
