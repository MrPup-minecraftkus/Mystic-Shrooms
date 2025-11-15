package net.mrpup.mysticshrooms.block;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.block.custom.PaleShroomBlock;
import net.mrpup.mysticshrooms.block.custom.SomnolisBlock;
import net.mrpup.mysticshrooms.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MysticShrooms.MOD_ID);


    public static final DeferredBlock<Block> SOMNOLIS = registerBlock("somnolis",
            (properties) -> new SomnolisBlock(properties
                    .strength(0.0f)
                    .noOcclusion()));

    public static final DeferredBlock<Block> PALE_SHROOM = registerBlock("pale_shroom",
            (properties) -> new PaleShroomBlock(properties
                    .strength(0.0f)
                    .noOcclusion()));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}