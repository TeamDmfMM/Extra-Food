package com.dmfmm.extrafood.library;


import com.dmfmm.extrafood.utilities.ConfigHandler;

public class ItemLib {

    public static final String CHEESE_WHEEL = "Cheese_Wheel";
    public static final String BANANA = "Banana";
    public static final String KNIFE = "Knife";
    public static final String CHEESE_SLICE = "Cheeseslice";
    public static final String COOKBOOK = "Cookbook";
    public static final String SAUSAGE = "Sausage";
    public static final String STRAWBERRY = "Strawberry";
    public static final String STRAWBERRY_BUCKET = "BucketStrawberry";
    public static final String BANANA_BUCKET = "BucketBanana";
    public static final String BACON = "Bacon";
    public static final String CARROT_BUCKET = "BucketCarrot";
    public static final String VEAL = "Veal";
    public static final String COOKED_BACON = "CookedBacon";
    public static final String BREAD_SLICE = "BreadSlice";
    public static final String TOAST = "Toast";
    public static final String SEA_WATER_BUCKET = "BucketSeaWater";
    public static final String PURIFIED_WATER_BUCKET = "BucketPurifiedWater";
    public static final String EGG = "Egg";
    public static final String PASTA = "Pasta";
    public static final String RAW_HAMBURGER = "RawHamburger";
    public static final String COOKED_HAMBURGER = "CookedHamburger";
    public static final String PEANUT = "Peanut";
    public static final String TOMATO = "Tomato";
    public static final String TOMATO_SEED = "TomatoSeeds";
    public static final String LETTUCE = "Lettuce";
    public static final String USELESS_LETTUCE_SEEDS = "RawLettuceSeeds";
    public static final String COATED_LETTUCE_SEEDS = "CoatedLettuceSeeds";
    public static final String PASTA_WITH_SAUCE = "PastaWithSauce";
    public static final String MEATBALLS = "meatballs";
    public static final String PASTA_MEATBALLS = "pastaMeatballs";
    public static final String SUSHI = "sushi";
    public static final String FISH_PIECES = "FishPieces";
    public static final String PORK_KEBAB = "porkKebab";
    public static final String STEAK_KEBAB = "steakKebab";
    public static final String VEAL_KEBAB = "vealKebab";
    public static final String CHOCOLATE = "chocolate";
    public static final String PANCAKE = "pancake";
    public static final String DOUGH = "dough";



    //Sandwhiches
    public static final String BACON_CHEESE_SANDWICH = "BaconCheeseSandwich";
    public static final String GRILLED_CHEESE_SANDWICH = "GrilledCheeseSandwich";
    public static final String SAUSAGE_SANDWICH = "SausageSandwich";
    public static final String HAMBURGER_SANDWICH = "HamburgerSandwich";
    public static final String PEANUTBUTTER_CHOCOLATE_SANDWICH = "PB&NSandwich";
    public static final String PEANUTBUTTER_JAM_SANDWICH = "PB&JSandwich";
    public static final String BLT_SANDWICH = "BLTSandwich";
    public static final String PEANUTBUTTER_SANDWICH = "PeanutButterSandwich";
    public static final String CHOCOLATE_SANDWICH = "ChocolateSandwich";
    public static final String CHEESEBURGER_SANDWICH = "CheeseburgerSandwich";
    public static final String SUPREME_HAMBURGER_SANDWICH = "SupremeHamburgerSandwich";

    public static final String PEANUTBUTTER = "peanutButter";
    public static final String GRATER = "Grater";
    public static final String BUTTER = "butter";
    public static final String VANILLA_ICE_CREAM = "vanillaIceCream";
    public static final String CHOCOLATE_ICE_CREAM = "chocolateIceCream";
    public static final String STRAWBERRY_ICE_CREAM = "strawberryIceCream";
    public static final String CHINSESE_FOOD = "chineseFood";
    public static final String CHOCOLATE_SPREAD = "chocolateSpread";

    public static final String JELLY = "jelly";
    public static final String ICE_POP = "icePopcicle";
    public static final String NEOPOLITIAN_ICE_CREAM = "neopolitanIceCream";
    public static final String YOGURT = "yogurt";
    public static final String STRAWBERRY_YOGURT = "strawberryYogurt";
    public static final String BUTTER_MILK = "ButterMilk";
    public static final String FRENCH_TOAST = "FrenchToast";
    public static final String MUFFIN_PAN = "MuffinPan";
    public static final String ORANGE = "Orange";
    public static final String PINEAPPLE = "pineapple";
    public static final String PINEAPPLE_SLICE = "pineappleSlice";
    public static final String GRAPES =  "Grapes";
    public static final String OLIVES = "olive";
    public static final String GLASS_CONTAINER = "EFglassBottle";

    //SEASONAL
    public static final String SHORTBREAD_COOKIES = "shortbread";
    public static final String FRUIT_CAKE = "FruitCake";
    public static final String GINGER_BREAD = "gingerbread";
    public static final String CHESTNUTS = "chestnuts";
    public static final String CHOCOLATE_CAKE = "chocolatecake";

    //SEASONAL
    public static final String EGGNOG = "eggnog";


    //Special ones
    public static final String getFrenchFriesTextureName(){
        if(ConfigHandler.FeelLikeAure){
            return "PotatoLava";
        }
        return "FrenchFries";
    }
    public static final String FRENCH_FRIES = "FrenchFries";

}
