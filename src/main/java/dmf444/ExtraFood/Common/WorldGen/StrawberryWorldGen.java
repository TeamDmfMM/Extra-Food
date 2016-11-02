package dmf444.ExtraFood.Common.WorldGen;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


public class StrawberryWorldGen implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }


    }


    private void generateNether(World world, Random random, int i, int j) {
        // TODO Auto-generated method stub


    }


    private void generateEnd(World world, Random random, int x, int z) {


    }


    private void generateSurface(World world, Random random, int x, int z) {
        if (random.nextInt(45) == 0){
            //EFLog.error("x: " + x + " z: " + z);
            int xs = MathHelper.getRandomIntegerInRange(random, 2, 5);
            int ys = MathHelper.getRandomIntegerInRange(random, 2, 5);
            int xx = x + random.nextInt(15);
            int zz = z + random.nextInt(15);
            int by = this.HackyHackyLevel(new BlockPos(xx, 0, zz), world);
            for (int xpos = 0; xpos < xs; xpos++){
                for (int ypos = 0; ypos < ys; ypos++){
                    by = this.HackyHackyLevel(new BlockPos(xx, 0, zz), world);


                    IBlockState pie = BlockLoader.strawberryBush.getDefaultState();
                    if (world.getBlockState(new BlockPos(xx + xpos, by, zz + ypos)).getBlock() == Blocks.TALLGRASS && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos), pie);
                        //EFLog.error("xx: " + xx + xpos + " zz: " + zz + ypos);
                    }
                    else if (world.getBlockState(new BlockPos(xx + xpos, by - 1, zz + ypos)).getBlock() == Blocks.GRASS && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos), pie);
                        //EFLog.error("xx: " + xx + " zz: " + zz  + "Y:" + by);
                    }
                    //EFLog.error("Block: " + world.getBlockState(new BlockPos(xx + xpos, by, zz + ypos)).getBlock().getUnlocalizedName());
                }
            }
        }
    }
    private int HackyHackyLevel(BlockPos pos, World world){
        BlockPos blockpos1;
        int i = 63;
        for (blockpos1 = new BlockPos(pos.getX(), 63, pos.getZ()); !world.isAirBlock(blockpos1.up()); blockpos1 = blockpos1.up())
        {
            i++;
        }

        return i;
    }
}
