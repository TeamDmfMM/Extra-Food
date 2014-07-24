package dmf444.ExtraFood.Common.items;

import net.minecraft.item.ItemFood;
import dmf444.ExtraFood.Core.EFTabs;

public class Strawberry extends ItemFood{
	
	public Strawberry(int foodBar, float saturation, boolean WolfFood){
		super(foodBar, saturation, false);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setMaxStackSize(32);
		this.setTextureName("extrafood:strawberry");
	}

}
