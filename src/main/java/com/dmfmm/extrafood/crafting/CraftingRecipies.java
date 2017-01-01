package com.dmfmm.extrafood.crafting;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.utilities.DateUtils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;


public class CraftingRecipies {


    public static void craftering()
    {
        //Blocks
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.CHEESE_PRESS, 1), new Object[] {"ipi", "ibi", "sss", 'i', "ingotIron", 'p', "plankWood", 'b', Items.BUCKET, 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.AUTO_CUTTER, 1), new Object[] {"pki", "psp", "p p", 'p', "plankWood", 'k', ItemLoader.KNIFE, 'i', "ingotIron", 's', "slabWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.JUICE_BLENDER, 1), new Object[]{"sss", " ws", "sss", 's', new ItemStack(Blocks.STONE_SLAB, 1, 0), 'w', "plankWood"}));
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.WHITEOUT), new Object[] {"bbb", "bbb", "bbb", 'b', new ItemStack(Items.DYE, 1, 15)});
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.OVEN), new Object[]{"iii", "irg", "sss", 'i', new ItemStack(Blocks.IRON_BLOCK), 'r', new ItemStack(Blocks.IRON_BARS), 'g', new ItemStack(Blocks.GLASS_PANE), 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)});

        //CookBook Recipies
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.APPLE}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.PORKCHOP}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.BEEF}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.CARROT}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.POTATO}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.COOKBOOK, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.FISH}));

        //Ice Cream and Cold things
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.VANILLA_ICE_CREAM), new Object[] {" i ", "bm ", " s ", 'i', Blocks.ICE, 'b', new ItemStack(Items.DYE, 1, 15), 'm', Items.MILK_BUCKET, 's', "foodBread"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.CHOCOLATE_ICE_CREAM), new Object[] {" i ", "cm ", " s ", 'i', Blocks.ICE, 'c', "foodChocolate", 'm', Items.MILK_BUCKET, 's', "foodBread"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.STRAWBERRY_ICE_CREAM), new Object[] {" i ", "tm ", " s ", 'i', Blocks.ICE, 't', "foodStrawberry", 'm', Items.MILK_BUCKET, 's', "foodBread"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.ICE_POP), new Object[] {" i ", " s ", 'i', Blocks.ICE, 's', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.NEOPOLITAN_ICE_CREAM), new Object[] {"vcs", " b ", 'v', "foodVanillaIceCream", 'c', "foodChocolateIceCream", 's', "foodStrawberryIceCream", 'b', Items.BOWL}));
        //Items and Food
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.MUFFIN_PAN), new Object[]{"   ", "ppp", "iii", 'p', Items.PAPER, 'i', Items.IRON_INGOT}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.CHOCOLATE_SPREAD), new Object[] {"gc ", "sb ", 'g', "itemGrater", 'c', "foodChocolate", 's', Items.BOWL, 'b', "foodButter"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.BUTTER), ItemLoader.BUTTER_MILK.setContainerItem(Items.BUCKET)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.GRATER, 1), new Object[] {"ii ", "ii ", "ss ", 'i', "ingotIron", 's', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.PANCAKES, 2), new Object[] {"ws ", "bm ", 'w', Items.WHEAT, 's', Items.SUGAR, 'b', "foodButter", 'm', Items.MILK_BUCKET}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.PEANUT_BUTTER, 1), "itemGrater", "foodPeanuts", new ItemStack (Items.BOWL, 1), "foodButter"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.GRATER, 1), new Object[] {"ss ", "ii ", "ii ", 's', "stickWood", 'i', "ingotIron"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.KNIFE, 1), new Object[] {"ii ", "ii ", " j ", 'i', "ingotIron", 'j', "stickWood"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.SUSHI), new ItemStack(Blocks.TALLGRASS, 1, 1), "fishpieces"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.CHINESE_FOOD), "foodSushi", "foodRawPasta", Items.PAPER));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.CHOCOLATE), new Object[] { " s ", " m ", " c ", 's', new ItemStack(Items.SUGAR), 'm', new ItemStack(Items.MILK_BUCKET), 'c', new ItemStack(Items.DYE, 1, 3)}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.PORK_KEBAB, 2), new ItemStack(Items.COOKED_PORKCHOP), "itemKnife", "cropLettuce"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.STEAK_KEBAB, 2), new ItemStack(Items.COOKED_BEEF), "itemKnife", "cropLettuce"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.VEAL_KEBAB, 2), new ItemStack(ItemLoader.VEAL), "itemKnife", "cropLettuce"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.JELLY), new Object[] {"gs ", "bu ", 'g', "itemGrater", 's', "foodStrawberry", 'b', new ItemStack(Items.BOWL), 'u', new ItemStack(Items.SUGAR)}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.YOGURT), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.STRAWBERRY_YOGURT), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT), "foodStrawberry"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.FRENCH_TOAST), "foodButter", "foodToast", "foodEgg"));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.DOUGH), new ItemStack(Items.WHEAT), new ItemStack(Items.WATER_BUCKET));
        //Sandwiches
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER_CHOCOLATE), new Object[] {" t ", " cp", " t ", 't', "foodToast", 'c', "foodChocolateSpread", 'p', "foodPeanutButter"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_BLT),new Object[] {" t ", "blo", " t ", 't', "foodToast", 'b', "foodCookedBacon", 'l', "cropLettuce", 'o', "cropTomato"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_HAMBURGER), new Object[] {" i ", " h ", " i ", 'i', "foodBread", 'h', "foodHamburger"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_GRILLED_CHEESE), new Object[] {" i ", " c ", " i ", 'i', "foodToast", 'c', "foodCheeseSlice"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_SAUSAGE), new Object[] {" i ", " s ", " i ", 'i', "foodBread", 's', "foodSausage"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_BACON_CHEESE), new Object[] {" i ", " bc", " i ", 'i', "foodBread", 'b', "foodCookedBacon", 'c', "foodCheeseSlice"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_CHOCOLATE), new Object[] {" i ", " c ", " i ", 'i', "foodBread", 'c', "foodChocolateSpread"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER), new Object[] {" i ", " p ", " i ", 'i', "foodBread", 'p', "foodPeanutButter"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER_JAM), new Object[] {" i ", " pj", " i ", 'i', "foodBread", 'p', "foodPeanutButter", 'j', "foodJelly"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_CHEESEBURGER), new Object[] {"ch ", 'c', "foodCheeseSlice", 'h', "foodHamburgerSandwich"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.SANDWICH_CHEESEBURGER), new Object[] {" t ", "ch ", " t ", 't', "foodBread", 'c', "foodCheeseSlice", 'h', "foodHamburger"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.SANDWICH_SUPREME_BURGER), "itemKnife", "cropLettuce", "cropTomato", "foodCheeseburger"));
        //Pasta
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.RAW_PASTA), new ItemStack(Items.BOWL), "itemKnife", "cropWheat"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.COOKED_PASTA), "itemKnife", "foodRawPasta", "cropTomato"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.MEATBALL_PASTA), "foodMeatballs", "foodCookedPasta"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.MEATBALL_PASTA), "foodMeatballs", "itemKnife", "foodRawPasta", "cropTomato"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.MEATBALL_PASTA), new ItemStack(Items.BOWL), "foodMeatballs", "itemKnife", "itemKnife", "cropWheat", "cropTomato"));
        //Seed Recipes
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.tomatoSeeds, 2), "cropTomato"));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.LETTUCE_SEEDS, 2), new ItemStack(Items.CLAY_BALL, 1), new ItemStack(ItemLoader.RAW_LETTUCE_SEEDS));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.GRAPE_VINE), new ItemStack(Blocks.VINE), new ItemStack(Items.WHEAT_SEEDS));
        //Seasonal

        if(DateUtils.isChristmas()){
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.FRUIT_CAKE), Items.BREAD, ItemLoader.STRAWBERRY, Items.CARROT, Items.APPLE);
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.SHORTBREAD_COOKIES, 2), Items.SUGAR, Items.WHEAT, ItemLoader.BUTTER);
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.GINGER_BREAD, 2), Items.SUGAR, Items.WHEAT, ItemLoader.BUTTER, Items.EGG);
            GameRegistry.addSmelting(ItemLoader.PEANUT, new ItemStack(ItemLoader.CHESTNUTS), 1F);
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.BUCKET_EGGNOG), ItemLoader.EGG, Items.MILK_BUCKET, ItemLoader.EGG);
        }
        if(DateUtils.isBirthDay()){
            GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.CHOCOLATE_CAKE), Items.CAKE, ItemLoader.CHOCOLATE);
        }

        Cutting(new ItemStack(Items.FISH, 1), new ItemStack(ItemLoader.FISH_PIECES, 1));
        Cutting(new ItemStack(ItemLoader.COOKED_HAMBURGER, 1), new ItemStack(ItemLoader.MEATBALLS, 3));
        Cutting(new ItemStack(ItemLoader.CHEESE_WHEEL, 1), new ItemStack(ItemLoader.CHEESE_SLICE, 8));
        Cutting(new ItemStack(Items.BREAD, 1), new ItemStack(ItemLoader.SLICED_BREAD, 6));
        Cutting(new ItemStack(Items.PORKCHOP, 1), new ItemStack(ItemLoader.SAUSAGE, 2));
        Cutting(new ItemStack(Items.POTATO, 1), new ItemStack(ItemLoader.FRENCH_FRIES, 1));
        Cutting(new ItemStack(Items.BEEF, 1), new ItemStack(ItemLoader.RAW_HAMBURGER, 1));
        Cutting(new ItemStack(Items.COOKED_BEEF, 1), new ItemStack(ItemLoader.COOKED_HAMBURGER, 1));
        Cutting(new ItemStack(ItemLoader.PINEAPPLE, 1), new ItemStack(ItemLoader.PINEAPPLE_SLICES, 4));

    }

    public static void furnacing()
    {
        GameRegistry.addSmelting(ItemLoader.BACON, new ItemStack(ItemLoader.COOKED_BACON, 1), 0.2F);
        GameRegistry.addSmelting(ItemLoader.SLICED_BREAD, new ItemStack(ItemLoader.TOAST, 1), 0.1F);
        GameRegistry.addSmelting(Items.EGG, new ItemStack(ItemLoader.EGG), 0.1F);
        GameRegistry.addSmelting(ItemLoader.BUCKET_SEA_WATER, new ItemStack(ItemLoader.BUCKET_PURIFIED_WATER, 1), 0.5F);
        GameRegistry.addSmelting(ItemLoader.BUCKET_PURIFIED_WATER, new ItemStack(Items.WATER_BUCKET, 1), 0.5F);
        GameRegistry.addSmelting(ItemLoader.RAW_HAMBURGER, new ItemStack(ItemLoader.COOKED_HAMBURGER), 0.7F);
        GameRegistry.addSmelting(Items.MILK_BUCKET, new ItemStack(ItemLoader.BUTTER_MILK), 0.9F);
    }

    /**
     *  Adds in recipes that can be cut by the knife and cut by the Auto Cutter.
     *  <ul>
     *  <li>params:</li>
     *  <li>input - Item that goes in</li>
     * 	<li>output - Item that comes out</li>
     */
    public static void Cutting(ItemStack input, ItemStack output){
        ExtraFood.INSTANCE.registryCutter.registerRecipe(input, output);
        GameRegistry.addShapelessRecipe(output, new ItemStack(ItemLoader.KNIFE, 1, 32767), input);
    }

}