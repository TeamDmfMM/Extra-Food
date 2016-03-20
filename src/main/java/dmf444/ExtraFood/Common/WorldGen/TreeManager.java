package dmf444.ExtraFood.Common.WorldGen;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TreeManager implements IWorldGenerator {


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

            if(biome == Biomes.jungle || biome == Biomes.jungleEdge || biome == Biomes.jungleHills) {
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
        if(biome == Biomes.coldTaiga || biome == Biomes.coldTaigaHills || biome == Biomes.deepOcean || biome == Biomes.desert ||
                biome == Biomes.desertHills || biome == Biomes.megaTaiga || biome == Biomes.river || biome == Biomes.megaTaigaHills ||
                biome == Biomes.ocean || biome == Biomes.taiga || biome == Biomes.taigaHills){
            return false;
        }
        return true;
    }

}