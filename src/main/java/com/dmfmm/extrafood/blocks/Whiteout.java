package com.dmfmm.extrafood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Whiteout extends Block {

	public Whiteout(String name) {
		super(Material.CLAY);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

	@Override
	 public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		if(entity instanceof EntityEnderman)
			entity.attackEntityFrom(DamageSource.DROWN, 4.0F);
	}
	@Override
	 public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type){
			return false;
	}
}
