package com.dmfmm.extrafood.init;


import com.dmfmm.extrafood.items.*;
import com.dmfmm.extrafood.library.ItemLib;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Field;

public class ItemLoader {

    private static boolean FRegister=false;

    public static final Item KNIFE = new Knife().setUnlocalizedName(ItemLib.KNIFE);
    public static final Item COOKBOOK = new CookBook().setUnlocalizedName(ItemLib.COOKBOOK);
    public static final Item GRATER = new Grater().setUnlocalizedName(ItemLib.GRATER);
    public static final Item BUCKET_STRAWBERRY = new BucketEdible(6, 0.8F, BlockLoader.STRAWBERRY_JUICE_BLOCK, ItemLib.STRAWBERRY_BUCKET);
    public static final Item BUCKET_BANANA = new BucketEdible(6, 0.6F, BlockLoader.BANANA_JUICE_BLOCK, ItemLib.BANANA_BUCKET);
    public static final Item BUCKET_CARROT = new BucketEdible(6, 0.9F, BlockLoader.CARROT_JUICE_BLOCK, ItemLib.CARROT_BUCKET);
    public static final Item BUCKET_SEA_WATER = new BucketEdible(2, 0.5F, Blocks.WATER, ItemLib.SEA_WATER_BUCKET);
    public static final Item BUCKET_PURIFIED_WATER = new BucketEdible(4, 0.5F, Blocks.WATER, ItemLib.PURIFIED_WATER_BUCKET);
    public static final Item BUCKET_EGGNOG = new BucketEdible(9, 5.0F, BlockLoader.EGGNOG_FLUID_BLOCK, ItemLib.EGGNOG);
    public static final Item TOMATO_SEEDS = (ItemSeeds) new ItemSeeds(BlockLoader.TOMATO_CROP, Blocks.FARMLAND).setUnlocalizedName(ItemLib.TOMATO_SEED).setCreativeTab(ExtraFoodTab.INSTANCE);
    public static final Item RAW_LETTUCE_SEEDS = new GenericItem(ItemLib.USELESS_LETTUCE_SEEDS, true);
    public static final Item PINEAPPLE = new ItemSeedFood(8, 3.0F, BlockLoader.PINEAPPLE_CROP, Blocks.FARMLAND).setUnlocalizedName(ItemLib.PINEAPPLE).setCreativeTab(ExtraFoodTab.INSTANCE);
    public static final Item LETTUCE_SEEDS = (ItemSeeds) new ItemSeeds(BlockLoader.LETTUCE_CROP, Blocks.FARMLAND).setUnlocalizedName(ItemLib.COATED_LETTUCE_SEEDS).setCreativeTab(ExtraFoodTab.INSTANCE);
    public static final Item MUFFIN_PAN = new GenericItem(ItemLib.MUFFIN_PAN, true);
    public static final Item DOUGH = new GenericItem(ItemLib.DOUGH, true);


    //Semi-balanced foods
    public static final Item GRAPES = new StanFood(ItemLib.GRAPES, 3, 1.2f);
    public static final Item SAUSAGE = new StanFood(ItemLib.SAUSAGE, 3, 0.9F);
    public static final Item CHEESE_SLICE = new StanFood(ItemLib.CHEESE_SLICE, 2, 3.0F);
    public static final Item PINEAPPLE_SLICES = new StanFood(ItemLib.PINEAPPLE_SLICE, 2, 1.5f);
    public static final Item CHEESE_WHEEL = new StanFood(ItemLib.CHEESE_WHEEL, 8, 5.6F);
    public static final Item BANANA = ((ItemFood) new StanFood(ItemLib.BANANA, 4, 0.8F)).setAlwaysEdible().setMaxStackSize(10);
    public static final Item STRAWBERRY = ((ItemFood) new StanFood(ItemLib.STRAWBERRY, 2, 2.0F)).setAlwaysEdible().setMaxStackSize(32);
    public static final Item BACON = new StanFood(ItemLib.BACON, 1, 0.6F);
    public static final Item VEAL = new StanFood(ItemLib.VEAL, 8, 19.5F, true);
    public static final Item COOKED_BACON = new StanFood(ItemLib.COOKED_BACON, 2, 5.2F);
    public static final Item TOAST = new StanFood(ItemLib.TOAST, 6, 0.8F);
    public static final Item SLICED_BREAD = new StanFood(ItemLib.BREAD_SLICE, 4, 3.0F);
    public static final Item FRENCH_FRIES = new StanFood(ItemLib.FRENCH_FRIES, 8, 0.7F, false, true, ItemLib.getFrenchFriesTextureName());
    public static final Item TOMATO = new StanFood(ItemLib.TOMATO, 4, 2.5F);
    public static final Item LETTUCE = new StanFood(ItemLib.LETTUCE, 4, 1.6F);
    public static final Item EGG = new StanFood(ItemLib.EGG, 3, 0.8F);
    public static final Item PORK_KEBAB = new StanFood(ItemLib.PORK_KEBAB, 3, 12.3F);
    public static final Item STEAK_KEBAB = new StanFood(ItemLib.STEAK_KEBAB, 3, 12.4F);
    public static final Item VEAL_KEBAB = new StanFood(ItemLib.VEAL_KEBAB, 3, 12.6F);
    public static final Item SUSHI = new StanFood(ItemLib.SUSHI, 8, 2.6F);
    public static final Item RAW_HAMBURGER = ((ItemFood) new StanFood(ItemLib.RAW_HAMBURGER, 5, 0.6F)).setPotionEffect(new PotionEffect(MobEffects.POISON, 10), 0.4F);

