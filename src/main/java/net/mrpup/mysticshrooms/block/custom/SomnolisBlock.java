package net.mrpup.mysticshrooms.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

public class SomnolisBlock extends HorizontalFacingBlock {
    public static final MapCodec<SomnolisBlock> CODEC = createCodec(SomnolisBlock::new);

    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 3);

    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 13, 16, 16, 16);

    private static final VoxelShape WEST_SHAPE  = Block.createCuboidShape(0, 0, 0, 3, 16, 16);

    private static final VoxelShape EAST_SHAPE  = Block.createCuboidShape(13, 0, 0, 16, 16, 16);

    public SomnolisBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldView world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        for (Direction dir : ctx.getPlacementDirections()) {
            if (dir.getAxis().isHorizontal()) {
                BlockState state = this.getDefaultState().with(FACING, dir);
                if (state.canPlaceAt(world, pos)) {
                    return state;
                }
            }
        }

        return null;
    }


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction facing = state.get(FACING);
        BlockPos supportPos = pos.offset(facing);
        return world.getBlockState(supportPos).isIn(BlockTags.PALE_OAK_LOGS);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        if (direction == state.get(FACING) && !this.canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, net.minecraft.block.ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH: return NORTH_SHAPE;
            case SOUTH: return SOUTH_SHAPE;
            case WEST:  return WEST_SHAPE;
            case EAST:  return EAST_SHAPE;
            default:    return VoxelShapes.fullCube();
        }
    }
}
