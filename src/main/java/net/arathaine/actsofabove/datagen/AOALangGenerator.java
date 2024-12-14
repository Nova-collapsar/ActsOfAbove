package net.arathaine.actsofabove.datagen;

import net.arathaine.actsofabove.init.AOAItemGroup;
import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class AOALangGenerator extends FabricLanguageProvider {
    protected AOALangGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    protected AOALangGenerator(FabricDataGenerator dataGenerator, String languageCode) {
        super(dataGenerator, languageCode);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(AOAItems.THE_WATCHER,"The Watcher");
        translationBuilder.add(AOAItems.EYE_OF_ABOVE,"Eye of Above");
        translationBuilder.add(AOAItemGroup.ACTS_OF_ABOVE,"Acts of Above");
    }
}
