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

package dmf444.ExtraFood.Core.Crossmod.Forestry;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import forestry.api.farming.ICrop;
import forestry.api.farming.IFarmable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FarmClick implements IFarmable{
	

	private Block farmBlocks;
	private int fullGrowths;

	public FarmClick(Block farmBlock, int fullGrowth){
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
	public ICrop getCropAt(World world, BlockPos pos, IBlockState state) {
		if (world.getBlockState(pos).getBlock() != farmBlocks)
			return null;
		if (world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) != fullGrowths)
			return null;
		return new ClickCrop(world, pos);
		
	}

	@Override
	public boolean isGermling(ItemStack itemstack) {
		if(itemstack.getItem() == Item.getItemFromBlock(BlockLoader.strawberryBush) || itemstack.getItem() == Item.getItemFromBlock(BlockLoader.peanutbush))
			return true;
		else
			return false;
	}

	@Override
	public boolean isWindfall(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean plantSaplingAt(EntityPlayer player, ItemStack germling, World world, BlockPos pos) {
		IBlockState state = this.farmBlocks.getDefaultState();
		return world.setBlockState(pos, state, 2);

	}

}