package dmf444.ExtraFood.Common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Core.EFTabs;

public class CheeseSlice extends Item {

	public CheeseSlice(int id) {
		super(id);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:Bad_Cheeseslice");
	}

	
}
