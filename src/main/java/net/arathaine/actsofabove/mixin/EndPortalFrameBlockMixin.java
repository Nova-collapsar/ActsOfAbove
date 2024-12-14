package net.arathaine.actsofabove.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndPortalFrameBlock.class)
public class EndPortalFrameBlockMixin extends Block {

    @Shadow @Final public static DirectionProperty FACING;
    @Shadow @Final public static BooleanProperty EYE;
    @Shadow @Final protected static VoxelShape FRAME_WITH_EYE_SHAPE;
    @Unique
    private static BooleanProperty ABOVE_EYE;

    public EndPortalFrameBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/EndPortalFrameBlock;setDefaultState(Lnet/minecraft/block/BlockState;)V"))
    private void AOA$customInit(CallbackInfo ci) {
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(EYE, false).with(ABOVE_EYE, false));
    }

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void AOA$custom(CallbackInfo ci) {
        ABOVE_EYE = BooleanProperty.of("above_eye");
    }

    @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
    private void AOA$customOutline(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (state.get(ABOVE_EYE)) {
            cir.setReturnValue(FRAME_WITH_EYE_SHAPE);
        }
    }

    @Inject(method = "getPlacementState", at = @At("HEAD"), cancellable = true)
    private void AOA$customPlacement(ItemPlacementContext ctx, CallbackInfoReturnable<BlockState> cir) {
        cir.setReturnValue(this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(EYE, false).with(ABOVE_EYE,false));
    }

    @Inject(method = "appendProperties", at = @At("HEAD"))
    private void AOA$customProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(ABOVE_EYE);
    }

    static {
        ABOVE_EYE = BooleanProperty.of("above_eye");
    }
}
