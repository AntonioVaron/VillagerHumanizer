package net.anse.villagerhumanizer.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

import java.util.Random;
import java.util.UUID;

public class VillagerTextureManager {
    private static final ResourceLocation[] SKINS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin4.png"),
    };

    private static final ResourceLocation[] FACES = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/face/face1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/face/face2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/face/face3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/face/face4.png"),
    };

    private static final ResourceLocation[] CLOTHES = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/clothes/clothes1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/clothes/clothes2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/clothes/clothes3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/clothes/clothes4.png"),
    };

    private static final ResourceLocation[] HAIRS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/hair/hair1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/hair/hair2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/hair/hair3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/hair/hair4.png"),
    };
/*
    private static int getStableIndex(Villager villager, int length, String seed) {
        String combined = villager.getUUID().toString() + seed;
        return Math.abs(combined.hashCode()) % length;
    }*/

    private static Random getRandomFor(Villager villager) {
        UUID uuid = villager.getUUID();
        return new Random(uuid.hashCode()); // Semilla estable por aldeano
    }

    public static ResourceLocation getSkin(Villager villager) {
        Random random = getRandomFor(villager);
        return SKINS[random.nextInt(SKINS.length)];
    }

    public static ResourceLocation getFace(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt(SKINS.length); // Consumimos 1 para mantener orden
        return FACES[random.nextInt(FACES.length)];
    }

    public static ResourceLocation getClothes(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt(SKINS.length); // piel
        random.nextInt(FACES.length); // cara
        return CLOTHES[random.nextInt(CLOTHES.length)];
    }

    public static ResourceLocation getHair(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt(SKINS.length); // piel
        random.nextInt(FACES.length); // cara
        random.nextInt(CLOTHES.length); // ropa
        return HAIRS[random.nextInt(HAIRS.length)];
    }
}
