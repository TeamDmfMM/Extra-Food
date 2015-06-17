package dmf444.ExtraFood.Common.WorldGen;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


public class PeanutWorldGen implements IWorldGenerator {

    public static PeanutWorldGen peanutGen = new PeanutWorldGen();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionId()){
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
            int xs = MathHelper.getRandomIntegerInRange(random, 1, 3);
            int ys = MathHelper.getRandomIntegerInRange(random, 1, 3);
            int xx = x + random.nextInt(15);
            int zz = z + random.nextInt(15);
            int by = world.getChunksLowestHorizon(xx, zz);//MM12 and I argued over this!
            for (int xpos = 0; xpos < xs; xpos++){
                for (int ypos = 0; ypos < ys; ypos++){
                    by = world.getChunksLowestHorizon(xx + xpos, zz + ypos);


                    if (world.getBlockState(new BlockPos(xx + xpos, by, zz + ypos)).getBlock() == Blocks.tallgrass && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos),(IBlockState) new BlockState(BlockLoader.peanutbush));

                    }
                    else if (world.getBlockState(new BlockPos(xx + xpos, by - 1, zz + ypos)).getBlock() == Blocks.grass && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos),(IBlockState) new BlockState(BlockLoader.peanutbush));

                    }

                }
            }
        }


    }
}