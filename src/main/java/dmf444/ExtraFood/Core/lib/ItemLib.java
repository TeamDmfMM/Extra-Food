package dmf444.ExtraFood.Core.lib;

import dmf444.ExtraFood.Core.util.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;

public class ItemLib {
	static EntityPlayer entityplayer;



	public static String iCW = "Cheese_Wheel";
	public static String iBan = "Banana";
	public static String iK = "Knife";
	public static String iCS = "Cheeseslice";
	public static String iCB = "Cookbook";
	public static String iS = "Sausage";
	public static String iST = "Strawberry";
	public static String iBS = "BucketStrawberry";
	public static String iBB = "BucketBanana";
	public static String iBac = "Bacon";
	public static String iBC = "BucketCarrot";
	public static String iV = "Veal";
	public static String iCBac = "CookedBacon";
	public static String iBRS = "BreadSlice";
	public static String iToastS = "Toast";
	public static String iBSW = "BucketSeaWater";
	public static String iBPW = "BucketPurifiedWater";
	public static String iEgg = "Egg";
	public static String iPasta = "Pasta";
	public static String iRH = "RawHamburger";
	public static String iCH = "CookedHamburger";
	public static String iP = "Peanut";
	public static String iTom = "Tomato";
	public static String iTS = "TomatoSeeds";
	public static String iLet = "Lettuce";
	public static String iULS = "RawLettuceSeeds";
	public static String iCLS = "CoatedLettuceSeeds";
	public static String iCP = "PastaWithSauce";
	public static String iMB = "meatballs";
	public static String iMBP = "pastaMeatballs";
	public static String iSushi = "sushi";
	public static String iFP = "FishPieces";
	public static String iPKeb = "porkKebab";
	public static String iSKeb = "steakKebab";
	public static String iVKeb = "vealKebab";
	public static String iCho = "chocolate";
	public static String iPC = "pancake";
    public static String iDough = "dough";
	
	
	
	//Sandwhiches
	public static String iSandCB = "BaconCheeseSandwhich";
	public static String iSandGC = "GrilledCheeseSandwhich";
	public static String iSandS = "SausageSandwhich";
	public static String iSandH = "HamburgerSandwhich";
	public static String iSandPBN = "PB&NSandwich";
	public static String iSandPBJ = "PB&JSandwich";
	public static String iSandBLT = "BLTSandwich";
	public static String iSandPeanutB = "PeanutButterSandwich";
	public static String iChoSandwich = "ChocolateSandwich";
	public static String iSandCheeseBurger = "CheeseburgerSandwhich";
	public static String iSandSupremeH = "SupremeHamburgerSandwhich";

	public static String iPB = "peanutButter";
	public static String iGrater = "Grater";
	public static String iButter = "butter";
	public static String iVanIceCream = "vanillaIceCream";
	public static String iChoIceCream = "chocolateIceCream";
	public static String iStrawIceCream = "strawberryIceCream";
	public static String iCNF = "chineseFood";
	public static String iChoSpread = "chocolateSpread";

	public static String iJ = "jelly";
	public static String iPopcicle = "icePopcicle";
	public static String iNeoIceCream = "neopolitanIceCream"; 
	public static String iYogurt = "yogurt";
	public static String iStrawYogurt = "strawberryYogurt";
	public static String iButterMilk = "ButterMilk";
	public static String iFrenchToast = "FrenchToast";
	public static String iShortB = "shortbread";
	public static String iFC = "FruitCake";
	public static String iGB = "gingerbread";
	public static String Chestnut = "chestnuts";
	public static String Cake = "ChocolateCake";
	public static String iMuffPan = "MuffinPan";


    //SEASONAL
    public static String iEggnog = "eggnog";
	public static String iOlive = "olive";
	public static String glassContainer = "EFglassBottle";


	//Special ones
	public static String iFF(){
			if(ConfigHandler.FeelLikeAure){
				return "PotatoLava";
			}
			return "FrenchFries";
	}
    public static String iFF = "FrenchFries";

}
