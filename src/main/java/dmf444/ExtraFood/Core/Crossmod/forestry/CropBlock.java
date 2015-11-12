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
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Collection;

public class CropBlock implements ICrop{
	Block block;
	int meta;
	World world;
	int posX;
	int posY;
	int posZ;

 	public CropBlock(World world, Block block, int meta, BlockPos pos) {
 		this.world = world;
 		this.block = block;
 		this.meta = meta;
 		this.posX = pos.getX();
 		this.posY = pos.getY();
 		this.posZ = pos.getZ();
 	} 
 	protected Collection<ItemStack> harvestBlock(int x, int y, int z) {
 		Collection<ItemStack> harvested = block.getDrops(world,new BlockPos(x, y, z), block.getStateFromMeta(meta), 0);
 		//Proxies.common.addBlockDestroyEffects(world, pos.x, pos.y, pos.z, block, 0);
 		Minecraft.getMinecraft().effectRenderer.addBlockHitEffects(new BlockPos(x, y, z), EnumFacing.UP);
 		world.setBlockToAir(new BlockPos(x,y,z));
  		return harvested; 

	}
	@Override
	public Collection<ItemStack> harvest() {
		// TODO Auto-generated method stub
		return harvestBlock(posX, posY, posZ);
	}
}
