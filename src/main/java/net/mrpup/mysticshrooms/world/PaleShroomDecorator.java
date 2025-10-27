package net.mrpup.mysticshrooms.world;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.mrpup.mysticshrooms.block.ModBlocks;


public class PaleShroomDecorator extends TreeDecorator {
    public static final MapCodec<PaleShroomDecorator> MAP_CODEC = MapCodec.unit(PaleShroomDecorator::new);


    @Override
    protected net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType<?> type() {
        return ModTreeDecorators.PALE_SHROOM_DECORATOR.get();
    }

    @Override
    public void place(net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator.Context context) {
        var random = context.random();
        var world = (WorldGenLevel) context.level();
        var logPositions = context.logs();

        for (BlockPos pos : logPositions) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                if (random.nextFloat() < 0.05f) {
                    BlockPos sidePos = pos.relative(dir);
                    if (world.isEmptyBlock(sidePos)) {
                        world.setBlock(sidePos, ModBlocks.PALE_SHROOM.get().defaultBlockState(), 2);
                    }
                }
            }
        }
    }
}
