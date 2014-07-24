package dmf444.ExtraFood.Common.WorldGen;


import java.util.Random;


import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.util.EFLog;


public class StrawberryWorldGen implements IWorldGenerator {


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
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
			int by = world.getHeightValue(xx, zz);
			for (int xpos = 0; xpos < xs; xpos++){
				for (int ypos = 0; ypos < ys; ypos++){
					by = world.getHeightValue(xx + xpos, zz + ypos);


					if (world.getBlock(xx + xpos, by, zz + ypos) == Blocks.tallgrass && random.nextInt(3) == 0){
						world.setBlock(xx + xpos, by, zz + ypos, BlockLoader.strawberryBush);
						//EFLog.error("xx: " + xx + xpos + " zz: " + zz + ypos);
					}
					else if (world.getBlock(xx + xpos, by - 1, zz + ypos) == Blocks.grass && random.nextInt(3) == 0){
						world.setBlock(xx + xpos, by, zz + ypos, BlockLoader.strawberryBush);
						//EFLog.error("xx: " + xx + xpos + " zz: " + zz + ypos);
					}
					//EFLog.error("Block: " + world.getBlock(xx + xpos, by, zz + ypos).getUnlocalizedName());
				}
			}
		}


	}
}
