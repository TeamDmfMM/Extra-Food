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

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import forestry.api.farming.ICrop;
import forestry.api.farming.IFarmable;

public class FarmClick implements IFarmable{
	

	private Block farmBlocks;
	private int fullGrowths;

	public FarmClick(Block farmBlock, int fullGrowth){
		this.farmBlocks = farmBlock;
		this.fullGrowths = fullGrowth;
	}
	
	@Override
	public boolean isSaplingAt(World world, int x, int y, int z) {
		if(world.isAirBlock(x, y, z)){
			return false;
		} else if(world.getBlock(x, y, z) != farmBlocks){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ICrop getCropAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) != farmBlocks)
			return null;
		if (world.getBlockMetadata(x, y, z) != fullGrowths)
			return null;
		return new ClickCrop(world, farmBlocks, fullGrowths, x, y, z);
		
	}

	@Override
	public boolean isGermling(ItemStack itemstack) {
		if(itemstack.getItem() == ItemLoader.strawberry || itemstack.getItem() == ItemLoader.peanut)
			return false;
		else
			return true;
	}

	@Override
	public boolean isWindfall(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean plantSaplingAt(EntityPlayer player, ItemStack germling, World world, int x, int y, int z) {
		return germling.copy().tryPlaceItemIntoWorld(player, world, x, y -1, z, 1, 0, 0, 0);
	}

}