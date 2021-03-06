package keepcalm.mods.bukkit.bukkitAPI.entity;

import keepcalm.mods.bukkit.bukkitAPI.BukkitServer;
import net.minecraft.src.EntityBoat;
//import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class BukkitBoat extends BukkitVehicle implements Boat {
	private double speed = 0.2;
	private double emptySpeed = -1;
    public BukkitBoat(BukkitServer server, EntityBoat entity) {
        super(server, entity);
    }

    public double getMaxSpeed() {
        return getHandle().motionX + 40;
    }

    public void setMaxSpeed(double speed) {
        if (speed >= 0D) {
            //getHandle().maxSpeed = speed;
        }
    }

    public double getOccupiedDeceleration() {
        return speed;
    }

    public void setOccupiedDeceleration(double speed) {
        if (speed >= 0D) {
            this.speed = speed;
        }
    }

    public double getUnoccupiedDeceleration() {
        return emptySpeed;
    }

    public void setUnoccupiedDeceleration(double speed) {
        this.emptySpeed = speed;
    }

    public boolean getWorkOnLand() {
        return false;
    }

    public void setWorkOnLand(boolean workOnLand) {
        //getHandle().landBoats = workOnLand;
    	// FIXME: UNIMPLEMENTED
    }

    @Override
    public EntityBoat getHandle() {
        return (EntityBoat) entity;
    }

    @Override
    public String toString() {
        return "BukkitBoat";
    }

    public EntityType getType() {
        return EntityType.BOAT;
    }
}
