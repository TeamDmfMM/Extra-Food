package dmf444.ExtraFood.Common.WorldGen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class BaseTreeGenerator extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int treeHeight = rand.nextInt(getMaxTreeHeight() - getMinTreeHeight()) + getMinTreeHeight();
        if (position.getY() < 1 || position.getY() > 256 - 1 - treeHeight) {
            return false;
        }
        for (int y = position.getY(); y < position.getY() + 1 + treeHeight; y++){
            for (int x = position.getX() - getLeavesWidthAndLength() / 2; x < position.getX() + getLeavesWidthAndLength() / 2 ; x++) {
                for (int z = position.getZ() - getLeavesWidthAndLength() / 2; x < position.getZ() + getLeavesWidthAndLength() / 2 ; x++) {
                    if (!isReplaceable(worldIn, new BlockPos(x, y, z))) {
                        return false;
                    }
                }
            }
        }
        BlockPos down = position.down();
        Block block = worldIn.getBlockState(down).getBlock();
        if (!block.canSustainPlant(worldIn, down, EnumFacing.UP, (IPlantable) Blocks.sapling)) {
            return false;
        }

        // All right. We all good to go. HOLD ON TO YOUR BUTTS!!!


        BlockPos head = new BlockPos(position);

        for (int i = 0; i < treeHeight; i++) {
            worldIn.setBlockState(head, getWoodBlock());
            head = head.up();
        }

        float value = getLeavesWidthAndLength() / getLeavesCanopyHeight();
        float current = getLeavesWidthAndLength();
        int[] height = new int[getLeavesCanopyHeight() + 1];
        for (int i = 0; i < getLeavesCanopyHeight(); i++) {
            height[i] = (int)current;
            current -= value;
            if (current < 2) {
                current = 2;
            }
        }
        height[getLeavesCanopyHeight()] = 1;
        for (int leafLayer = 0; leafLayer < height.length; leafLayer++) {
            int layer = treeHeight - (leafLayer + 1);
            int size = height[leafLayer];
            int startx = position.getX() - (size / 2);
            int startz = position.getZ() - (size / 2);
            for (int x = 0; x < size++; x++) {
                for (int z = 0; z < size; z++) {
                    if (x == 0 && z == 0 || x == size-1 && z == 0 || x == size-1 && z == size-1 || z == size-1 && x == 0) {
                        if (rand.nextInt(4) < 2)
                            continue;
                    }
                    BlockPos blockPos = new BlockPos(x + startx, layer + position.getY(), z + startz);
                    if (worldIn.getBlockState(blockPos.down()).getBlock() == Blocks.air) {
                        continue;
                    }
                    worldIn.setBlockState(blockPos, getLeafBlock());
                }
            }
        }
        return true;
    }


    /**
     * The block used for the leaves of the tree
     *
     * @return the leaf as a blockstate
     */
    private IBlockState getLeafBlock() {
        return null;
    }

    /**
     * The block used for the bark of the tree
     *
     * @return the wood block as a blockstate
     */
    public IBlockState getWoodBlock() {
        return null;
    }

    /**
     * Get the leaves width and height value, used to determine the base size of the leaf canopy. This usually works better with even numbers
     * <br>
     * <br>
     * This is combined with the leaf canopy height to determine the size of each layer of leaf:
     * <br>
     * <br>
     * getLeavesWidthAndLength: 3 getLeavesCanopyHeight: 3 layers: 3x3, 2x2, 2x2, 1x1 <br>
     * getLeavesWidthAndLength: 3 getLeavesCanopyHeight: 2 layers: 3x3, 2x2, 1x1 <br>
     * getLeavesWidthAndLength: 6 getLeavesCanopyHeight: 3 layers: 6x6, 4x4, 2x2, 1x1 <br>
     *
     * @see BaseTreeGenerator#getLeavesCanopyHeight()
     * @return the leaf canopy's base width and length
     */
    public int getLeavesWidthAndLength() {
        return 3;
    }

    /**
     * Get the leaves canopy height, the value used to determine how tall the leaf mass should be.
     *<br><br>
     * For example, if a tree is 5 blocks tall, and the canopy is 3 blocks, leaves occupy the upper 3 blocks; layer 3, 4, and 5
     *<br><br>
     * This value should be no larger that getLeavesWidthAndLength
     *<br><br>
     * @see BaseTreeGenerator#getLeavesWidthAndLength()
     * @return the leaf canopy height
     */
    public int getLeavesCanopyHeight() {
        return 3;
    }

    /**
     * Get the minimum height of the tree bark
     *
     * @return minimum height of tree bark
     */
    public int getMinTreeHeight() {
        return 4;
    }

    /**
     * Get the maximum height of the tree bark
     *
     * @return maximum height of tree bark
     */
    public int getMaxTreeHeight() {
        return 7;
    }

    public boolean isReplaceable(World world, BlockPos pos)
    {
        net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(world, pos) || state.getBlock().isLeaves(world, pos) || state.getBlock().isWood(world, pos) || hasValidMaterialTypeForReplacing(state.getBlock());
    }

    protected boolean hasValidMaterialTypeForReplacing(Block block)
    {
        Material material = block.getMaterial();
        return material == Material.air || material == Material.leaves || block == Blocks.grass || block == Blocks.dirt || block == Blocks.log || block == Blocks.log2 || block == Blocks.sapling || block == Blocks.vine;
    }
}
