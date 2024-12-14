package net.arathaine.actsofabove;

import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActsOfAbove implements ModInitializer {
	public static final String MOD_ID = "actsofabove";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		AOAItems.registerModItems();

	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
