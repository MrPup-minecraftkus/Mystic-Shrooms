package net.mrpup.mysticshrooms.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItemGroups {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysticShrooms.MOD_ID);

    public static final Supplier<CreativeModeTab> MYSTIC_SHROOMS = CREATIVE_MODE_TAB.register("mystic_shrooms",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SOMNOLIS.asItem()))
                    .title(Component.translatable("itemgroup.mystic_shrooms.mystic_shrooms"))
                    .displayItems((itemDisplayParameters, output) -> {


                        output.accept(ModBlocks.SOMNOLIS.asItem());
                        output.accept(ModBlocks.PALE_SHROOM.asItem());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
