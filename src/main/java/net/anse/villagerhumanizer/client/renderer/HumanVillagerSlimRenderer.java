package net.anse.villagerhumanizer.client.renderer;

import net.anse.villagerhumanizer.client.VillagerTextureManager;
import net.anse.villagerhumanizer.compat.VillagerCapabilityCompat;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

public class HumanVillagerSlimRenderer extends HumanVillagerRenderer {

    public HumanVillagerSlimRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM)));
    }

    @Override
    public ResourceLocation getTextureLocation(VillagerHumanoidRenderState state) {
        Villager villager = state.getVillager();

        if (villager == null) {
            return ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/female/skin/skin1.png"); // fallback
        }

        return VillagerTextureManager.getSkin(villager);
    }
}