    //Non-balanced foods

    //Return Foods
    public static final Item RAW_PASTA = new ReturnFood(ItemLib.PASTA, 3, 0.3F, Items.BOWL);
    public static final Item MEATBALL_PASTA = new ReturnFood(ItemLib.PASTA_MEATBALLS, 12, 1.4F, Items.BOWL);
    public static final Item COOKED_PASTA = new ReturnFood(ItemLib.PASTA_WITH_SAUCE, 6, 1.3F, Items.BOWL);
    public static final Item BUTTER_MILK = new ReturnFood(ItemLib.BUTTER_MILK, 8, 3.6F, Items.BUCKET);
    public static final Item YOGURT = new ReturnFood(ItemLib.YOGURT, 5, 6.3F, Items.BOWL);
    public static final Item STRAWBERRY_YOGURT = new ReturnFood(ItemLib.STRAWBERRY_YOGURT, 5, 6.8F, Items.BOWL);
    public static final Item NEOPOLITAN_ICE_CREAM = new ReturnFood(ItemLib.NEOPOLITIAN_ICE_CREAM, 8, 4.5F, Items.BOWL);

    //Drink Action Foods
    public static final Item VANILLA_ICE_CREAM = new DrinkActionFood(ItemLib.VANILLA_ICE_CREAM, 4, 0.8F);
    public static final Item CHOCOLATE_ICE_CREAM = new DrinkActionFood(ItemLib.CHOCOLATE_ICE_CREAM, 8, 0.8F);
    public static final Item STRAWBERRY_ICE_CREAM = new DrinkActionFood(ItemLib.STRAWBERRY_ICE_CREAM, 9, 2.5F);
    public static final Item ICE_POP = new DrinkActionFood(ItemLib.ICE_POP, 5, 3.3F);

