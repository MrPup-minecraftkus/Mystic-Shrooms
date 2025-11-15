package net.mrpup.mysticshrooms.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.mrpup.mysticshrooms.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class AntiPhantom {

    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    private void onSetTarget(LivingEntity target, CallbackInfo ci) {
        Mob self = (Mob) (Object) this;
        if (self instanceof Phantom && target instanceof Player player) {
            if (player.hasEffect(ModEffects.ANTI_PHANTOM)) {
                ci.cancel();
            }
        }
    }
}
