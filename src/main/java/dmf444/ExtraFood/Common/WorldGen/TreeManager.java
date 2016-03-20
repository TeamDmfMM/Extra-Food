package dmf444.ExtraFood.Common.WorldGen;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TreeManager implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }

    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    private void generateSurface(World world, Random random, int x, int z) {
        for (int i = 0; i < 3; i++) {
            int Xcoord1 = x + random.nextInt(16); //where in chuck it generates
            int Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
            int Zcoord1 = z + random.nextInt(16); //where in chunk it generates


            final BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            BlockPos blockPos = new BlockPos(Xcoord1, Ycoord1, Zcoord1);
            if (world.isAirBlock(blockPos.up()) && world.isAirBlock(blockPos)) {
                new OrangeTreeGenerator().generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            }

            if(biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills) {
                Xcoord1 = x + random.nextInt(16); //where in chuck it generates
                Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
                Zcoord1 = z + random.nextInt(16); //where in chunk it generates
                new BananaWorldGenTrees(false, 6, 3, 0, true).generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
            }else if(shouldTreesSpawn(biome)){
                Xcoord1 = x + random.nextInt(16); //where in chuck it generates
                Ycoord1 = random.nextInt(89) + 49; //arg = randge + = min
                Zcoord1 = z + random.nextInt(16); //where in chunk it generates
                int rand = random.nextInt(100);
                if(rand > 75) {
                    new OliveWorldGenTrees(false).generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
                }
            }

        }

    }

    private void generateNether(World world, Random random, int x, int z) {

    }

    private boolean shouldTreesSpawn(BiomeGenBase biome){
        if(biome == BiomeGenBase.coldTaiga || biome == BiomeGenBase.coldTaigaHills || biome == BiomeGenBase.deepOcean || biome == BiomeGenBase.desert ||
                biome == BiomeGenBase.desertHills || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.river || biome == BiomeGenBase.megaTaigaHills ||
                biome == BiomeGenBase.ocean || biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills){
            return false;
        }
        return true;
    }
}