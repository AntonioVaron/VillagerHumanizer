package net.anse.villagerhumanizer.client.renderer;

import net.anse.villagerhumanizer.client.VillagerTextureManager;
import net.anse.villagerhumanizer.compat.VillagerCapabilityCompat;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.RenderLayerParent;

public class ConditionalHumanVillagerRenderer extends HumanoidMobRenderer<Villager, VillagerHumanoidRenderState, HumanoidModel<VillagerHumanoidRenderState>> {

    private final HumanVillagerRenderer defaultRenderer;
    private final HumanVillagerSlimRenderer slimRenderer;

    public ConditionalHumanVillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(net.minecraft.client.model.geom.ModelLayers.PLAYER)), 0.5f);
        this.defaultRenderer = new HumanVillagerRenderer(context);
        this.slimRenderer = new HumanVillagerSlimRenderer(context);
    }

    @Override
    public void render(VillagerHumanoidRenderState state, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        Villager villager = state.getVillager();

        boolean isMale = VillagerCapabilityCompat.isMale(villager);

        if (!isMale) {
            slimRenderer.render(state, poseStack, bufferSource, packedLight);
        } else {
            defaultRenderer.render(state, poseStack, bufferSource, packedLight);
        }
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
    public ResourceLocation getTextureLocation(VillagerHumanoidRenderState state) {
        Villager villager = state.getVillager();
        return VillagerTextureManager.getSkin(villager);
    }
}
