package net.mrpup.mysticshrooms.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.effect.custom.AntiPhantom;
import net.mrpup.mysticshrooms.effect.custom.CheerfulnessEffect;
import net.mrpup.mysticshrooms.effect.custom.SomnolenceEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MysticShrooms.MOD_ID);

    public static final Holder<MobEffect> SOMNOLENCE = MOB_EFFECTS.register("somnolence",
            () -> new SomnolenceEffect(MobEffectCategory.NEUTRAL, 0xE6B800));

    public static final Holder<MobEffect> CHEERFULNESS = MOB_EFFECTS.register("cheerfulness",
            () -> new CheerfulnessEffect(MobEffectCategory.NEUTRAL, 0x808080));

    public static final Holder<MobEffect> ANTI_PHANTOM = MOB_EFFECTS.register("anti_phantom",
            () -> new AntiPhantom(MobEffectCategory.NEUTRAL, 0x808080));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}