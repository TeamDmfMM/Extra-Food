package dmf444.ExtraFood.Core.Crossmod;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmfmm.StarvationAhoy.api.FoodEdit.KnownFoods;
import dmfmm.StarvationAhoy.api.FoodEdit.Module;

public class StarvationAhoy extends Module{

	@Override
	public void init(KnownFoods food) {
		food.insertFoodI(new ItemStack(ItemLoader.sandwhichHamburger), 3, 2.0F);
		food.insertFoodI(new ItemStack(ItemLoader.strawberry), 1, 0.5F);
		
	}
	
	

}