    //Normal Foods
    public static final Item SANDWICH_SAUSAGE = new StanFood(ItemLib.SAUSAGE_SANDWICH, 7, 1.0F);
    public static final Item SANDWICH_BACON_CHEESE = new StanFood(ItemLib.BACON_CHEESE_SANDWICH, 6, 1.4F);
    public static final Item SANDWICH_GRILLED_CHEESE = new StanFood(ItemLib.GRILLED_CHEESE_SANDWICH, 6, 1.9F);
    public static final Item COOKED_HAMBURGER = new StanFood(ItemLib.COOKED_HAMBURGER, 7, 1.6F);
    public static final Item SANDWICH_HAMBURGER = new StanFood(ItemLib.HAMBURGER_SANDWICH, 9, 1.0F);
    public static final Item PEANUT = ((ItemFood) new StanFood(ItemLib.PEANUT, 1, 0.2F)).setAlwaysEdible();
    public static final Item MEATBALLS = new StanFood(ItemLib.MEATBALLS,3, 0.4F);
    public static final Item FISH_PIECES = new StanFood(ItemLib.FISH_PIECES, 4, 0.5F);
    public static final Item CHOCOLATE = new StanFood(ItemLib.CHOCOLATE, 4, 1.8F);
    public static final Item PANCAKES = new StanFood(ItemLib.PANCAKE, 6, 1.2F);
    public static final Item PEANUT_BUTTER = ((ItemFood) new StanFood(ItemLib.PEANUTBUTTER, 3, 4.5F)).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 10), 0.8F);
    public static final Item BUTTER = new StanFood(ItemLib.BUTTER, 1, 1.0F);
    public static final Item CHINESE_FOOD = new StanFood(ItemLib.CHINSESE_FOOD, 7, 5.0F);
    public static final Item CHOCOLATE_SPREAD = ((ItemFood) new StanFood(ItemLib.CHOCOLATE_SPREAD, 8, 4.5F)).setPotionEffect(new PotionEffect(MobEffects.SPEED, 10), 0.8F);
    public static final Item JELLY = ((ItemFood) new StanFood(ItemLib.JELLY, 5, 2.0F)).setPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1), 0.1F);
    public static final Item SANDWICH_BLT = new StanFood(ItemLib.BLT_SANDWICH, 8, 10.0F);
    public static final Item SANDWICH_PEANUTBUTTER_JAM = new StanFood(ItemLib.PEANUTBUTTER_JAM_SANDWICH, 8, 9.5F);
    public static final Item SANDWICH_PEANUTBUTTER_CHOCOLATE = new StanFood(ItemLib.PEANUTBUTTER_CHOCOLATE_SANDWICH, 8, 9.0F);
    public static final Item SANDWICH_PEANUTBUTTER = new StanFood(ItemLib.PEANUTBUTTER_SANDWICH, 6, 3.5F);
    public static final Item SANDWICH_CHOCOLATE = new StanFood(ItemLib.CHOCOLATE_SANDWICH, 9, 5.5F);
    public static final Item FRENCH_TOAST = new StanFood(ItemLib.FRENCH_TOAST, 7, 2.7F);
    public static final Item SANDWICH_CHEESEBURGER = new StanFood(ItemLib.CHEESEBURGER_SANDWICH, 10, 12.0F);
    public static final Item SANDWICH_SUPREME_BURGER = new StanFood(ItemLib.SUPREME_HAMBURGER_SANDWICH, 15, 11.2F);
    public static final Item OLIVE = new StanFood(ItemLib.OLIVES, 4, 3.0F);
    public static final Item ORANGE = new StanFood(ItemLib.ORANGE, 5, 3.0F);

    //Seasonal
    public static final Item SHORTBREAD_COOKIES = new StanFood(ItemLib.SHORTBREAD_COOKIES, 8, 5.0F);
    public static final Item FRUIT_CAKE = new StanFood(ItemLib.FRUIT_CAKE, 12, 5.0F);
    public static final Item GINGER_BREAD = new StanFood(ItemLib.GINGER_BREAD, 9, 5.0F);
    public static final Item CHESTNUTS = new StanFood(ItemLib.CHESTNUTS, 10, 5.0F);
    public static final Item CHOCOLATE_CAKE = new ItemBlockSpecial(BlockLoader.CHOCOLATE_CAKE_BLOCK).setMaxStackSize(1).setUnlocalizedName(ItemLib.CHOCOLATE_CAKE).setCreativeTab(ExtraFoodTab.INSTANCE);


    public static void registerItems(){
        try{
            for(Field field : ItemLoader.class.getDeclaredFields()){
                if(field.get(null) instanceof Item){
                    GameRegistry.register((Item)field.get(null));

                }
            }
        }catch (Exception e){

        }
    }

    public static void registerOreDictionary() {
        if(!FRegister){
            //Register into Ore Dictionary
            OreDictionary.registerOre("foodHamburger", ItemLoader.COOKED_HAMBURGER);
            OreDictionary.registerOre("foodBanana", ItemLoader.BANANA);
            OreDictionary.registerOre("foodBread", ItemLoader.SLICED_BREAD);
            OreDictionary.registerOre("foodToast", ItemLoader.TOAST);
            OreDictionary.registerOre("foodCheeseSlice", ItemLoader.CHEESE_SLICE);
            OreDictionary.registerOre("foodSausage", ItemLoader.SAUSAGE);
            OreDictionary.registerOre("foodRawPasta", ItemLoader.RAW_PASTA);
            OreDictionary.registerOre("foodPeanuts", ItemLoader.PEANUT);
            OreDictionary.registerOre("foodStrawberry", ItemLoader.STRAWBERRY);
            OreDictionary.registerOre("cropTomato", ItemLoader.TOMATO);
            OreDictionary.registerOre("cropLettuce", ItemLoader.LETTUCE);
            OreDictionary.registerOre("foodCookedBacon", ItemLoader.COOKED_BACON);
            OreDictionary.registerOre("foodCookedPasta", ItemLoader.COOKED_PASTA);
            OreDictionary.registerOre("foodMeatballs", ItemLoader.MEATBALLS);
            OreDictionary.registerOre("foodMeatballPasta", ItemLoader.MEATBALL_PASTA);
            OreDictionary.registerOre("foodSushi", ItemLoader.SUSHI);
            OreDictionary.registerOre("foodPineappleSlice", ItemLoader.PINEAPPLE_SLICES);
            OreDictionary.registerOre("foodGrape", ItemLoader.GRAPES);
            OreDictionary.registerOre("foodStrawberryIceCream", ItemLoader.STRAWBERRY_ICE_CREAM);
            OreDictionary.registerOre("foodVanillaIceCream", ItemLoader.VANILLA_ICE_CREAM);
            OreDictionary.registerOre("foodChocolateIceCream", ItemLoader.CHOCOLATE_ICE_CREAM);
            OreDictionary.registerOre("fishpieces", ItemLoader.FISH_PIECES);
            OreDictionary.registerOre("foodChocolate", ItemLoader.CHOCOLATE);
            OreDictionary.registerOre("itemKnife", ItemLoader.KNIFE);
            OreDictionary.registerOre("foodPancakes", ItemLoader.PANCAKES);
            OreDictionary.registerOre("foodPeanutButter", ItemLoader.PEANUT_BUTTER);
            OreDictionary.registerOre("foodChinese", ItemLoader.CHINESE_FOOD);
            OreDictionary.registerOre("itemGrater", new ItemStack(ItemLoader.GRATER, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("foodButter", ItemLoader.BUTTER);
            OreDictionary.registerOre("foodChocolateSpread", ItemLoader.CHOCOLATE_SPREAD);
            OreDictionary.registerOre("foodEgg", ItemLoader.EGG);
            OreDictionary.registerOre("foodJelly", ItemLoader.JELLY);
            OreDictionary.registerOre("foodBLT", ItemLoader.SANDWICH_BLT);
            OreDictionary.registerOre("foodPBJ", ItemLoader.SANDWICH_PEANUTBUTTER_JAM);
            OreDictionary.registerOre("foodPBN", ItemLoader.SANDWICH_PEANUTBUTTER_CHOCOLATE);
            OreDictionary.registerOre("foodNeoIceCream", ItemLoader.NEOPOLITAN_ICE_CREAM);
            OreDictionary.registerOre("foodIcePop", ItemLoader.ICE_POP);
            OreDictionary.registerOre("foodSandwichPeanutButter", ItemLoader.SANDWICH_PEANUTBUTTER);
            OreDictionary.registerOre("foodButterMilk", ItemLoader.BUTTER_MILK);
            OreDictionary.registerOre("foodYogurt", ItemLoader.YOGURT);
            OreDictionary.registerOre("foodStrawberryYogurt", ItemLoader.STRAWBERRY_YOGURT);
            OreDictionary.registerOre("foodChocolateSandwich", ItemLoader.SANDWICH_CHOCOLATE);
            OreDictionary.registerOre("foodHamburgerSandwich", ItemLoader.SANDWICH_HAMBURGER);
            OreDictionary.registerOre("foodCheeseburger", ItemLoader.SANDWICH_CHEESEBURGER);
            OreDictionary.registerOre("foodSupremeBurger", ItemLoader.SANDWICH_SUPREME_BURGER);
            OreDictionary.registerOre("foodFrenchToast", ItemLoader.FRENCH_TOAST);
            OreDictionary.registerOre("foodDough", ItemLoader.DOUGH);
            OreDictionary.registerOre("foodOlive", ItemLoader.OLIVE);
            OreDictionary.registerOre("foodOrange", ItemLoader.ORANGE);

        }
        FRegister=true;
    }

}

