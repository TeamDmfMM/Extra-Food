package dmf444.ExtraFood.Common.blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class Whiteout extends Block {

	public Whiteout() {
		super(Material.clay);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		//this.setLightLevel(0.875F);
	}

	@Override
	 public void onEntityWalking(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity entity)
	{
		if(entity instanceof EntityEnderman){
			entity.attackEntityFrom(DamageSource.drown, 4.0F);
		}
	}
	@Override
	 public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z){
		//if(world.getBlock(x, y, z) == 1){
			return false;
		//}
		//return true;
	}
}
