package net.arathaine.actsofabove.init;

import net.arathaine.actsofabove.item.AboveEyeItem;
import net.arathaine.actsofabove.item.ColorItem;
import net.arathaine.actsofabove.item.WatcherItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.arathaine.actsofabove.ActsOfAbove;

public class AOAItems {

    public static final Item THE_WATCHER = registerItem("the_watcher",
            new WatcherItem(ToolMaterials.NETHERITE, new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).group(AOAItemGroup.ACTS_OF_ABOVE)));
    //couldn't get it to work like a weapon so it,s just an item for now

    public static final Item EYE_OF_ABOVE = registerItem("eye_of_above",
            new AboveEyeItem(new FabricItemSettings().maxCount(64).group(AOAItemGroup.ACTS_OF_ABOVE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, ActsOfAbove.id(name), item);
    }

    public static void registerModItems() {
        ActsOfAbove.LOGGER.debug("Register Mod Items for " + ActsOfAbove.MOD_ID);
    }
}
