package keepcalm.mods.bukkit.bukkitAPI.entity;

import keepcalm.mods.bukkit.bukkitAPI.BukkitServer;
import net.minecraft.src.EntityAgeable;

//import org.bukkit.craftbukkit.BukkitServer;
import org.bukkit.entity.Ageable;

public class BukkitAgeable extends BukkitCreature implements Ageable {
    public BukkitAgeable(BukkitServer server, EntityAgeable entity) {
        super(server, entity);
    }

    public int getAge() {
        return getHandle().getAge();
    }

    public void setAge(int age) {
        getHandle().ticksExisted = (age);
    }

    public void setAgeLock(boolean lock) {
        //getHandle() = lock;
    }

    public boolean getAgeLock() {
        return false;
    }

    public void setBaby() {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    public void setAdult() {
        if (!isAdult()) {
            setAge(0);
        }
    }

    public boolean isAdult() {
        return getAge() >= 0;
    }


    public boolean canBreed() {
        return getAge() == 0;
    }

    public void setBreed(boolean breed) {
        if (breed) {
            setAge(0);
        } else if (isAdult()) {
            setAge(6000);
        }
    }
    
    @Override
    public EntityAgeable getHandle() {
        return (EntityAgeable) entity;
    }
    
    @Override
    public String toString() {
        return "BukkitAgeable";
    }
}
