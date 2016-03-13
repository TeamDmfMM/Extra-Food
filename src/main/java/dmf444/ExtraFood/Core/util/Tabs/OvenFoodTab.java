package dmf444.ExtraFood.Core.util.Tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.items.nbt.NBTFood;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;

public class OvenFoodTab extends CreativeTabs {
	
	public static OvenFoodTab INSTANCE = new OvenFoodTab();


	public OvenFoodTab() {
		super(ModInfo.MId + ".OvenFood");
	}


	@Override
	public ItemStack getIconItemStack() {
		ItemStack bob = new ItemStack(NBTFoodLoader.getItem("pizza"));
		bob.setTagCompound(((NBTFood) NBTFoodLoader.getItem("pizza")).getNBT("pepperoni", "cheese"));
		return bob;
	}


	@Override
	public Item getTabIconItem() {
		return this.getIconItemStack().getItem();
	}
}
