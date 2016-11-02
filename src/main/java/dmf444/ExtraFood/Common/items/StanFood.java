package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.item.ItemFood;



public class StanFood extends ItemFood {
	

	public StanFood(int foodBar, float saturation, boolean WolfFood){
		super(foodBar, saturation, WolfFood);
		this.setCreativeTab(EFTabs.INSTANCE);
	}
	public StanFood(int foodBar, float saturation){
		super(foodBar, saturation, false);
		this.setCreativeTab(EFTabs.INSTANCE);
	}


}
