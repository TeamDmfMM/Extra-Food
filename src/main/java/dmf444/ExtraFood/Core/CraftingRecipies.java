package dmf444.ExtraFood.Core;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.RecipeAutoCutter;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.util.DateUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;


public class CraftingRecipies {

	
	public static void craftering()
	{
	//Blocks
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', "ingotIron", 'p', "plankWood", 'b', Items.bucket, 's', new ItemStack(Blocks.stone_slab, 1, 0)}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.autoCutter, 1), new Object[] {"pki", "psp", "p p", 'p', "plankWood", 'k', ItemLoader.knife, 'i', "ingotIron", 's', "slabWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockLoader.juiceBlender, 1), new Object[] {"sss", " ws", "sss", 's', new ItemStack(Blocks.stone_slab, 1, 0), 'w', "plankWood"}));
	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteout), new Object[] {"bbb", "bbb", "bbb", 'b', new ItemStack(Items.dye, 1, 15)});
	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oven), new Object[] {"iii", "irg", "sss", 'i', new ItemStack(Blocks.iron_block), 'r', new ItemStack(Blocks.iron_bars), 'g', new ItemStack(Blocks.glass_pane), 's', new ItemStack(Blocks.stone_slab, 1, 0)});
	
	//CookBook Recipies
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.apple}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.porkchop}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.beef}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.carrot}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.potato}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.cookBook, 1), new Object[] {" b ", " l ", " f ", 'b', Items.book, 'l', Items.leather, 'f', Items.fish}));
	
	//Ice Cream and Cold things
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.vanillaIceCream), new Object[] {" i ", "bm ", " s ", 'i', Blocks.ice, 'b', new ItemStack(Items.dye, 1, 15), 'm', Items.milk_bucket, 's', "foodBread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolateIceCream), new Object[] {" i ", "cm ", " s ", 'i', Blocks.ice, 'c', "foodChocolate", 'm', Items.milk_bucket, 's', "foodBread"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.strawberryIceCream), new Object[] {" i ", "tm ", " s ", 'i', Blocks.ice, 't', "foodStrawberry", 'm', Items.milk_bucket, 's', "foodBread"}));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.icePop), new Object[] {" i ", " s ", 'i', Blocks.ice, 's', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.neoIceCream), new Object[] {"vcs", " b ", 'v', "foodVanillaIceCream", 'c', "foodChocolateIceCream", 's', "foodStrawberryIceCream", 'b', Items.bowl}));
	//Items and Food
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolateSpread), new Object[] {"gc ", "sb ", 'g', "itemGrater", 'c', "foodChocolate", 's', Items.bowl, 'b', "foodButter"}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.butter), ItemLoader.butterMilk.setContainerItem(Items.bucket)));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.grater), new Object[] {"ii ", "ii ", "ss ", 'i', "ingotIron", 's', "stickWood"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.pancakes, 2), new Object[] {"ws ", "bm ", 'w', Items.wheat, 's', Items.sugar, 'b', "foodButter", 'm', Items.milk_bucket}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.peanutButter, 1), "itemGrater", "foodPeanuts", new ItemStack (Items.bowl, 1), "foodButter"));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.grater, 1), new Object[] {"ss ", "ii ", "ii ", 's', "stickWood", 'i', "ingotIron"}));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', "ingotIron", 'j', "stickWood"}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.sushi), new ItemStack(Blocks.tallgrass, 1, 1), "fishpieces"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.chineseFood), "foodSushi", "foodRawPasta", Items.paper));
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.chocolate), new Object[] { " s ", " m ", " c ", 's', new ItemStack(Items.sugar), 'm', new ItemStack(Items.milk_bucket), 'c', new ItemStack(Items.dye, 1, 3)}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.pork_kebab, 2), new ItemStack(Items.cooked_porkchop), "itemKnife", "cropLettuce"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.steak_kebab, 2), new ItemStack(Items.cooked_beef), "itemKnife", "cropLettuce"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.veal_kebab, 2), new ItemStack(ItemLoader.veal), "itemKnife", "cropLettuce"));	
	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.jelly), new Object[] {"gs ", "bu ", 'g', "itemGrater", 's', "foodStrawberry", 'b', new ItemStack(Items.bowl), 'u', new ItemStack(Items.sugar)}));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.yogurt), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(Items.wheat)));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.stawberryYogurt), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(Items.wheat), "foodStrawberry"));	
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.frenchToast), "foodButter", "foodToast", "foodEgg"));
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.dough), new ItemStack(Items.wheat), new ItemStack(Items.water_bucket));
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
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.rawpasta), new ItemStack(Items.bowl), "itemKnife", "cropWheat"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.cookedpasta), "itemKnife", "foodRawPasta", "cropTomato"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), "foodMeatballs", "foodCookedPasta"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), "foodMeatballs", "itemKnife", "foodRawPasta", "cropTomato"));
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.meatballpasta), new ItemStack(Items.bowl), "foodMeatballs", "itemKnife", "itemKnife", "cropWheat", "cropTomato"));	
	//Seed Recipes
	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemLoader.tomatoSeeds, 2), "cropTomato"));
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.uselettuceSeeds, 2), new ItemStack(Items.clay_ball, 1), new ItemStack(ItemLoader.rawlettuceSeeds));
	
	//Seasonal
	if(DateUtil.isChristmas()){
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.fruitcake), Items.bread, ItemLoader.strawberry, Items.carrot, Items.apple);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.shortbread, 2), Items.sugar, Items.wheat, ItemLoader.butter);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.gingerbread, 2), Items.sugar, Items.wheat, ItemLoader.butter, Items.egg);
		GameRegistry.addSmelting(ItemLoader.peanut, new ItemStack(ItemLoader.chestnuts), 1F);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.bucketeggnog), ItemLoader.egg, Items.milk_bucket, ItemLoader.egg);
	}
	if(DateUtil.isBirthDay()){
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.ChocolateCake), Items.cake, ItemLoader.chocolate);
	}
	
	Cutting(new ItemStack(Items.fish, 1), new ItemStack(ItemLoader.fishpieces, 1));
	Cutting(new ItemStack(ItemLoader.cookedHamburger, 1), new ItemStack(ItemLoader.meatballs, 3));
	Cutting(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8));
	Cutting(new ItemStack(Items.bread, 1), new ItemStack(ItemLoader.slicedBread, 6));
	Cutting(new ItemStack(Items.porkchop, 1), new ItemStack(ItemLoader.sausage, 2));
	Cutting(new ItemStack(Items.potato, 1), new ItemStack(ItemLoader.frenchFries, 1));
	Cutting(new ItemStack(Items.beef, 1), new ItemStack(ItemLoader.rawHamburger, 1));
	Cutting(new ItemStack(Items.cooked_beef, 1), new ItemStack(ItemLoader.cookedHamburger, 1));
	
	}
	public static int totalCuts = 8;//Put the total number, subtraction is taken care of in another class
	public static void furnacing()
	{
		GameRegistry.addSmelting(ItemLoader.bacon, new ItemStack(ItemLoader.cookedBacon, 1), 0.2F);
		GameRegistry.addSmelting(ItemLoader.slicedBread, new ItemStack(ItemLoader.toast, 1), 0.1F);
		GameRegistry.addSmelting(Items.egg, new ItemStack(ItemLoader.egg), 0.1F);
		GameRegistry.addSmelting(ItemLoader.bucketseaWater, new ItemStack(ItemLoader.bucketpurifiedwater, 1), 0.5F);
		GameRegistry.addSmelting(ItemLoader.rawHamburger, new ItemStack(ItemLoader.cookedHamburger), 0.7F);
		GameRegistry.addSmelting(Items.milk_bucket, new ItemStack(ItemLoader.butterMilk), 0.9F);
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
