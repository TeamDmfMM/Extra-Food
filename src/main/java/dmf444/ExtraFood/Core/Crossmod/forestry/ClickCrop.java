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
import forestry.api.farming.ICrop;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;

public class ClickCrop implements ICrop{
	Block block;
	int meta;
	World world;
	int posX;
	int posY;
	int posZ;

 	public ClickCrop(World world, Block block, int meta, BlockPos pos) {
 		this.world = world;
 		this.block = block;
 		this.meta = meta;
 		this.posX = pos.getX();
 		this.posY = pos.getY();
 		this.posZ = pos.getZ();
 	} 

	protected Collection<ItemStack> harvestBlock(int x, int y, int z) {
 		Item item = null;
 		if(block == BlockLoader.strawberryBush){
 			item = ItemLoader.strawberry;
 		} else if (block == BlockLoader.peanutbush){
 			item = ItemLoader.peanut;
 		}
 		
 		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
 				ret.add(new ItemStack(item, 4));
 		world.setBlockState(new BlockPos(x, y, z), block.getStateFromMeta(0), 2);

  		return ret; 

	}
	@Override
	public Collection<ItemStack> harvest() {
		// TODO Auto-generated method stub
		return harvestBlock(posX, posY, posZ);
	}
}
