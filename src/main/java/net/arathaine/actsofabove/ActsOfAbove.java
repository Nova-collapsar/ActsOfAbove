package net.arathaine.actsofabove;

import net.arathaine.actsofabove.init.AOABlocks;
import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActsOfAbove implements ModInitializer {
	public static final String MOD_ID = "actsofabove";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.END_PORTAL, RenderLayer.getDirectGlint());

		AOAItems.registerModItems();
		AOABlocks.registerModBlocks();

	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
