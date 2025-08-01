package net.anse.villagerhumanizer.client.renderer;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;

public class VillagerHumanoidRenderState extends HumanoidRenderState {
    private Villager villager;
    private LivingEntity entity;

    public void setVillager(Villager villager) {
        this.villager = villager;
        this.entity = villager;
    }

    public Villager getVillager() {
        return villager;
    }

    public void setEntity(LivingEntity entity) {
        this.entity = entity;
    }

    public LivingEntity getEntity() {
        return entity;
    }
}
