package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.lib.ItemLib;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemLoader {

	public static Item cheeseWheel;
	public static Item banana, orange;
	public static Item knife, grater, muffinPan, dough;
	public static Item cheeseSlice;
	public static Item cookBook;
	public static Item sausage;
	public static Item strawberry, peanut, olive;
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
	public static Item tomato, lettuce;
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
		
		registerItems();
	}
	public static void initiateFoods(){
		//Semi-balanced foods
		sausage = new StanFood(3, 0.9F).setUnlocalizedName(ItemLib.iS);
		cheeseSlice = new StanFood(2, 3.0F).setUnlocalizedName(ItemLib.iCS);
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
		//ChocolateCake = new ItemR(BlockLoader.Chocake).setMaxStackSize(1).setUnlocalizedName(ItemLib.Cake).setCreativeTab(EFTabs.INSTANCE);
		
		registerFood();
	}
	private static void registerItems() {
		if(!IRegister){
			
			GameRegistry.registerItem(knife, ItemLib.iK);
			GameRegistry.registerItem(cookBook, ItemLib.iCB);
			GameRegistry.registerItem(grater, ItemLib.iGrater);
			GameRegistry.registerItem(muffinPan, ItemLib.iMuffPan);
            GameRegistry.registerItem(dough, ItemLib.iDough);
			GameRegistry.registerItem(tomatoSeeds, ItemLib.iTS);
			GameRegistry.registerItem(uselettuceSeeds, ItemLib.iCLS);
			GameRegistry.registerItem(rawlettuceSeeds, ItemLib.iULS);
			GameRegistry.registerItem(bucketstrawberry, ItemLib.iBS);
			GameRegistry.registerItem(bucketbanana, ItemLib.iBB);
			GameRegistry.registerItem(bucketcarrot, ItemLib.iBC);
			GameRegistry.registerItem(bucketseaWater, ItemLib.iBSW);
			GameRegistry.registerItem(bucketpurifiedwater, ItemLib.iBPW);
			GameRegistry.registerItem(bucketeggnog, "eggnog");
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("bananajuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketbanana), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("strawberryjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketstrawberry), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("carrotjuice", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketcarrot), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("eggnog", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketeggnog), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketseaWater), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("water", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketpurifiedwater), new ItemStack(Items.bucket));

			

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
			GameRegistry.registerItem(frenchFries, ItemLib.iFF);
			GameRegistry.registerItem(egg, ItemLib.iEgg);
			GameRegistry.registerItem(rawpasta, ItemLib.iPasta);
			GameRegistry.registerItem(sandwhichS, ItemLib.iSandS);
			GameRegistry.registerItem(sandwhichCB, ItemLib.iSandCB);
			GameRegistry.registerItem(sandwhichGC, ItemLib.iSandGC);
			GameRegistry.registerItem(rawHamburger, ItemLib.iRH);
			GameRegistry.registerItem(cookedHamburger, ItemLib.iCH);
			GameRegistry.registerItem(sandwhichHamburger, ItemLib.iSandH);
			GameRegistry.registerItem(peanut, ItemLib.iP);
			GameRegistry.registerItem(tomato, ItemLib.iTom);
			GameRegistry.registerItem(lettuce, ItemLib.iLet);
			GameRegistry.registerItem(cookedpasta, ItemLib.iCP);
			GameRegistry.registerItem(meatballs, ItemLib.iMB);
			GameRegistry.registerItem(meatballpasta, ItemLib.iMBP);
			GameRegistry.registerItem(sushi, ItemLib.iSushi);
			GameRegistry.registerItem(fishpieces, ItemLib.iFP);
			GameRegistry.registerItem(pork_kebab, ItemLib.iPKeb);
			GameRegistry.registerItem(veal_kebab, ItemLib.iVKeb);
			GameRegistry.registerItem(steak_kebab, ItemLib.iSKeb);
			GameRegistry.registerItem(chocolate, ItemLib.iCho);
			GameRegistry.registerItem(pancakes, ItemLib.iPC);
			GameRegistry.registerItem(peanutButter, ItemLib.iPB);
			GameRegistry.registerItem(butter, ItemLib.iButter);
			GameRegistry.registerItem(strawberryIceCream, ItemLib.iStrawIceCream);
			GameRegistry.registerItem(vanillaIceCream, ItemLib.iVanIceCream);
			GameRegistry.registerItem(chocolateIceCream, ItemLib.iChoIceCream);
			GameRegistry.registerItem(chineseFood, ItemLib.iCNF);
			GameRegistry.registerItem(chocolateSpread, ItemLib.iChoSpread);
			GameRegistry.registerItem(jelly, ItemLib.iJ);
			GameRegistry.registerItem(sandwichBLT, ItemLib.iSandBLT);
			GameRegistry.registerItem(sandwichPBJ, ItemLib.iSandPBJ);
			GameRegistry.registerItem(sandwichPBN, ItemLib.iSandPBN);
			GameRegistry.registerItem(icePop, ItemLib.iPopcicle);
			GameRegistry.registerItem(neoIceCream, ItemLib.iNeoIceCream);
			GameRegistry.registerItem(sandwichPB, ItemLib.iSandPeanutB);
			GameRegistry.registerItem(butterMilk, ItemLib.iButterMilk);
			GameRegistry.registerItem(yogurt, ItemLib.iYogurt);
			GameRegistry.registerItem(stawberryYogurt, ItemLib.iStrawYogurt);
			GameRegistry.registerItem(sandwichC, ItemLib.iChoSandwich);
			GameRegistry.registerItem(frenchToast, ItemLib.iFrenchToast);
			GameRegistry.registerItem(sandwichCheeseburger, ItemLib.iSandCheeseBurger);
			GameRegistry.registerItem(sandwichSupremeBurger, ItemLib.iSandSupremeH);
			GameRegistry.registerItem(olive, ItemLib.iOlive);
			GameRegistry.registerItem(orange, ItemLib.Orange);
			//Noel
			GameRegistry.registerItem(shortbread, ItemLib.iShortB);
			GameRegistry.registerItem(fruitcake, ItemLib.iFC);
			GameRegistry.registerItem(gingerbread, ItemLib.iGB);
			GameRegistry.registerItem(chestnuts, ItemLib.Chestnut);
			//Temp
			//GameRegistry.registerItem(ChocolateCake, ItemLib.Cake);
			
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
}
