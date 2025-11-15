package net.mrpup.mysticshrooms.effect.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.mrpup.mysticshrooms.effect.ModEffects;

public class CheerfulnessEffect extends MobEffect {

    public CheerfulnessEffect(MobEffectCategory category, int color) {
        super(category, color);


        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("mystic_shrooms", "cheerfulness_speed"), 0.20D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath("mystic_shrooms", "cheerfulness_health"), 4.0D, AttributeModifier.Operation.ADD_VALUE);

        this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath("mystic_shrooms", "cheerfulness_jump"), 0.1D, AttributeModifier.Operation.ADD_VALUE);

        this.addAttributeModifier(Attributes.MINING_EFFICIENCY, ResourceLocation.fromNamespaceAndPath("mystic_shrooms", "cheerfulness_mining"), 1.0D, AttributeModifier.Operation.ADD_VALUE);
    }


    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {

    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        MobEffectInstance effectInstance = entity.getEffect(ModEffects.CHEERFULNESS);
        if (effectInstance == null) return false;

        int remaining = effectInstance.getDuration();
        if (remaining <= 10) {
            int sleepVisualTicks = 6000;
            entity.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, sleepVisualTicks, 0, false, false, false));
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
