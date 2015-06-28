/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 * 				MODIFIED FOR USE IN THIS MOD, IF YOU OWN IT AND WANT ME TO REMOVE IT, PLEASE ASK!
 ******************************************************************************/

package dmf444.ExtraFood.Core.Crossmod.forestry;

import forestry.api.farming.ICrop;
import forestry.api.farming.IFarmable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class FarmCrop implements IFarmable{
	
	private ItemStack seeds;
	private Block farmBlocks;
	private int fullGrowths;

	public FarmCrop(ItemStack seed, Block farmBlock, int fullGrowth){
		this.seeds = seed;
		this.farmBlocks = farmBlock;
		this.fullGrowths = fullGrowth;
	}
	
	@Override
	public boolean isSaplingAt(World world, BlockPos pos) {
		if(world.isAirBlock(pos)){
			return false;
		} else if(world.getBlockState(pos).getBlock() != farmBlocks){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ICrop getCropAt(World world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock() != farmBlocks)
			return null;
		if (world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) != fullGrowths)
			return null;
		return new CropBlock(world, farmBlocks, fullGrowths, pos);
		
	}

	@Override
	public boolean isGermling(ItemStack itemstack) {
		if (seeds.getItem() != itemstack.getItem())
			return false;
		if (seeds.getItemDamage() >= 0)
			return seeds.getItemDamage() == itemstack.getItemDamage();
		else
			return true;
	}

	@Override
	public boolean isWindfall(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean plantSaplingAt(EntityPlayer player, ItemStack germling, World world, BlockPos pos) {
		return germling.copy().onItemUse(player, world, pos, EnumFacing.UP, 0, 0, 0);
	}

}
