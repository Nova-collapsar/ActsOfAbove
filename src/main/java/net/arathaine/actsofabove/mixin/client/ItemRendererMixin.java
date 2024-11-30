package net.arathaine.actsofabove.mixin.client;

import net.arathaine.actsofabove.item.ModItems;
import net.arathaine.actsofabove.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Unique private static final ModelIdentifier THE_WATCHER_GUI = new ModelIdentifier("actsofabove","the_watcher_gui","inventory");

    @Shadow
    private @Final ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
    private BakedModel actsofabove$rendeGuiModels(BakedModel model, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {

        boolean inventory =
                renderMode == ModelTransformation.Mode.GUI;

        if (inventory) {
            if (stack.isOf(ModItems.THE_WATCHER)) {
                return models.getModelManager().getModel(THE_WATCHER_GUI);
            }
        }

        return model;
    }
}
