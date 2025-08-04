package net.anse.villagerhumanizer.client.renderer;

import net.anse.villagerhumanizer.client.VillagerTextureManager;
import net.anse.villagerhumanizer.client.renderer.layer.CustomLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import com.mojang.blaze3d.vertex.PoseStack;

public class HumanVillagerRenderer extends HumanoidMobRenderer<Villager, VillagerHumanoidRenderState, HumanoidModel<VillagerHumanoidRenderState>> {

    public HumanVillagerRenderer(EntityRendererProvider.Context context, HumanoidModel<VillagerHumanoidRenderState> model) {
        super(context, model, 0.5f);

        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getClothesBottom));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getClothesTop));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getHair));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getFace));
    }

    public HumanVillagerRenderer(EntityRendererProvider.Context context) {
        this(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)));
    }

    @Override
    public ResourceLocation getTextureLocation(VillagerHumanoidRenderState state) {
        Villager villager = state.getVillager();
        if (villager == null) return ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/male/skin/skin1.png"); // fallback
        return VillagerTextureManager.getSkin(villager);
    }

    @Override
    public VillagerHumanoidRenderState createRenderState() {
        return new VillagerHumanoidRenderState();
    }

    @Override
    public void extractRenderState(Villager entity, VillagerHumanoidRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.setVillager(entity);
    }


    @Override
    protected void scale(VillagerHumanoidRenderState renderState, PoseStack poseStack) {
        if (renderState.getVillager().isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

}
