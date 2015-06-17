/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.farming;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;

public interface IFarmLogic {

	int getFertilizerConsumption();

	int getWaterConsumption(float hydrationModifier);

	boolean isAcceptedResource(ItemStack itemstack);

	boolean isAcceptedGermling(ItemStack itemstack);

	Collection<ItemStack> collect();

	boolean cultivate(int x, int y, int z, EnumFacing direction, int extent);

	Collection<ICrop> harvest(int x, int y, int z, EnumFacing direction, int extent);

	IFarmLogic setManual(boolean manual);



	ResourceLocation getSpriteSheet();
	
	String getName();
}
