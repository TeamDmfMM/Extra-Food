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
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;

public class ClickCrop implements ICrop{

	World world;
	BlockPos position;

 	public ClickCrop(World world, BlockPos pos) {
 		this.world = world;
 		this.position = pos;
 	} 

	protected Collection<ItemStack> harvestBlock(World world, BlockPos pos) {
 		Item item = null;
 		if(world.getBlockState(pos).getBlock() == BlockLoader.strawberryBush){
 			item = ItemLoader.strawberry;
 		} else if (world.getBlockState(pos).getBlock() == BlockLoader.peanutbush){
 			item = ItemLoader.peanut;
 		}
 		
 		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
 				ret.add(new ItemStack(item, 4));
 		world.setBlockState(pos, world.getBlockState(pos).getBlock().getStateFromMeta(0), 2);

  		return ret; 

	}
	@Override
	public Collection<ItemStack> harvest() {
		// TODO Auto-generated method stub
		return harvestBlock(world, position);
	}

	@Nonnull
	@Override
	public BlockPos getPosition() {
		return position;
	}
}
