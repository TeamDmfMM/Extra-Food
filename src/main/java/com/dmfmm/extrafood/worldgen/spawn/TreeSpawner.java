package com.dmfmm.extrafood.worldgen.spawn;

import com.dmfmm.extrafood.worldgen.gen.BananaTreeGenerator;
import com.dmfmm.extrafood.worldgen.gen.OliveTreeGenerator;
import com.dmfmm.extrafood.worldgen.gen.OrangeTreeGenerator;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TreeSpawner implements IWorldGenerator {

    public static TreeSpawner INSTANCE = new TreeSpawner();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }

    }

    private void generateEnd(World world, Random random, int x, int z) {}



    private void generateSurface(World world, Random random, int x, int z) {
        for (int i = 0; i < 3; i++) {
            int Xcoord1 = x + random.nextInt(16); //where in chuck it generates
            int Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
            int Zcoord1 = z + random.nextInt(16); //where in chunk it generates


            final Biome biome = world.getBiomeGenForCoords(new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            BlockPos blockPos = new BlockPos(Xcoord1, Ycoord1, Zcoord1);
            if (world.isAirBlock(blockPos.up()) && world.isAirBlock(blockPos)) {
                new OrangeTreeGenerator().generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            }

            if(biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_EDGE || biome == Biomes.JUNGLE_HILLS) {
                Xcoord1 = x + random.nextInt(16); //where in chuck it generates
                Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
                Zcoord1 = z + random.nextInt(16); //where in chunk it generates
                new BananaTreeGenerator().generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            }else if(shouldTreesSpawn(biome)){
                Xcoord1 = x + random.nextInt(16); //where in chuck it generates
                Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
                Zcoord1 = z + random.nextInt(16); //where in chunk it generates
                int rand = random.nextInt(100);
                if(rand > 75) {
                    new OliveTreeGenerator().generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
                }
            }

        }

    }

    private void generateNether(World world, Random random, int x, int z) {}


    private boolean shouldTreesSpawn(Biome biome){
        if(biome == Biomes.COLD_TAIGA || biome == Biomes.COLD_TAIGA_HILLS || biome == Biomes.DEEP_OCEAN || biome == Biomes.DESERT ||
                biome == Biomes.DESERT_HILLS || biome == Biomes.MUTATED_TAIGA_COLD || biome == Biomes.RIVER || biome == Biomes.MUTATED_TAIGA ||
                biome == Biomes.OCEAN || biome == Biomes.TAIGA || biome == Biomes.TAIGA_HILLS){
            return false;
        }
        return true;
    }

}