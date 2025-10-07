package net.mrpup.mysticshrooms.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.mrpup.mysticshrooms.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class AntiPhantom {

    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    private void onSetTarget(LivingEntity target, CallbackInfo ci) {
        MobEntity self = (MobEntity) (Object) this;
        if (self instanceof PhantomEntity && target instanceof PlayerEntity player) {
            if (player.hasStatusEffect(ModEffects.ANTI_PHANTOM)) {
                ci.cancel();
            }
        }
    }
}
