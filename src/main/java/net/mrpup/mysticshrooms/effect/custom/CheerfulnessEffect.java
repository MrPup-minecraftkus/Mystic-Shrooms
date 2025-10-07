package net.mrpup.mysticshrooms.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.mrpup.mysticshrooms.effect.ModEffects;

public class CheerfulnessEffect extends StatusEffect {

    public CheerfulnessEffect(StatusEffectCategory category, int color) {
        super(category, color);


        this.addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.of("mystic_shrooms", "cheerfulness_speed"), 0.20D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        this.addAttributeModifier(EntityAttributes.MAX_HEALTH, Identifier.of("mystic_shrooms", "cheerfulness_health"), 4.0D, EntityAttributeModifier.Operation.ADD_VALUE);

        this.addAttributeModifier(EntityAttributes.JUMP_STRENGTH, Identifier.of("mystic_shrooms", "cheerfulness_jump"), 0.1D, EntityAttributeModifier.Operation.ADD_VALUE);

        this.addAttributeModifier(EntityAttributes.MINING_EFFICIENCY, Identifier.of("mystic_shrooms", "cheerfulness_mining"), 1.0D, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {

    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (world.isClient) return false;

        StatusEffectInstance inst = entity.getStatusEffect(ModEffects.CHEERFULNESS);
        if (inst == null) return false;

        int remaining = inst.getDuration();
        if (remaining <= 10) {
            int sleepVisualTicks = 6000;
            StatusEffectInstance blind = new StatusEffectInstance(StatusEffects.MINING_FATIGUE, sleepVisualTicks, 0, false, false, false);

            entity.addStatusEffect(blind);
        }

        return true;
    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
