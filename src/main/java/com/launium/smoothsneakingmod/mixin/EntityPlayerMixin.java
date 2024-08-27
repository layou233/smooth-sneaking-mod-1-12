package com.launium.smoothsneakingmod.mixin;

import com.launium.smoothsneakingmod.SmoothSneakingState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin {

    @Unique
    private SmoothSneakingState smoothSneakingState = new SmoothSneakingState();

    @Inject(method = "getEyeHeight", at = @At(value = "RETURN"), cancellable = true)
    public void getEyeHeightForSmoothSneaking(CallbackInfoReturnable<Float> cir) {
        float returnValue = cir.getReturnValue();
        boolean isSneaking = ((Entity) (Object) this).isSneaking();
        if (isSneaking) returnValue += 0.08F;
        cir.setReturnValue(returnValue + smoothSneakingState.getSneakingHeightOffset(isSneaking));
    }

}
