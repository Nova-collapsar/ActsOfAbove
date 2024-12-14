package net.arathaine.actsofabove;

import net.arathaine.actsofabove.datagen.AOAModelGenerator;
import net.arathaine.actsofabove.datagen.AOARecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ActsOfAboveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(AOARecipeGenerator::new);
		fabricDataGenerator.addProvider(AOAModelGenerator::new);
	}
}
