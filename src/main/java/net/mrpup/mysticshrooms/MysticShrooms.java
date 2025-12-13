package net.mrpup.mysticshrooms;

import net.mrpup.mysticshrooms.block.ModBlocks;
import net.mrpup.mysticshrooms.effect.ModEffects;
import net.mrpup.mysticshrooms.item.ModItemGroups;
import net.mrpup.mysticshrooms.item.ModItems;
import net.mrpup.mysticshrooms.potion.ModPotions;
import net.mrpup.mysticshrooms.world.ModTreeDecorators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(MysticShrooms.MOD_ID)
public class MysticShrooms {

    public static final String MOD_ID = "mystic_shrooms";

    public MysticShrooms(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModItemGroups.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModTreeDecorators.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
