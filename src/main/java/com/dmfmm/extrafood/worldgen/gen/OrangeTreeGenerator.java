package com.dmfmm.extrafood.worldgen.gen;


import com.dmfmm.extrafood.init.BlockLoader;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class OrangeTreeGenerator extends BaseTreeGenerator {


    @Override
    protected IBlockState getLeafBlockWithoutCheckDecay() {
        return Blocks.LEAVES2.getStateFromMeta(1).withProperty(BlockLeaves.CHECK_DECAY, false).withProperty(BlockLeaves.DECAYABLE, true);
    }

    @Override
    IBlockState getHangingBlock() {
        return BlockLoader.ORANGE_CROP.getDefaultState();
    }

    @Override
    boolean hasHangingBlocks() {
        return true;
    }

    @Override
    IBlockState getLeafBlock() {
        return Blocks.LEAVES2.getStateFromMeta(1);
    }

    @Override
    IBlockState getWoodBlock() {
        return Blocks.LOG.getStateFromMeta(1);
    }
}