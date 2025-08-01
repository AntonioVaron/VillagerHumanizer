package net.anse.villagerhumanizer;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(VillagerHumanizer.MODID)
public class VillagerHumanizer {
    public static final String MODID = "villagerhumanizer";
    static final Logger LOGGER = LogUtils.getLogger();

    public VillagerHumanizer(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Initializing VillagerHumanizer mod");

        // Solo en cliente: registrar renderers
        if (Dist.CLIENT.isClient()) {
            modEventBus.addListener(VillagerRendererReplacer::onRegisterRenderers);
        }

        // Eventos del servidor o comunes
        NeoForge.EVENT_BUS.register(this);

        // Si más adelante necesitas configuración:
        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server starting for VillagerHumanizer");
    }
}
