package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Whiteout extends Block {

	public Whiteout() {
		super(Material.clay);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		//this.setLightLevel(0.875F);
	}

	@Override
	 public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entity)
	{
		if(entity instanceof EntityEnderman){
			entity.attackEntityFrom(DamageSource.drown, 4.0F);
		}
	}
	@Override
	 public boolean canCreatureSpawn(IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type){
			return false;
	}
}
