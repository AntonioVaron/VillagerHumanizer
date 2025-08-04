package net.anse.villagerhumanizer;

import net.anse.villagerhumanizer.client.renderer.ConditionalHumanVillagerRenderer;
import net.anse.villagerhumanizer.client.renderer.HumanVillagerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class VillagerRendererReplacer {

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                EntityType.VILLAGER,
                (EntityRendererProvider.Context context) -> new ConditionalHumanVillagerRenderer(context)
        );
    }
}
