package net.mrpup.mysticshrooms.world;


import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTreeDecorators {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, MysticShrooms.MOD_ID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<PaleShroomDecorator>> PALE_SHROOM_DECORATOR =
            TREE_DECORATORS.register("pale_shroom",
                    () -> new TreeDecoratorType<>(PaleShroomDecorator.MAP_CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<SomnolisDecorator>> SOMNOLIS_DECORATOR =
            TREE_DECORATORS.register("somnolis",
                    () -> new TreeDecoratorType<>(SomnolisDecorator.MAP_CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}

