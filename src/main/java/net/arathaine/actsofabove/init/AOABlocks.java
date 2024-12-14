package net.arathaine.actsofabove.init;

import com.mojang.datafixers.types.Type;
import net.arathaine.actsofabove.ActsOfAbove;
import net.arathaine.actsofabove.block.AboveEndPortalBlock;
import net.arathaine.actsofabove.block.entity.AboveEndPortalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class AOABlocks {

    public static final Block ABOVE_END_PORTAL;
    public static final BlockEntityType<AboveEndPortalBlockEntity> ABOVE_END_PORTAL_BLOCK_ENTITY;

    private static Block registerBlocks(String name, Block block) {
        return Registry.register(Registry.BLOCK, ActsOfAbove.id(name), block);
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String name, BlockEntityType.Builder<T> builder) {

        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, name);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, name, builder.build(type));
    }

    public static void registerModBlocks() {
        ActsOfAbove.LOGGER.debug("Register Mod Blocks for " + ActsOfAbove.MOD_ID);
    }

    static {
        ABOVE_END_PORTAL = registerBlocks("above_end_portal",
                new AboveEndPortalBlock(FabricBlockSettings.of(Material.PORTAL, MapColor.BLACK).noCollision().luminance((state) -> 15).strength(-1.0F, 3600000.0F).dropsNothing()));

        ABOVE_END_PORTAL_BLOCK_ENTITY = create("above_end_portal_block_entity",BlockEntityType.Builder.create(AboveEndPortalBlockEntity::new, AOABlocks.ABOVE_END_PORTAL));
    }
}
