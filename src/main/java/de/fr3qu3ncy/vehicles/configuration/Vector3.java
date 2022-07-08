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
public class Vector3 implements Configurable<Vector3> {

    @ConfigIgnore
    public static Vector3 ZERO = new Vector3(0, 0, 0);

    private double x;
    private double y;
    private double z;

    public Vector3 add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }

    public EulerAngle toEuler() {
        double factor = Math.PI / 180;
        return new EulerAngle(x * factor, y * factor, z * factor);
    }
}
