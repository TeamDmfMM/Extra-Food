package dmf444.ExtraFood.Core.util.Tabs;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EFTabs extends CreativeTabs {
	
	public static EFTabs INSTANCE = new EFTabs();


	public EFTabs() {
		super(ModInfo.MId);
	}

/*
	@Override
	public ItemStack getIconItemStack() {
		
		return new ItemStack(ItemLoader.cheeseWheel);
	}
*/

	@Override
	public Item getTabIconItem() {
		return ItemLoader.cheeseWheel;
	}
}