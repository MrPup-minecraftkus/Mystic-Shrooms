package net.mrpup.mysticshrooms.world;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.mrpup.mysticshrooms.block.ModBlocks;


public class PaleShroomDecorator extends TreeDecorator {
    public static final MapCodec<PaleShroomDecorator> MAP_CODEC = MapCodec.unit(PaleShroomDecorator::new);


    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.PALE_SHROOM_DECORATOR;
    }
    @Override
    public void generate(Generator generator) {
        for (BlockPos pos : generator.getLogPositions()) {
            for (Direction dir : Direction.Type.HORIZONTAL) {
                if (generator.getRandom().nextFloat() < 0.05f) {
                    BlockPos sidePos = pos.offset(dir);
                    if (generator.isAir(sidePos)) {
                        generator.replace(sidePos, ModBlocks.PALE_SHROOM.getDefaultState());
                    }
                }
            }
        }
    }
}
