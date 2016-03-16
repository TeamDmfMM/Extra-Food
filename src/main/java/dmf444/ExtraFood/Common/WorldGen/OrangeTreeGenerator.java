package dmf444.ExtraFood.Common.WorldGen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class OrangeTreeGenerator extends BaseTreeGenerator {


    @Override
    IBlockState getHangingBlock() {
        return Blocks.sponge.getDefaultState();
    }

    @Override
    boolean hasHangingBlocks() {
        return true;
    }

    @Override
    IBlockState getLeafBlock() {
        return Blocks.leaves2.getStateFromMeta(1);
    }

    @Override
    IBlockState getWoodBlock() {
        return Blocks.log.getStateFromMeta(1);
    }
}
