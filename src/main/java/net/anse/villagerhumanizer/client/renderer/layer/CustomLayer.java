package net.anse.villagerhumanizer.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.anse.villagerhumanizer.client.renderer.VillagerHumanoidRenderState;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

import java.util.function.Function;

public class CustomLayer<S extends LivingEntityRenderState, M extends HumanoidModel<? super VillagerHumanoidRenderState>> extends RenderLayer<VillagerHumanoidRenderState, M> {
    private final Function<Villager, ResourceLocation> textureGetter;

    public CustomLayer(RenderLayerParent<VillagerHumanoidRenderState, M> parent, Function<Villager, ResourceLocation> textureGetter) {
        super(parent);
        this.textureGetter = textureGetter;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight,
                       VillagerHumanoidRenderState state, float yaw, float pitch) {

        Villager villager = state.getVillager();
        if (villager == null) return;

        ResourceLocation texture = textureGetter.apply(villager);
        if (texture == null) return;

        RenderType renderType = RenderType.entityTranslucent(texture);

        this.getParentModel().renderToBuffer(
                poseStack,
                bufferSource.getBuffer(renderType),
                packedLight,
                LivingEntityRenderer.getOverlayCoords(state, 0),
                -1
        );
    }
}
