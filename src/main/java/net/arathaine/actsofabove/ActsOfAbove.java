package net.arathaine.actsofabove;

import net.arathaine.actsofabove.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActsOfAbove implements ModInitializer {
	public static final String MOD_ID = "actsofabove";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
