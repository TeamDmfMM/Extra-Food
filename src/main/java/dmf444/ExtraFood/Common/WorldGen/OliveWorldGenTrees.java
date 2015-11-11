package dmf444.ExtraFood.Common.WorldGen;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;


public class OliveWorldGenTrees extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;

    public OliveWorldGenTrees(boolean p_i2027_1_)
    {
        this(p_i2027_1_, 4, 0, 0, true);
    }

    public OliveWorldGenTrees(boolean par1, int treeHeight, int woodType, int leaveType, boolean genVines)
    {
        super(par1);
        this.minTreeHeight = treeHeight;
        this.metaWood = woodType;
        this.metaLeaves = leaveType;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
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

                            if (!this.isReplaceable(world, j1, i1, k1))
                            {
                             //   flag = false;
                            }
                        }
                        else
                        {
                           // flag = false;
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
                Block block2 = world.getBlock(x, y - 1, z);

                boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l) {
                    block2.onPlantGrow(world, x, y - 1, z, x, y, z);


                    //BUSH SPAWN!!!
                   /* for(int up=0;up<2; up++) {
                        for (int s = 0; s < 3; s++) {
                            for (int la = 0; la < 3; la++) {
                                placeBlock(world, x + s , y + 1+up, x + la , Blocks.diamond_block);
                            }
                        }
                    }*/
                    Block dab = BlockLoader.oliveLeaf;
                    placeBlock(world, x - 1, y+2, z - 1, dab);
                    placeBlock(world, x -1, y+2, z, dab);
                    placeBlock(world, x-1, y+2, z+1, dab);

                    placeBlock(world, x, y+2, z-1, dab);
                    placeBlock(world, x, y+2,z,dab);
                    placeBlock(world,x,y+2, z+1, dab);

                    placeBlock(world, x+1,y+2,z-1,dab);
                    placeBlock(world, x+1, y+2,z,dab);
                    placeBlock(world,x+1,y+2, z+1, dab);

                    //NXT LVL
                    placeBlock(world, x - 1, y+3, z - 1, dab);
                    placeBlock(world, x -1, y+3, z, dab);
                    placeBlock(world, x-1, y+3, z+1, dab);

                    placeBlock(world, x, y+3, z-1, dab);
                    placeBlock(world, x, y+3,z,dab);
                    placeBlock(world,x,y+3, z+1, dab);

                    placeBlock(world, x+1,y+3,z-1,dab);
                    placeBlock(world, x+1, y+3,z,dab);
                    placeBlock(world,x+1,y+3, z+1, dab);

                    //Top et all
                    placeBlock(world, x, y, z, Blocks.log);
                    placeBlock(world, x, y+1, z, Blocks.log);
                    placeBlock(world, x, y+4, z, dab);
                    return true;
                }


            }
        }

        return false;
    }


    private void placeBlock(World world, int x, int y, int z, Block block){
        this.func_150515_a(world, x, y, z, block);
    }
}
