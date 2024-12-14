package net.arathaine.actsofabove.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ColorItem extends Item implements ColoredNameItem{
    private final int color;
    public ColorItem(Settings settings, int color) {
        super(settings);
        this.color = color;
    }


    @Override
    public int getColor(ItemStack stack) {
        return color;
    }
}
