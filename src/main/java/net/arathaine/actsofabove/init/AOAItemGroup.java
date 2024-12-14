package net.arathaine.actsofabove.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.arathaine.actsofabove.ActsOfAbove;

public class AOAItemGroup {
    public static  final ItemGroup ACTS_OF_ABOVE = FabricItemGroupBuilder.build(
            ActsOfAbove.id("actsofabove"), () -> new ItemStack(AOAItems.THE_WATCHER));
}