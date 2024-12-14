package net.arathaine.actsofabove.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

public class WatcherItem extends SwordItem implements CustomAttackItem{
    public WatcherItem(ToolMaterial material, Settings settings) {
        super(material,3,-2.4f, settings);
    }

    @Override
    public boolean shouldSweep(ItemStack stack) {
        // so you can sweep
        return true;
    }

    @Override
    public boolean originalSweep(boolean canCritical, boolean canKnockBack, boolean isItemCharged, PlayerEntity player) {
        // so you can sweep even when doing a critical hit
        return isItemCharged && !canKnockBack && player.horizontalSpeed-player.prevHorizontalSpeed < (double)player.getMovementSpeed();
    }
}
