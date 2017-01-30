package com.dmfmm.extrafood.worldgen.gen;

import com.dmfmm.extrafood.init.BlockLoader;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class BananaTreeGenerator extends BaseTreeGenerator{

    @Override
    protected IBlockState getLeafBlockWithoutCheckDecay() {
        return Blocks.LEAVES2.getStateFromMeta(0).withProperty(BlockLeaves.CHECK_DECAY, false).withProperty(BlockLeaves.DECAYABLE, true);
    }

    @Override
    IBlockState getHangingBlock() {
        return BlockLoader.BANANA_BUNCH.getDefaultState();
    }

    @Override
    boolean hasHangingBlocks() {
        return true;
    }

    @Override
    IBlockState getLeafBlock() {
        return Blocks.LEAVES2.getStateFromMeta(0);
    }

    @Override
    IBlockState getWoodBlock() {
        return Blocks.LOG.getStateFromMeta(3);
    }

    public int getMinTreeHeight() {
        return 5;
    }

}