package net.arathaine.actsofabove.mixin;

import net.arathaine.actsofabove.item.ColoredNameItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(method = "getName()Lnet/minecraft/text/Text;",at = @At("HEAD"))
    public void AOA$customName(CallbackInfoReturnable<Text> cir) {

    }

}
