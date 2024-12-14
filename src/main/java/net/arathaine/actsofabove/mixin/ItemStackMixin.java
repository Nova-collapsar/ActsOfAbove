package net.arathaine.actsofabove.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
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

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow @Nullable public abstract NbtCompound getSubNbt(String key);

    @Shadow public abstract Item getItem();

    @Shadow public abstract boolean hasCustomName();

    @Shadow private boolean empty;

    @Inject(method = "getName",at = @At("HEAD"), cancellable = true)
    public void AOA$getName(CallbackInfoReturnable<Text> cir) {
        if (getItem() instanceof ColoredNameItem color) {
            ItemStack that = (ItemStack)(Object)this;
            NbtCompound nbtCompound = getSubNbt("display");
            if (nbtCompound != null && nbtCompound.contains("Name", 8)) {
                    MutableText text = Text.Serializer.fromJson(nbtCompound.getString("Name"));
                    if (text != null) {
                        Style style = text.getStyle();
                        style.withColor(color.getColor(that));
                        cir.setReturnValue(text.setStyle(style));
                    }

            }else {
                MutableText text = getItem().getName(that).copy();
                Style style = text.getStyle();
                style.withColor(color.getColor(that));
                cir.setReturnValue(text.setStyle(style));
            }
        }
    }

    @Inject(method = "toHoverableText",at = @At("HEAD"), cancellable = true)
    public void AOA$getHoverName(CallbackInfoReturnable<Text> cir) {
        if (getItem() instanceof ColoredNameItem color) {
            ItemStack that = (ItemStack)(Object)this;

            MutableText mutableText = Text.empty().append(that.getName());
            if (hasCustomName()) {
                mutableText.formatted(Formatting.ITALIC);
            }
            MutableText mutableText2 = Texts.bracketed(mutableText);
            if (!empty) {
                mutableText2.styled((style) -> style.withColor(color.getColor(that)).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new HoverEvent.ItemStackContent(that))));
            }
            cir.setReturnValue(mutableText2);
        }
    }

    @ModifyExpressionValue(method = "getTooltip",at = @At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
    public MutableText AOA$getToolTipName(MutableText original) {
        if (getItem() instanceof ColoredNameItem color) {
            ItemStack that = (ItemStack) (Object) this;
            Style style = original.getStyle();
            style.withColor(color.getColor(that));
            return original.setStyle(style);
        }
        return original;
    }


}
