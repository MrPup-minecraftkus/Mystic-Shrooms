package net.mrpup.mysticshrooms.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.effect.ModEffects;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.alchemy.Potion;


public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, MysticShrooms.MOD_ID);

    public static final Holder<Potion> SOMNOLENCE_POTION = POTIONS.register("somnolence_potion",
            () -> new Potion("somnolence_potion", new MobEffectInstance(ModEffects.SOMNOLENCE, 60, 0)));

    public static final Holder<Potion> CHEERFULNESS_POTION = POTIONS.register("cheerfulness_potion",
            () -> new Potion("cheerfulness_potion", new MobEffectInstance(ModEffects.CHEERFULNESS, 6000, 0)));

    public static final Holder<Potion> ANTI_PHANTOM_POTION = POTIONS.register("anti_phantom_potion",
            () -> new Potion("anti_phantom_potion", new MobEffectInstance(ModEffects.ANTI_PHANTOM, 36000, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
