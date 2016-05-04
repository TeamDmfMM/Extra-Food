package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.lib.ItemLib;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana, orange;
	public static Item knife, grater, muffinPan, dough;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry, peanut, olive, grapes;
	public static Item bucketstrawberry;
	public static Item bucketbanana;
	public static Item bucketcarrot;
	public static Item bacon;
	public static Item cookedBacon;
	public static Item veal;
	public static Item toast, frenchToast;
	public static Item slicedBread;
	public static Item bucketseaWater;
	public static Item bucketpurifiedwater;
	public static Item frenchFries;
	public static Item egg;
	public static Item rawpasta, cookedpasta, meatballpasta;
	public static Item sandwhichCB, sandwhichGC, sandwichPBN, sandwichPBJ, sandwichBLT, sandwichPB, sandwhichS, sandwichC;
	public static Item pork_kebab, steak_kebab, veal_kebab;
	public static Item rawHamburger, cookedHamburger;
	public static Item sandwhichHamburger, sandwichCheeseburger, sandwichSupremeBurger;
	public static Item tomato, lettuce, pineapple;
	public static Item rawlettuceSeeds;
	public static ItemSeeds tomatoSeeds, uselettuceSeeds;
	public static Item peanutButter, chocolateSpread, jelly;
	public static Item meatballs;
	public static Item chocolate;
	public static Item pancakes;
	public static Item sushi, fishpieces, chineseFood;
	public static Item vanillaIceCream, chocolateIceCream, strawberryIceCream, icePop, neoIceCream;
	public static Item butter, butterMilk;
	public static Item yogurt, stawberryYogurt;
	public static Item pineappleSlice;
	/*Christmas Items*/
	public static Item shortbread, fruitcake, gingerbread, chestnuts, bucketeggnog;
	//Temp
	public static Item ChocolateCake;
	
	private static boolean IRegister=false;
	private static boolean FRegister=false;
	
	
	
	public static void initiateItems() {

		knife = new Knife().setUnlocalizedName(ItemLib.iK);	
		cookBook = new Cookbook().setUnlocalizedName(ItemLib.iCB);
		bucketstrawberry = new BucketEdible(6, 0.8F, BlockLoader.Bstrawberryjuice, ItemLib.iBS);
		bucketbanana = new BucketEdible(6, 0.6F, BlockLoader.Bbananajuice, ItemLib.iBB);
		bucketcarrot = new BucketEdible(6, 0.9F, BlockLoader.Bcarrotjuice, ItemLib.iBC);
		bucketseaWater = new BucketEdible(2, 0.5F, Blocks.water, ItemLib.iBSW);
		bucketpurifiedwater = new BucketEdible(4, 0.5F, Blocks.water, ItemLib.iBPW);
		bucketeggnog = new BucketEdible(9, 5.0F, BlockLoader.Beggnog, ItemLib.iEggnog);
		tomatoSeeds = (ItemSeeds) new ItemSeeds(BlockLoader.tomatoCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iTS).setCreativeTab(EFTabs.INSTANCE);
		rawlettuceSeeds = new StanItem().setUnlocalizedName(ItemLib.iULS);
		uselettuceSeeds = (ItemSeeds) new ItemSeeds(BlockLoader.lettuceCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iCLS).setCreativeTab(EFTabs.INSTANCE);
		grater = new Grater().setUnlocalizedName(ItemLib.iGrater);
		muffinPan = new StanItem().setUnlocalizedName(ItemLib.iMuffPan);
		dough = new StanItem().setUnlocalizedName(ItemLib.iDough);
		pineapple = new ItemSeedFood(8, 3.0F, BlockLoader.pineappleCrop, Blocks.farmland).setUnlocalizedName(ItemLib.iPineapple).setCreativeTab(EFTabs.INSTANCE);
		
		registerItems();
	}
	public static void initiateFoods(){
		//Semi-balanced foods
		grapes = new StanFood(3, 1.2f).setUnlocalizedName(ItemLib.iGrapes);
		sausage = new StanFood(3, 0.9F).setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new StanFood(2, 3.0F).setUnlocalizedName(ItemLib.iCS);
		pineappleSlice = new StanFood(2, 1.5f).setUnlocalizedName(ItemLib.iPinappleSlice);
		cheeseWheel = new CheeseWheel(8, 5.6F, false, "That tasted good!").setUnlocalizedName(ItemLib.iCW);
		banana = ((ItemFood) new StanFood(4, 0.8F, false).setUnlocalizedName(ItemLib.iBan)).setAlwaysEdible().setMaxStackSize(10);
		strawberry = ((ItemFood) new StanFood(2, 2.0F, false).setUnlocalizedName(ItemLib.iST)).setAlwaysEdible().setMaxStackSize(32);
		bacon = new StanFood(1, 0.6F).setUnlocalizedName(ItemLib.iBac);
		veal = new StanFood(8, 19.5F, true).setUnlocalizedName(ItemLib.iV);
		cookedBacon = new StanFood(2, 5.2F).setUnlocalizedName(ItemLib.iCBac);
		toast = new StanFood(6, 0.8F).setUnlocalizedName(ItemLib.iToastS);
		slicedBread = new StanFood(4, 3.0F).setUnlocalizedName(ItemLib.iBRS);
		frenchFries = new StanFood(8, 0.7F).setUnlocalizedName(ItemLib.iFF).setCreativeTab(EFTabs.INSTANCE);
		tomato = new StanFood(4, 2.5F).setUnlocalizedName(ItemLib.iTom);
		lettuce = new StanFood(4, 1.6F).setUnlocalizedName(ItemLib.iLet);	
		egg = new StanFood(3, 0.8F).setUnlocalizedName(ItemLib.iEgg);
		pork_kebab = new StanFood(3, 12.3F).setUnlocalizedName(ItemLib.iPKeb);
		steak_kebab = new StanFood(3, 12.4F).setUnlocalizedName(ItemLib.iSKeb);
		veal_kebab = new StanFood(3, 12.6F).setUnlocalizedName(ItemLib.iVKeb);		
		sushi = new StanFood(8, 2.6F).setUnlocalizedName(ItemLib.iSushi);
		rawHamburger = ((ItemFood) new StanFood(5, 0.6F).setUnlocalizedName(ItemLib.iRH)).setPotionEffect(new PotionEffect(Potion.getPotionById(17), 10), 0.4F);
		
		//Non-balanced foods
		rawpasta = new ReturnFood(3, 0.3F, Items.bowl).setUnlocalizedName(ItemLib.iPasta);
		sandwhichS = new StanFood(7, 1.0F).setUnlocalizedName(ItemLib.iSandS);
		sandwhichCB = new StanFood(6, 1.4F).setUnlocalizedName(ItemLib.iSandCB);
		sandwhichGC = new StanFood(6, 1.9F).setUnlocalizedName(ItemLib.iSandGC);
		cookedHamburger = new StanFood(7, 1.6F).setUnlocalizedName(ItemLib.iCH);
		sandwhichHamburger = new StanFood(9, 1.0F).setUnlocalizedName(ItemLib.iSandH);
		peanut = ((ItemFood) new StanFood(1, 0.2F).setUnlocalizedName(ItemLib.iP)).setAlwaysEdible();
		cookedpasta = new ReturnFood(6, 1.3F, Items.bowl).setUnlocalizedName(ItemLib.iCP);
		meatballs = new StanFood(3, 0.4F).setUnlocalizedName(ItemLib.iMB);
		meatballpasta = new ReturnFood(12, 1.4F, Items.bowl).setUnlocalizedName(ItemLib.iMBP);
		fishpieces = new StanFood(4, 0.5F).setUnlocalizedName(ItemLib.iFP);
		chocolate = new StanFood(4, 1.8F).setUnlocalizedName(ItemLib.iCho);
		pancakes = new StanFood(6, 1.2F).setUnlocalizedName(ItemLib.iPC);
		peanutButter = ((ItemFood) new StanFood(3, 4.5F).setUnlocalizedName(ItemLib.iPB)).setPotionEffect(new PotionEffect(Potion.getPotionById(9), 10), 0.8F);
		butter = new StanFood(1, 1.0F).setUnlocalizedName(ItemLib.iButter);
		vanillaIceCream = new DrinkActionFood(4, 0.8F).setUnlocalizedName(ItemLib.iVanIceCream);
		chocolateIceCream = new DrinkActionFood(8, 0.8F).setUnlocalizedName(ItemLib.iChoIceCream);
		strawberryIceCream = new DrinkActionFood(9, 2.5F).setUnlocalizedName(ItemLib.iStrawIceCream);
		chineseFood = new StanFood(7, 5.0F).setUnlocalizedName(ItemLib.iCNF);
		chocolateSpread = ((ItemFood) new StanFood(8, 4.5F).setUnlocalizedName(ItemLib.iChoSpread)).setPotionEffect(new PotionEffect(Potion.getPotionById(9), 10), 0.8F);
		jelly = ((ItemFood) new StanFood(5, 2.0F).setUnlocalizedName(ItemLib.iJ)).setPotionEffect(new PotionEffect(Potion.getPotionById(6), 1), 0.1F);
		sandwichBLT = new StanFood(8, 10.0F).setUnlocalizedName(ItemLib.iSandBLT);
		sandwichPBJ = new StanFood(8, 9.5F).setUnlocalizedName(ItemLib.iSandPBJ);
		sandwichPBN = new StanFood(8, 9.0F).setUnlocalizedName(ItemLib.iSandPBN);
		icePop = new DrinkActionFood(5, 3.3F).setUnlocalizedName(ItemLib.iPopcicle);
		neoIceCream = new ReturnFood(8, 4.5F, Items.bowl).setUnlocalizedName(ItemLib.iNeoIceCream);
		sandwichPB = new StanFood(6, 3.5F).setUnlocalizedName(ItemLib.iSandPeanutB);
		butterMilk = new ReturnFood(8, 3.6F, Items.bucket).setUnlocalizedName(ItemLib.iButterMilk);
		yogurt = new ReturnFood(5, 6.3F, Items.bowl).setUnlocalizedName(ItemLib.iYogurt);
		stawberryYogurt = new ReturnFood(5, 6.8F, Items.bowl).setUnlocalizedName(ItemLib.iStrawYogurt);
		sandwichC = new StanFood(9, 5.5F).setUnlocalizedName(ItemLib.iChoSandwich);
		frenchToast = new StanFood(7, 2.7F).setUnlocalizedName(ItemLib.iFrenchToast);
		sandwichCheeseburger = new StanFood(10, 12.0F).setUnlocalizedName(ItemLib.iSandCheeseBurger);
		sandwichSupremeBurger = new StanFood(15, 11.2F).setUnlocalizedName(ItemLib.iSandSupremeH);
		shortbread = new StanFood(8, 5.0F).setUnlocalizedName(ItemLib.iShortB);
		fruitcake = new StanFood(12, 5.0F).setUnlocalizedName(ItemLib.iFC);
		gingerbread = new StanFood(9, 5.0F).setUnlocalizedName(ItemLib.iGB);
		chestnuts = new StanFood(10, 5.0F).setUnlocalizedName(ItemLib.Chestnut);
		olive = new StanFood(4, 3.0F).setUnlocalizedName(ItemLib.iOlive);
		orange = new StanFood(5, 3.0F).setUnlocalizedName(ItemLib.Orange);
		//Temp HDB
		ChocolateCake = new ItemBlockSpecial(BlockLoader.Chocake).setMaxStackSize(1).setUnlocalizedName(ItemLib.Cake).setCreativeTab(EFTabs.INSTANCE);
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			registerItem(knife, ItemLib.iK);
			registerItem(cookBook, ItemLib.iCB);
			registerItem(grater, ItemLib.iGrater);
			registerItem(muffinPan, ItemLib.iMuffPan);
            registerItem(dough, ItemLib.iDough);
			registerItem(tomatoSeeds, ItemLib.iTS);
			registerItem(uselettuceSeeds, ItemLib.iCLS);
			registerItem(rawlettuceSeeds, ItemLib.iULS);
			registerItem(bucketstrawberry, ItemLib.iBS);
			registerItem(bucketbanana, ItemLib.iBB);
			registerItem(bucketcarrot, ItemLib.iBC);
			GameRegistry.registerItem(pineapple, ItemLib.iPineapple);
			registerItem(bucketseaWater, ItemLib.iBSW);
			registerItem(bucketpurifiedwater, ItemLib.iBPW);
			registerItem(bucketeggnog, "eggnog");
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("bananajuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketbanana), new ItemStack(Items.bucket));
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("strawberryjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketstrawberry), new ItemStack(Items.bucket));
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("carrotjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketcarrot), new ItemStack(Items.bucket));
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("eggnog", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketeggnog), new ItemStack(Items.bucket));
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketseaWater), new ItemStack(Items.bucket));
			//FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketpurifiedwater), new ItemStack(Items.bucket));

			

		}
		IRegister=true;
	}
	
	private static void registerFood() {
		if(!FRegister){
			registerItem(pineappleSlice, ItemLib.iPinappleSlice);
			registerItem(grapes, ItemLib.iGrapes);
			registerItem(cheeseWheel, ItemLib.iCW);
			registerItem(banana, ItemLib.iBan);
			registerItem(cheeseSlice, ItemLib.iCS);
			registerItem(sausage, ItemLib.iS);
			registerItem(strawberry, ItemLib.iST);
			registerItem(bacon, ItemLib.iBac);
			registerItem(cookedBacon, ItemLib.iCBac);
			registerItem(veal, ItemLib.iV);
			registerItem(toast, ItemLib.iToastS);
			registerItem(slicedBread, ItemLib.iBRS);
			registerItem(frenchFries, ItemLib.iFF);
			registerItem(egg, ItemLib.iEgg);
			registerItem(rawpasta, ItemLib.iPasta);
			registerItem(sandwhichS, ItemLib.iSandS);
			registerItem(sandwhichCB, ItemLib.iSandCB);
			registerItem(sandwhichGC, ItemLib.iSandGC);
			registerItem(rawHamburger, ItemLib.iRH);
			registerItem(cookedHamburger, ItemLib.iCH);
			registerItem(sandwhichHamburger, ItemLib.iSandH);
			registerItem(peanut, ItemLib.iP);
			registerItem(tomato, ItemLib.iTom);
			registerItem(lettuce, ItemLib.iLet);
			registerItem(cookedpasta, ItemLib.iCP);
			registerItem(meatballs, ItemLib.iMB);
			registerItem(meatballpasta, ItemLib.iMBP);
			registerItem(sushi, ItemLib.iSushi);
			registerItem(fishpieces, ItemLib.iFP);
			registerItem(pork_kebab, ItemLib.iPKeb);
			registerItem(veal_kebab, ItemLib.iVKeb);
			registerItem(steak_kebab, ItemLib.iSKeb);
			registerItem(chocolate, ItemLib.iCho);
			registerItem(pancakes, ItemLib.iPC);
			registerItem(peanutButter, ItemLib.iPB);
			registerItem(butter, ItemLib.iButter);
			registerItem(strawberryIceCream, ItemLib.iStrawIceCream);
			registerItem(vanillaIceCream, ItemLib.iVanIceCream);
			registerItem(chocolateIceCream, ItemLib.iChoIceCream);
			registerItem(chineseFood, ItemLib.iCNF);
			registerItem(chocolateSpread, ItemLib.iChoSpread);
			registerItem(jelly, ItemLib.iJ);
			registerItem(sandwichBLT, ItemLib.iSandBLT);
			registerItem(sandwichPBJ, ItemLib.iSandPBJ);
			registerItem(sandwichPBN, ItemLib.iSandPBN);
			registerItem(icePop, ItemLib.iPopcicle);
			registerItem(neoIceCream, ItemLib.iNeoIceCream);
			registerItem(sandwichPB, ItemLib.iSandPeanutB);
			registerItem(butterMilk, ItemLib.iButterMilk);
			registerItem(yogurt, ItemLib.iYogurt);
			registerItem(stawberryYogurt, ItemLib.iStrawYogurt);
			registerItem(sandwichC, ItemLib.iChoSandwich);
			registerItem(frenchToast, ItemLib.iFrenchToast);
			registerItem(sandwichCheeseburger, ItemLib.iSandCheeseBurger);
			registerItem(sandwichSupremeBurger, ItemLib.iSandSupremeH);
			registerItem(olive, ItemLib.iOlive);
			registerItem(orange, ItemLib.Orange);
			//Noel
			registerItem(shortbread, ItemLib.iShortB);
			registerItem(fruitcake, ItemLib.iFC);
			registerItem(gingerbread, ItemLib.iGB);
			registerItem(chestnuts, ItemLib.Chestnut);
			//Temp
			registerItem(ChocolateCake, ItemLib.Cake);
			
			//Register into Ore Dictionary
			OreDictionary.registerOre("foodHamburger", ItemLoader.cookedHamburger);
			OreDictionary.registerOre("foodBanana", ItemLoader.banana);
			OreDictionary.registerOre("foodBread", ItemLoader.slicedBread);
			OreDictionary.registerOre("foodToast", ItemLoader.toast);
			OreDictionary.registerOre("foodCheeseSlice", ItemLoader.cheeseSlice);
			OreDictionary.registerOre("foodSausage", ItemLoader.sausage);
			OreDictionary.registerOre("foodRawPasta", ItemLoader.rawpasta);
			OreDictionary.registerOre("foodPeanuts", ItemLoader.peanut);
			OreDictionary.registerOre("foodStrawberry", ItemLoader.strawberry);
			OreDictionary.registerOre("cropTomato", ItemLoader.tomato);
			OreDictionary.registerOre("cropLettuce", ItemLoader.lettuce);
			OreDictionary.registerOre("foodCookedBacon", ItemLoader.cookedBacon);
			OreDictionary.registerOre("foodCookedPasta", ItemLoader.cookedpasta);
			OreDictionary.registerOre("foodMeatballs", ItemLoader.meatballs);
			OreDictionary.registerOre("foodMeatballPasta", ItemLoader.meatballpasta);
			OreDictionary.registerOre("foodSushi", ItemLoader.sushi);
			OreDictionary.registerOre("foodPineappleSlice", ItemLoader.pineappleSlice);
			OreDictionary.registerOre("foodGrape", ItemLoader.grapes);
			OreDictionary.registerOre("foodStrawberryIceCream", ItemLoader.strawberryIceCream);
			OreDictionary.registerOre("foodVanillaIceCream", ItemLoader.vanillaIceCream);
			OreDictionary.registerOre("foodChocolateIceCream", ItemLoader.chocolateIceCream);
			OreDictionary.registerOre("fishpieces", ItemLoader.fishpieces);
			OreDictionary.registerOre("foodChocolate", ItemLoader.chocolate);
			OreDictionary.registerOre("itemKnife", ItemLoader.knife);
			OreDictionary.registerOre("foodPancakes", ItemLoader.pancakes);
			OreDictionary.registerOre("foodPeanutButter", ItemLoader.peanutButter);
			OreDictionary.registerOre("foodChinese", ItemLoader.chineseFood);
			OreDictionary.registerOre("itemGrater", new ItemStack(ItemLoader.grater, 1, OreDictionary.WILDCARD_VALUE));
			OreDictionary.registerOre("foodButter", ItemLoader.butter);
			OreDictionary.registerOre("foodChocolateSpread", ItemLoader.chocolateSpread);
			OreDictionary.registerOre("foodEgg", ItemLoader.egg);
			OreDictionary.registerOre("foodJelly", ItemLoader.jelly);
			OreDictionary.registerOre("foodBLT", ItemLoader.sandwichBLT);
			OreDictionary.registerOre("foodPBJ", ItemLoader.sandwichPBJ);
			OreDictionary.registerOre("foodPBN", ItemLoader.sandwichPBN);
			OreDictionary.registerOre("foodNeoIceCream", ItemLoader.neoIceCream);
			OreDictionary.registerOre("foodIcePop", ItemLoader.icePop);
			OreDictionary.registerOre("foodSandwichPeanutButter", ItemLoader.sandwichPB);
			OreDictionary.registerOre("foodButterMilk", ItemLoader.butterMilk);
			OreDictionary.registerOre("foodYogurt", ItemLoader.yogurt);
			OreDictionary.registerOre("foodStrawberryYogurt", ItemLoader.stawberryYogurt);
			OreDictionary.registerOre("foodChocolateSandwich", ItemLoader.sandwichC);
			OreDictionary.registerOre("foodHamburgerSandwich", ItemLoader.sandwhichHamburger);
			OreDictionary.registerOre("foodCheeseburger", ItemLoader.sandwichCheeseburger);
			OreDictionary.registerOre("foodSupremeBurger", ItemLoader.sandwichSupremeBurger);
			OreDictionary.registerOre("foodFrenchToast", ItemLoader.frenchToast);
            OreDictionary.registerOre("foodDough", ItemLoader.dough);
			OreDictionary.registerOre("foodOlive", ItemLoader.olive);
			OreDictionary.registerOre("foodOrange", ItemLoader.orange);
			
		}
		FRegister=true;
	}

	private static void registerItem(Item item, String name){
		item.setRegistryName(name);
		GameRegistry.register(item);
	}
}
