package com.dmfmm.extrafood.worldgen.spawn;

import com.dmfmm.extrafood.init.BlockLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


public class BushSpawner implements IWorldGenerator {

    public static BushSpawner INSTANCE = new BushSpawner();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        switch(world.provider.getDimension()){
            case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }


    }


    private void generateNether(World world, Random random, int i, int j) {


    }


    private void generateEnd(World world, Random random, int x, int z) {


    }


    private void generateSurface(World world, Random random, int x, int z) {
        if (random.nextInt(45) == 0){
            int xs = (random.nextInt() * 3) + 1;
            int ys = (random.nextInt() * 3) + 1;;
            int xx = x + random.nextInt(15);
            int zz = z + random.nextInt(15);
            int by = world.getHeight(xx, zz);//MM12 and I argued over this! //USED IN CHUNCK.recheckGaps
            for (int xpos = 0; xpos < xs; xpos++){
                for (int ypos = 0; ypos < ys; ypos++){
                    by = world.getHeight(xx + xpos, zz + ypos);
                    IBlockState pie;
                    if(xs > 2) {
                         pie = BlockLoader.PEANUT_BUSH.getDefaultState().withProperty(BlockCrops.AGE, random.nextInt(7));
                    }else{
                        pie = BlockLoader.STRAWBERRY_BUSH.getDefaultState().withProperty(BlockCrops.AGE, random.nextInt(7));
                    }
                    if (world.getBlockState(new BlockPos(xx + xpos, by, zz + ypos)).getBlock() == Blocks.TALLGRASS && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos), pie);

                    }
                    else if (world.getBlockState(new BlockPos(xx + xpos, by - 1, zz + ypos)).getBlock() == Blocks.GRASS && random.nextInt(3) == 0){
                        world.setBlockState(new BlockPos(xx + xpos, by, zz + ypos), pie);

                    }

                }
            }
        }


    }
}