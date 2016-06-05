package dmf444.ExtraFood.Core;

import dmf444.ExtraFood.Common.RecipeHandler.RecipeAutoCutter;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.DateUtil;
import dmf444.ExtraFood.ExtraFood;
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
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', "ingotIron", 'p', "plankWood", 'b', Items.BUCKET, 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.autoCutter, 1), new Object[] {"pki", "psp", "p p", 'p', "plankWood", 'k', ItemLoader.knife, 'i', "ingotIron", 's', "slabWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.juiceBlender, 1), new Object[]{"sss", " ws", "sss", 's', new ItemStack(Blocks.STONE_SLAB, 1, 0), 'w', "plankWood"}));
	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteout), new Object[] {"bbb", "bbb", "bbb", 'b', new ItemStack(Items.DYE, 1, 15)});
	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oven), new Object[]{"iii", "irg", "sss", 'i', new ItemStack(Blocks.IRON_BLOCK), 'r', new ItemStack(Blocks.IRON_BARS), 'g', new ItemStack(Blocks.GLASS_PANE), 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)});
	
	//CookBook Recipies
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.APPLE}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.PORKCHOP}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.BEEF}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.CARROT}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.POTATO}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.BOOK, 'l', Items.LEATHER, 'f', Items.FISH}));
	
	//Ice Cream and Cold things
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.vanillaIceCream), new Object[] {" i ", "bm ", " s ", 'i', Blocks.ICE, 'b', new ItemStack(Items.DYE, 1, 15), 'm', Items.MILK_BUCKET, 's', "foodBread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolateIceCream), new Object[] {" i ", "cm ", " s ", 'i', Blocks.ICE, 'c', "foodChocolate", 'm', Items.MILK_BUCKET, 's', "foodBread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.strawberryIceCream), new Object[] {" i ", "tm ", " s ", 'i', Blocks.ICE, 't', "foodStrawberry", 'm', Items.MILK_BUCKET, 's', "foodBread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.icePop), new Object[] {" i ", " s ", 'i', Blocks.ICE, 's', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.neoIceCream), new Object[] {"vcs", " b ", 'v', "foodVanillaIceCream", 'c', "foodChocolateIceCream", 's', "foodStrawberryIceCream", 'b', Items.BOWL}));
	//Items and Food
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.muffinPan), new Object[]{"   ", "ppp", "iii", 'p', Items.PAPER, 'i', Items.IRON_INGOT}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolateSpread), new Object[] {"gc ", "sb ", 'g', "itemGrater", 'c', "foodChocolate", 's', Items.BOWL, 'b', "foodButter"}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.butter), ItemLoader.butterMilk.setContainerItem(Items.BUCKET)));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.grater, 1), new Object[] {"ii ", "ii ", "ss ", 'i', "ingotIron", 's', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.pancakes, 2), new Object[] {"ws ", "bm ", 'w', Items.WHEAT, 's', Items.SUGAR, 'b', "foodButter", 'm', Items.MILK_BUCKET}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.peanutButter, 1), "itemGrater", "foodPeanuts", new ItemStack (Items.BOWL, 1), "foodButter"));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.grater, 1), new Object[] {"ss ", "ii ", "ii ", 's', "stickWood", 'i', "ingotIron"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', "ingotIron", 'j', "stickWood"}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.sushi), new ItemStack(Blocks.TALLGRASS, 1, 1), "fishpieces"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.chineseFood), "foodSushi", "foodRawPasta", Items.PAPER));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolate), new Object[] { " s ", " m ", " c ", 's', new ItemStack(Items.SUGAR), 'm', new ItemStack(Items.MILK_BUCKET), 'c', new ItemStack(Items.DYE, 1, 3)}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.pork_kebab, 2), new ItemStack(Items.COOKED_PORKCHOP), "itemKnife", "cropLettuce"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.steak_kebab, 2), new ItemStack(Items.COOKED_BEEF), "itemKnife", "cropLettuce"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.veal_kebab, 2), new ItemStack(ItemLoader.veal), "itemKnife", "cropLettuce"));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.jelly), new Object[] {"gs ", "bu ", 'g', "itemGrater", 's', "foodStrawberry", 'b', new ItemStack(Items.BOWL), 'u', new ItemStack(Items.SUGAR)}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.yogurt), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT)));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.stawberryYogurt), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT), "foodStrawberry"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.frenchToast), "foodButter", "foodToast", "foodEgg"));
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.dough), new ItemStack(Items.WHEAT), new ItemStack(Items.WATER_BUCKET));
	//Sandwiches
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichPBN), new Object[] {" t ", " cp", " t ", 't', "foodToast", 'c', "foodChocolateSpread", 'p', "foodPeanutButter"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichBLT),new Object[] {" t ", "blo", " t ", 't', "foodToast", 'b', "foodCookedBacon", 'l', "cropLettuce", 'o', "cropTomato"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwhichHamburger), new Object[] {" i ", " h ", " i ", 'i', "foodBread", 'h', "foodHamburger"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwhichGC), new Object[] {" i ", " c ", " i ", 'i', "foodToast", 'c', "foodCheeseSlice"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwhichS), new Object[] {" i ", " s ", " i ", 'i', "foodBread", 's', "foodSausage"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwhichCB), new Object[] {" i ", " bc", " i ", 'i', "foodBread", 'b', "foodCookedBacon", 'c', "foodCheeseSlice"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichC), new Object[] {" i ", " c ", " i ", 'i', "foodBread", 'c', "foodChocolateSpread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichPB), new Object[] {" i ", " p ", " i ", 'i', "foodBread", 'p', "foodPeanutButter"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichPBJ), new Object[] {" i ", " pj", " i ", 'i', "foodBread", 'p', "foodPeanutButter", 'j', "foodJelly"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichCheeseburger), new Object[] {"ch ", 'c', "foodCheeseSlice", 'h', "foodHamburgerSandwich"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.sandwichCheeseburger), new Object[] {" t ", "ch ", " t ", 't', "foodBread", 'c', "foodCheeseSlice", 'h', "foodHamburger"}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.sandwichSupremeBurger), "itemKnife", "cropLettuce", "cropTomato", "foodCheeseburger"));
	//Pasta
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.rawpasta), new ItemStack(Items.BOWL), "itemKnife", "cropWheat"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.cookedpasta), "itemKnife", "foodRawPasta", "cropTomato"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), "foodMeatballs", "foodCookedPasta"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), "foodMeatballs", "itemKnife", "foodRawPasta", "cropTomato"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), new ItemStack(Items.BOWL), "foodMeatballs", "itemKnife", "itemKnife", "cropWheat", "cropTomato"));
	//Seed Recipes
	//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.tomatoSeeds, 2), "cropTomato"));
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.uselettuceSeeds, 2), new ItemStack(Items.CLAY_BALL, 1), new ItemStack(ItemLoader.rawlettuceSeeds));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.grapeVine), new ItemStack(Blocks.VINE), new ItemStack(Items.WHEAT_SEEDS));
	//Seasonal

	if(DateUtil.isChristmas()){
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.fruitcake), Items.BREAD, ItemLoader.strawberry, Items.CARROT, Items.APPLE);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.shortbread, 2), Items.SUGAR, Items.WHEAT, ItemLoader.butter);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.gingerbread, 2), Items.SUGAR, Items.WHEAT, ItemLoader.butter, Items.EGG);
		GameRegistry.addSmelting(ItemLoader.peanut, new ItemStack(ItemLoader.chestnuts), 1F);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.bucketeggnog), ItemLoader.egg, Items.MILK_BUCKET, ItemLoader.egg);
	}
	if(DateUtil.isBirthDay()){
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.ChocolateCake), Items.CAKE, ItemLoader.chocolate);
	}
	
	Cutting(new ItemStack(Items.FISH, 1), new ItemStack(ItemLoader.fishpieces, 1));
	Cutting(new ItemStack(ItemLoader.cookedHamburger, 1), new ItemStack(ItemLoader.meatballs, 3));
	Cutting(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8));
	Cutting(new ItemStack(Items.BREAD, 1), new ItemStack(ItemLoader.slicedBread, 6));
	Cutting(new ItemStack(Items.PORKCHOP, 1), new ItemStack(ItemLoader.sausage, 2));
	Cutting(new ItemStack(Items.POTATO, 1), new ItemStack(ItemLoader.frenchFries, 1));
	Cutting(new ItemStack(Items.BEEF, 1), new ItemStack(ItemLoader.rawHamburger, 1));
	Cutting(new ItemStack(Items.COOKED_BEEF, 1), new ItemStack(ItemLoader.cookedHamburger, 1));
		Cutting(new ItemStack(ItemLoader.pineapple, 1), new ItemStack(ItemLoader.pineappleSlice, 4));
	
	}
	public static int totalCuts = 9;//Put the total number, subtraction is taken care of in another class
	public static void furnacing()
	{
		GameRegistry.addSmelting(ItemLoader.bacon, new ItemStack(ItemLoader.cookedBacon, 1), 0.2F);
		GameRegistry.addSmelting(ItemLoader.slicedBread, new ItemStack(ItemLoader.toast, 1), 0.1F);
		GameRegistry.addSmelting(Items.EGG, new ItemStack(ItemLoader.egg), 0.1F);
		GameRegistry.addSmelting(ItemLoader.bucketseaWater, new ItemStack(ItemLoader.bucketpurifiedwater, 1), 0.5F);
		GameRegistry.addSmelting(ItemLoader.bucketpurifiedwater, new ItemStack(Items.WATER_BUCKET, 1), 0.5F);
		GameRegistry.addSmelting(ItemLoader.rawHamburger, new ItemStack(ItemLoader.cookedHamburger), 0.7F);
		GameRegistry.addSmelting(Items.MILK_BUCKET, new ItemStack(ItemLoader.butterMilk), 0.9F);
	}
	
	/**
	 *  Adds in recipes that can be cut by the knife and cut by the Auto Cutter.
	 *  <ul>
	 *  <li>params:</li>
	 *  <li>input - Item that goes in</li>
	 * 	<li>output - Item that comes out</li>
	 */
	public static void Cutting(ItemStack input, ItemStack output){
		ExtraFood.instance.registryCutter.registerRecipe(new RecipeAutoCutter(input, output));
		GameRegistry.addShapelessRecipe(output, new ItemStack(ItemLoader.knife, 1, 32767), input);
	}
	
}
