package net.mrpup.mysticshrooms.world;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.mrpup.mysticshrooms.block.ModBlocks;


public class SomnolisDecorator extends TreeDecorator {
    public static final MapCodec<SomnolisDecorator> MAP_CODEC = MapCodec.unit(SomnolisDecorator::new);


    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorators.SOMNOLIS_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        var random = context.random();
        var world = (WorldGenLevel) context.level();
        var logPositions = context.logs();

        for (BlockPos pos : logPositions) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                if (random.nextFloat() < 0.01f) {
                    BlockPos sidePos = pos.relative(dir);
                    if (world.isEmptyBlock(sidePos)) {

                        var state = ModBlocks.SOMNOLIS.get().defaultBlockState();

                        if (state.hasProperty(BlockStateProperties.FACING)) {
                            state = state.setValue(BlockStateProperties.FACING, dir.getOpposite());
                        }

                        world.setBlock(sidePos, state, 2);
                    }
                }
            }
        }
    }
}
