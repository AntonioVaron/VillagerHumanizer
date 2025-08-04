package net.anse.villagerhumanizer.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.anse.villagerhumanizer.compat.VillagerCapabilityCompat;

import java.util.Random;
import java.util.UUID;

public class VillagerTextureManager {

    // MALE
    private static final ResourceLocation[] MALE_SKINS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/skin/skin1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/skin/skin2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/skin/skin3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/skin/skin4.png"),
    };

    private static final ResourceLocation[] MALE_FACES = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/face/face1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/face/face2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/face/face3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/face/face4.png"),
    };

    private static final ResourceLocation[] MALE_CLOTHES_TOP = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/top-wearing/top1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/top-wearing/top2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/top-wearing/top3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/top-wearing/top4.png"),
    };

    private static final ResourceLocation[] MALE_CLOTHES_BOTTOM = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/bottom-wearing/bottom1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/bottom-wearing/bottom2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/bottom-wearing/bottom3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/bottom-wearing/bottom4.png"),
    };

    private static final ResourceLocation[] MALE_HAIRS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/hair/hair1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/hair/hair2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/hair/hair3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/hair/hair4.png"),
    };

    // FEMALE
    private static final ResourceLocation[] FEMALE_SKINS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/skin/skin1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/skin/skin2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/skin/skin3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/skin/skin4.png"),
    };

    private static final ResourceLocation[] FEMALE_FACES = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/face/face1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/face/face2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/face/face3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/face/face4.png"),
    };

    private static final ResourceLocation[] FEMALE_CLOTHES_TOP = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/top-wearing/top1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/top-wearing/top2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/top-wearing/top3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/top-wearing/top4.png"),
    };

    private static final ResourceLocation[] FEMALE_CLOTHES_BOTTOM = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/bottom-wearing/bottom1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/bottom-wearing/bottom2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/bottom-wearing/bottom3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/bottom-wearing/bottom4.png"),
    };

    private static final ResourceLocation[] FEMALE_HAIRS = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/hair/hair1.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/hair/hair2.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/hair/hair3.png"),
            ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/hair/hair4.png"),
    };

    private static Random getRandomFor(Villager villager) {
        UUID uuid = villager.getUUID();
        return new Random(uuid.hashCode());
    }

    public static ResourceLocation getSkin(Villager villager) {
        Random random = getRandomFor(villager);
        if (VillagerCapabilityCompat.isMale(villager)) {
            return MALE_SKINS[random.nextInt(MALE_SKINS.length)];
        } else {
            return FEMALE_SKINS[random.nextInt(FEMALE_SKINS.length)];
        }
    }

    public static ResourceLocation getClothesBottom(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt();
        if (VillagerCapabilityCompat.isMale(villager)) {
            return MALE_CLOTHES_BOTTOM[random.nextInt(MALE_CLOTHES_BOTTOM.length)];
        } else {
            return FEMALE_CLOTHES_BOTTOM[random.nextInt(FEMALE_CLOTHES_BOTTOM.length)];
        }
    }

    public static ResourceLocation getClothesTop(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt();
        random.nextInt();
        if (VillagerCapabilityCompat.isMale(villager)) {
            return MALE_CLOTHES_TOP[random.nextInt(MALE_CLOTHES_TOP.length)];
        } else {
            return FEMALE_CLOTHES_TOP[random.nextInt(FEMALE_CLOTHES_TOP.length)];
        }
    }

    public static ResourceLocation getHair(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt();
        random.nextInt();
        random.nextInt();
        if (VillagerCapabilityCompat.isMale(villager)) {
            return MALE_HAIRS[random.nextInt(MALE_HAIRS.length)];
        } else {
            return FEMALE_HAIRS[random.nextInt(FEMALE_HAIRS.length)];
        }
    }

    public static ResourceLocation getFace(Villager villager) {
        Random random = getRandomFor(villager);
        random.nextInt();
        random.nextInt();
        random.nextInt();
        random.nextInt();
        if (VillagerCapabilityCompat.isMale(villager)) {
            return MALE_FACES[random.nextInt(MALE_FACES.length)];
        } else {
            return FEMALE_FACES[random.nextInt(FEMALE_FACES.length)];
        }
    }
}
