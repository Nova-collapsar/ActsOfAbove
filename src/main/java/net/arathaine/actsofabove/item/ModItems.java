package net.arathaine.actsofabove.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.arathaine.actsofabove.ActsOfAbove;

public class ModItems {

    public static final Item THE_WATCHER = registerItem("the_watcher",
            new Item(new FabricItemSettings().group(ModItemGroup.ACTSOFABOVE)));
    //couldn't get it to work like a weapon so it,s just an item for now

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ActsOfAbove.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ActsOfAbove.LOGGER.debug("Register Mod Items for " + ActsOfAbove.MOD_ID);
    }
}
