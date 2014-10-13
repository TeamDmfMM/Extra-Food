package dmf444.ExtraFood.Common.items;

import net.minecraft.item.ItemFood;
import dmf444.ExtraFood.Core.EFTabs;

public class Banana extends ItemFood {

	public Banana(int foodBar, float saturation, boolean WolfFood) {
		
		super(foodBar, saturation, WolfFood);
		this.setMaxStackSize(10);
		this.setTextureName("extrafood:Bananas");
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setAlwaysEdible();

	}

	
}
