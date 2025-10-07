package net.mrpup.mysticshrooms.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.mrpup.mysticshrooms.effect.ModEffects;

public class SomnolenceEffect extends StatusEffect {

    public SomnolenceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof net.minecraft.entity.player.PlayerEntity player) {
            int duration = entity.getStatusEffect(ModEffects.SOMNOLENCE).getDuration();
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    duration,
                    0,
                    false,
                    false,
                    false
            ));
        }
    }



    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (world.isClient) return false;

        StatusEffectInstance inst = entity.getStatusEffect(ModEffects.SOMNOLENCE);
        if (inst == null) return false;

        int remaining = inst.getDuration();
        if (remaining <= 10) {
            int sleepVisualTicks = 100;
            StatusEffectInstance blind = new StatusEffectInstance(StatusEffects.BLINDNESS, sleepVisualTicks, 0, false, false, false);
            StatusEffectInstance heavySlow = new StatusEffectInstance(StatusEffects.SLOWNESS, sleepVisualTicks, 255, false, false, false);

            entity.addStatusEffect(blind);
            entity.addStatusEffect(heavySlow);
        }

        if (remaining <= 1) {

            long now = world.getTimeOfDay();
            world.setTimeOfDay(now + 12000L);

        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
