package net.sanberdir.lessen192.init.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.sanberdir.lessen192.init.block.InitBlocksL192;
import org.jetbrains.annotations.Nullable;

public class FlameBlockRotate extends RotatedPillarBlock {
    public FlameBlockRotate(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBurning(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 75;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 15;
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        super.onCaughtFire(state, level, pos, direction, igniter);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(InitBlocksL192.CUSTOM_LOG.get())) {
                return InitBlocksL192.STRIPPED_CUSTOM_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(InitBlocksL192.CUSTOM_WOOD.get())) {
                return InitBlocksL192.STRIPPED_CUSTOM_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

}
