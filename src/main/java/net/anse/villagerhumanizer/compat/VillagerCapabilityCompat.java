package net.anse.villagerhumanizer.compat;

import net.minecraft.world.entity.npc.Villager;

import java.lang.reflect.Method;

public class VillagerCapabilityCompat {

    private static Class<?> capabilityClass;
    private static Method getOrCreateMethod;
    private static Method isMaleMethod;
    private static boolean initialized = false;

    private static void init() {
        if (initialized) return;

        try {
            capabilityClass = Class.forName("net.anse.callthembytheirname.VillagerCapability");
            getOrCreateMethod = capabilityClass.getMethod("getOrCreate", Villager.class);
            isMaleMethod = capabilityClass.getMethod("isMale");
            initialized = true;
        } catch (Exception e) {

            capabilityClass = null;
            getOrCreateMethod = null;
            isMaleMethod = null;
            initialized = true;
        }
    }

    public static boolean isMale(Villager villager) {
        init();

        try {
            if (capabilityClass == null || getOrCreateMethod == null || isMaleMethod == null)
                return false; // fallback

            // System.out.println("[DEBUG] Checking isMale for villager " + villager.getUUID());
            Object capabilityInstance = getOrCreateMethod.invoke(null, villager);
            boolean male = (boolean) isMaleMethod.invoke(capabilityInstance);
            //System.out.println("[DEBUG] Side: " + (villager.level().isClientSide ? "CLIENT" : "SERVER") +
                    //" | isMale = " + male);
            return (boolean) isMaleMethod.invoke(capabilityInstance);

        } catch (Exception e) {
            return false; // fallback
        }

    }
}
