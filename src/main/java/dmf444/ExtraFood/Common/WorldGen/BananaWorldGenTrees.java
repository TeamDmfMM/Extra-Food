package dmf444.ExtraFood.Common.WorldGen;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BananaWorldGenTrees extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;


    public BananaWorldGenTrees(boolean p_i2027_1_)
    {
        this(p_i2027_1_, 4, 0, 0, false);
    }

    public BananaWorldGenTrees(boolean par1, int treeHeight, int woodType, int leaveType, boolean genVines)
    {
        super(par1);
        this.minTreeHeight = treeHeight;
        this.metaWood = woodType;
        this.metaLeaves = leaveType;
        this.vinesGrow = genVines;
    }
    /*
     * (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, int, int, int)
     */
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int l = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (y >= 1 && y + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = y; i1 <= y + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1)
                {
                    for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {

                            if (!this.isReplaceable(world,new BlockPos(j1, i1, k1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlockState(new BlockPos(x, y - 1, z).down()).getBlock();

                boolean isSoil = block2.canSustainPlant(world,new BlockPos(x, y - 1, z), EnumFacing.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l - 1)
                {
                    block2.onPlantGrow(world,new BlockPos(x, y - 1, z), new BlockPos(x, y, z));
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (k1 = y - b0 + l; k1 <= y + l; ++k1)
                    {
                        i3 = k1 - (y + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = x - l1; i2 <= x + l1; ++i2)
                        {
                            j2 = i2 - x;

                            for (int k2 = z - l1; k2 <= z + l1; ++k2)
                            {
                                int l2 = k2 - z;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || rand.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = world.getBlockState(new BlockPos(i2, k1, k2)).getBlock();

                                    if (block1.isAir(world, new BlockPos(i2, k1, k2)) || block1.isLeaves(world,new BlockPos(i2, k1, k2)))
                                    {
                                        this.func_175905_a(world, new BlockPos(i2, k1, k2), BlockLoader.bananaLeaf, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < l; ++k1)
                    {
                        BlockPos upN = pos.up(k1);
                        block = world.getBlockState(upN).getBlock();

                        if (block.isAir(world,new BlockPos( x, y + k1, z)) || block.isLeaves(world,new BlockPos( x, y + k1, z))) {
                            this.func_175905_a(world,new BlockPos(x, y + k1, z), Blocks.log, this.metaWood);
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (k1 = y - 3 + l; k1 <= y + l; ++k1)
                        {
                            i3 = k1 - (y + l);
                            l1 = 2 - i3 / 2;

                            for (i2 = x - l1; i2 <= x + l1; ++i2)
                            {
                                for (j2 = z - l1; j2 <= z + l1; ++j2)
                                {
                                    BlockPos blockposL = new BlockPos(i2, k1, j2);
                                    if (world.getBlockState(blockposL).getBlock().isLeaves(world, blockposL)) {
                                        BlockPos blockposWest = blockposL.west();
                                        BlockPos blockposEast = blockposL.east();
                                        if (rand.nextInt(25) == 0 && world.getBlockState(blockposWest).getBlock().isAir(world,new BlockPos(i2, k1 - 1, j2)))
                                        {
                                            this.growVines(world, i2, k1 - 1, j2, 1);
                                        }

                                        if (rand.nextInt(15) == 0 && world.getBlockState(blockposEast).getBlock().isAir(world,new BlockPos(i2, k1 - 1, j2)))
                                        {
                                            this.growVines(world, i2, k1 - 1, j2, 1);
                                        }

                                        if (rand.nextInt(15) == 0 && world.isAirBlock(new BlockPos(i2, k1 - 1, j2)))
                                        {
                                            this.growVines(world, i2, k1 - 1, j2, 1);
                                        }

                                        if (rand.nextInt(15) == 0 && world.isAirBlock(new BlockPos(i2, k1 -1, j2)))
                                        {
                                            this.growVines(world, i2, k1 - 1, j2, 1);
                                        }
                                    }
                                }
                            }
                        }

                        /*if (par2Random.nextInt(5) == 0 && l > 5)
                        {
                            for (j1 = 0; j1 < 2; ++j1)
                            {
                                for (k1 = 0; k1 < 4; ++k1)
                                {
                                    if (par2Random.nextInt(4 - j1) == 0)
                                    {
                                        i2 = par2Random.nextInt(3);
                                        this.setBlockAndMetadata(par1World, par3 + Direction.offsetX[Direction.rotateOpposite[k1]], par4 + l - 5 + j1, par5 + Direction.offsetZ[Direction.rotateOpposite[k1]], Block.cocoaPlant.blockID, i2 << 2 | k1);
                                    }
                                }
                            }
                        }*/
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
     */
    private void growVines(World world, int x, int y, int z, int length)
    {
        BlockPos bananaPlace = new BlockPos(x,y,z);
        if(world.getBlockState(bananaPlace).getBlock() == Blocks.air) {
            this.func_175905_a(world, bananaPlace, BlockLoader.bananaBunch, length);
        } else{
            this.growVines(world, x, y - 1, z, 1);
        }
        //this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, BlockLoader.bananaBunch, par5);
    }

	
}

