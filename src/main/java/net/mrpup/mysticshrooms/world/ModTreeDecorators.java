package net.mrpup.mysticshrooms.world;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.mrpup.mysticshrooms.MysticShrooms;

public class ModTreeDecorators {

    public static TreeDecoratorType<PaleShroomDecorator> PALE_SHROOM_DECORATOR;

    public static TreeDecoratorType<SomnolisDecorator> SOMNOLIS_DECORATOR;

    public static void register() {
        PALE_SHROOM_DECORATOR = Registry.register(
                Registries.TREE_DECORATOR_TYPE,
                Identifier.of(MysticShrooms.MOD_ID, "pale_shroom"),
                new TreeDecoratorType<>(PaleShroomDecorator.MAP_CODEC)
        );

        SOMNOLIS_DECORATOR = Registry.register(
                Registries.TREE_DECORATOR_TYPE,
                Identifier.of(MysticShrooms.MOD_ID, "somnolis"),
                new TreeDecoratorType<>(SomnolisDecorator.MAP_CODEC)
        );
    }
}

