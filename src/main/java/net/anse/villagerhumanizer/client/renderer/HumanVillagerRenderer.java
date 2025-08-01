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
    //private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin.png");

    public HumanVillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

        //this.addLayer(new CustomLayer<>(this, ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/face/face.png")));
        //this.addLayer(new CustomLayer<>(this, ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/clothes/clothes.png")));
        //this.addLayer(new CustomLayer<>(this, ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/hair/hair.png")));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getFace));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getClothes));
        this.addLayer(new CustomLayer<>(this, VillagerTextureManager::getHair));
    }

    @Override
    public ResourceLocation getTextureLocation(VillagerHumanoidRenderState state) {
        Villager villager = state.getVillager();
        if (villager == null) return ResourceLocation.fromNamespaceAndPath("villagerhumanizer", "textures/entity/fullskins/skin/skin1.png"); // fallback
        return VillagerTextureManager.getSkin(villager);
    }

    @Override
    public VillagerHumanoidRenderState createRenderState() {
        return new VillagerHumanoidRenderState();
    }

    @Override
    public void extractRenderState(Villager entity, VillagerHumanoidRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.setVillager(entity); // <--- Aquí inyectamos la entidad en el render state
    }


    @Override
    protected void scale(VillagerHumanoidRenderState renderState, PoseStack poseStack) {
        if (renderState.getVillager().isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

}
