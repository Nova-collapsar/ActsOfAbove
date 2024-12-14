package net.arathaine.actsofabove.mixin;

import net.arathaine.actsofabove.item.CustomAttackItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin{

    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    private void AOA$customAttackItem(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getMainHandStack().getItem() instanceof CustomAttackItem item) {
            item.attack(target, player);
            ci.cancel();
        }
    }
}
