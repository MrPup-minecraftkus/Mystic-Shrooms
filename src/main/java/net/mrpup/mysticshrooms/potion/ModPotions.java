package net.mrpup.mysticshrooms.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> SOMNOLENCE_POTION = registerPotion("somnolence_potion",
            new Potion("somnolence_potion", new StatusEffectInstance(ModEffects.SOMNOLENCE, 60, 0)));

    public static final RegistryEntry<Potion> CHEERFULNESS_POTION = registerPotion("cheerfulness_potion",
            new Potion("cheerfulness_potion", new StatusEffectInstance(ModEffects.CHEERFULNESS, 6000, 0)));

    public static final RegistryEntry<Potion> ANTI_PHANTOM_POTION = registerPotion("anti_phantom_potion",
            new Potion("anti_phantom_potion", new StatusEffectInstance(ModEffects.ANTI_PHANTOM, 36000, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(MysticShrooms.MOD_ID, name), potion);
    }

    public static void registerPotions() {
    }
}
