package net.mrpup.mysticshrooms.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.mrpup.mysticshrooms.effect.ModEffects;

public class SomnolenceEffect extends MobEffect {

    public SomnolenceEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            MobEffectInstance effectInstance = entity.getEffect(ModEffects.SOMNOLENCE);
            if (effectInstance != null) {
                int duration = effectInstance.getDuration();
                player.addEffect(new MobEffectInstance(
                        MobEffects.NAUSEA,
                        duration,
                        0,
                        false,
                        false,
                        false
                ));
            }
        }
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        MobEffectInstance effectInstance = entity.getEffect(ModEffects.SOMNOLENCE);
        if (effectInstance == null) return false;

        int remaining = effectInstance.getDuration();

        if (remaining <= 10) {
            int sleepVisualTicks = 100;
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, sleepVisualTicks, 0, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, sleepVisualTicks, 255, false, false, false));
        }

        if (remaining <= 1 && world != null) {
            long now = world.getDayTime();
            world.setDayTime(now + 12000L);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
