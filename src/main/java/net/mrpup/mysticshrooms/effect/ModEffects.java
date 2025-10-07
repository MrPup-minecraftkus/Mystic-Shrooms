package net.mrpup.mysticshrooms.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.effect.custom.AntiPhantom;
import net.mrpup.mysticshrooms.effect.custom.CheerfulnessEffect;
import net.mrpup.mysticshrooms.effect.custom.SomnolenceEffect;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SOMNOLENCE = registerStatusEffect("somnolence",
            new SomnolenceEffect(StatusEffectCategory.NEUTRAL, 0xE6B800));

    public static final RegistryEntry<StatusEffect> CHEERFULNESS = registerStatusEffect("cheerfulness",
            new CheerfulnessEffect(StatusEffectCategory.NEUTRAL, 0x808080));

    public static final RegistryEntry<StatusEffect> ANTI_PHANTOM = registerStatusEffect("anti_phantom",
            new AntiPhantom(StatusEffectCategory.NEUTRAL, 0x808080));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MysticShrooms.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
    }
}