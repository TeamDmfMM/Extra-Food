package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	public static Item knife;
	public static Item cheeseSlice;
	public static Item cookBook;
	
	
	public static boolean Register=false;
	public static void initiateItems() {
		cheeseWheel = new CheeseWheel(ItemLib.idCheeseWheel, 8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(ItemLib.idBanana, 1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		knife = new Knife(ItemLib.idKnife).setUnlocalizedName(ItemLib.iK);	
		cheeseSlice = new CheeseSlice(ItemLib.idCS).setUnlocalizedName(ItemLib.iCS);
		cookBook = new Cookbook(ItemLib.idCB).setUnlocalizedName(ItemLib.iCB);
		
		
		knife.setContainerItem(knife);
		
		
		registerItems();
	}
	private static void registerItems() {
		if(!Register){
			GameRegistry.registerItem(cheeseWheel, ItemLib.iCW);
			GameRegistry.registerItem(banana, ItemLib.iBan);
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cheeseSlice, ItemLib.iCS);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
		}
		Register=true;
	}
}
