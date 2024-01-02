package net.sanberdir.lessen192.init.block.custom;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.sanberdir.lessen192.init.block.InitBlocksL192;

public class Chlopok extends CropBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    public Chlopok(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return InitBlocksL192.CHLOPOK.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
