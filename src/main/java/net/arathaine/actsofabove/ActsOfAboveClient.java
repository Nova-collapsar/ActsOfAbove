package net.arathaine.actsofabove;

import net.arathaine.actsofabove.init.AOABlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.model.json.ModelTransformation;

public class ActsOfAboveClient implements ClientModInitializer {

    public static ModelTransformation.Mode currentMode = ModelTransformation.Mode.NONE;

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AOABlocks.ABOVE_END_PORTAL, AboveEndRenderLayer.getRenderLayer());
    }

    static {
        for (ModelTransformation.Mode mode : ModelTransformation.Mode.values()) {
            ModelPredicateProviderRegistry.register(ActsOfAbove.id(mode.name().toLowerCase()), (stack, world, entity, seed) -> mode == currentMode ? 1.0F : 0.0F);
        }
    }
}

