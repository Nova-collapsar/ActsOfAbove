package net.arathaine.actsofabove.datagen;

import net.arathaine.actsofabove.init.AOAItemGroup;
import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class AOALangGenerator extends FabricLanguageProvider {
    public AOALangGenerator(FabricDataGenerator dataGenerator) {
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
