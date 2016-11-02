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

import forestry.api.farming.ICrop;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Collection;

public class CropBlock implements ICrop{

	World world;
	BlockPos position;

 	public CropBlock(World world, BlockPos pos) {
 		this.world = world;
		this.position = pos;
 	} 
 	protected Collection<ItemStack> harvestBlock(World world, BlockPos pos) {
 		Collection<ItemStack> harvested = world.getBlockState(pos).getBlock().getDrops(world, pos, world.getBlockState(pos), 0);
 		//Proxies.common.addBlockDestroyEffects(world, pos.x, pos.y, pos.z, block, 0);
 		Minecraft.getMinecraft().effectRenderer.addBlockHitEffects(pos, EnumFacing.UP);
 		world.setBlockToAir(pos);
  		return harvested; 

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
