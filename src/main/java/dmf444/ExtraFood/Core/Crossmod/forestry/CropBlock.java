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

import java.util.Collection;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import forestry.api.farming.ICrop;

public class CropBlock implements ICrop{
	Block block;
	int meta;
	World world;
	int posX;
	int posY;
	int posZ;

 	public CropBlock(World world, Block block, int meta,int x,int y, int z) {
 		this.world = world;
 		this.block = block;
 		this.meta = meta;
 		this.posX = x;
 		this.posY = y;
 		this.posZ = z;
 	} 
 	protected Collection<ItemStack> harvestBlock(int x, int y, int z) {
 		Collection<ItemStack> harvested = block.getDrops(world, x, y, z, meta, 0);
 		//Proxies.common.addBlockDestroyEffects(world, pos.x, pos.y, pos.z, block, 0);
 		Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(x, y, z, block, meta);
 		world.setBlockToAir(x,y,z); 
  		return harvested; 

	}
	@Override
	public Collection<ItemStack> harvest() {
		// TODO Auto-generated method stub
		return harvestBlock(posX, posY, posZ);
	}
}
