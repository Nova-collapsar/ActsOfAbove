package net.arathaine.actsofabove.datagen;

import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookCategory;

import java.util.function.Consumer;

public class AOARecipeGenerator extends FabricRecipeProvider {
    public AOARecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> consumer) {

        ShapedRecipeJsonBuilder.create(AOAItems.EYE_OF_ABOVE)
                .pattern(" n ")
                .pattern("geg")
                .pattern(" g ")
                .input('e', Items.ENDER_EYE)
                .input('n', Items.NETHERITE_SCRAP)
                .input('g', Items.GOLD_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(Items.ENDER_EYE),
                        FabricRecipeProvider.conditionsFromItem(Items.ENDER_EYE))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SCRAP),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_NUGGET),
                        FabricRecipeProvider.conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(consumer);
    }
}
