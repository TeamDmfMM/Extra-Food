package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana;
	public static Item knife;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry;
	public static Item bucketstrawberry;
	public static Item bucketbanana;
	public static Item bucketcarrot;
	public static Item bacon;
	public static Item cookedBacon;
	public static Item veal;
	public static Item toast;
	public static Item slicedBread;
	public static Item bucketseaWater;
	public static Item bucketpurifiedwater;
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;
	


	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);
		bucketstrawberry = new BucketStrawberry(2, 0.3F);
		bucketbanana = new BucketBanana(2, 0.4F);
		bucketcarrot = new BucketCarrot(2, 0.6F);
		bucketseaWater = new BucketSeaWater(2, 0.1F);
		bucketpurifiedwater = new BucketPurifiedWater(3, 0.3F);


		
		
		
		registerItems();
	}
	public static void initiateFoods(){
		sausage = new Sausage().setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new CheeseSlice().setUnlocalizedName(ItemLib.iCS);
		cheeseWheel = new CheeseWheel(8, 0.6F, false).setUnlocalizedName(ItemLib.iCW);
		banana = new Banana(1, 0.8F, false).setUnlocalizedName(ItemLib.iBan);
		strawberry = new Strawberry(1, 0.6F, false).setUnlocalizedName(ItemLib.iST);
		bacon = new StanFood(1, 0.6F, false).setUnlocalizedName(ItemLib.iBac);
		veal = new StanFood(1, 0.6F, true).setUnlocalizedName(ItemLib.iV);
		cookedBacon = new StanFood(1, 0.6F, false).setUnlocalizedName(ItemLib.iCBac);
		toast = new StanFood(1, 0.8F, false).setUnlocalizedName(ItemLib.iToastS);
		slicedBread = new StanFood(1, 0.2F, false).setUnlocalizedName(ItemLib.iBRS);
		
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
			GameRegistry.registerItem(bucketstrawberry, ItemLib.iBS);
			GameRegistry.registerItem(bucketbanana, ItemLib.iBB);
			GameRegistry.registerItem(bucketcarrot, ItemLib.iBC);
			GameRegistry.registerItem(bucketseaWater, ItemLib.iBSW);
			GameRegistry.registerItem(bucketpurifiedwater, ItemLib.iBPW);


		}
		IRegister=true;
	}
	
	private static void registerFood() {
		if(!FRegister){
			GameRegistry.registerItem(cheeseWheel, ItemLib.iCW);
			GameRegistry.registerItem(banana, ItemLib.iBan);
			GameRegistry.registerItem(cheeseSlice, ItemLib.iCS);
			GameRegistry.registerItem(sausage, ItemLib.iS);
			GameRegistry.registerItem(strawberry, ItemLib.iST);
			GameRegistry.registerItem(bacon, ItemLib.iBac);
			GameRegistry.registerItem(cookedBacon, ItemLib.iCBac);
			GameRegistry.registerItem(veal, ItemLib.iV);
			GameRegistry.registerItem(toast, ItemLib.iToastS);
			GameRegistry.registerItem(slicedBread, ItemLib.iBRS);
		}
		FRegister=true;
	}
}
