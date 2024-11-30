package net.arathaine.actsofabove.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.arathaine.actsofabove.ActsOfAbove;

public class ModItemGroup {
    public static  final ItemGroup ACTSOFABOVE = FabricItemGroupBuilder.build(
            new Identifier(ActsOfAbove.MOD_ID, "actsofabove"), () -> new ItemStack(ModItems.THE_WATCHER));
}