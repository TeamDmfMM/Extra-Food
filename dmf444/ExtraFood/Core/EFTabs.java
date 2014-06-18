package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;

public class EFTabs extends CreativeTabs {
	
	public static EFTabs INSTANCE = new EFTabs();


	public EFTabs() {
		super(ModInfo.MId);
	}


	@Override
	public ItemStack getIconItemStack() {
		
		return new ItemStack(ItemLoader.cheeseWheel);
	}
}