package net.mrpup.mysticshrooms.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.block.custom.SomnolisBlock;

import java.util.function.Function;

public class ModBlocks {

    public static final Block SOMNOLIS = registerBlock("somnolis",
            properties -> new SomnolisBlock(properties.strength(0.0f)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.ORANGE)
                    .nonOpaque()
                    .noCollision()));

    public static final Block PALE_SHROOM = registerBlock("pale_shroom",
            properties -> new SomnolisBlock(properties.strength(0.0f)
                    .sounds(BlockSoundGroup.GRASS)
                    .mapColor(MapColor.GRAY)
                    .nonOpaque()
                    .noCollision()));



    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MysticShrooms.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MysticShrooms.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MysticShrooms.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MysticShrooms.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
    }
}