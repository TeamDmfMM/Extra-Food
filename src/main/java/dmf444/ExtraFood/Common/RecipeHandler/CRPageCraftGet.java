package dmf444.ExtraFood.Common.RecipeHandler;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;


public class CRPageCraftGet {


	Dictionary<String,ShapedRecipes> recipesShaped;
	Dictionary<String,ShapelessRecipes> recipesShapeless;


	public CRPageCraftGet() {
		this.recipesShaped = new Hashtable<String, ShapedRecipes>();
		this.recipesShapeless = new Hashtable<String, ShapelessRecipes>();
		this.putRecipe("cheeseslice", new Object[] {"ik ", "   ", "   ", 'i', ItemLoader.cheeseWheel, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.cheeseSlice, 8));
		this.putRecipe("sausage", new Object[] {"ik ", "   ", "   ", 'i', Items.porkchop, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.sausage, 2));
		this.putRecipe("Bread", new Object[] {"ik ", "   ", "   ", 'i', Items.bread, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.slicedBread, 6));
		this.putRecipe("frenchFries", new Object[] {"ik ", "   ", "   ", 'i', Items.potato, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.frenchFries, 1));
		this.putRecipe("BugerRaw", new Object[] {"ik ", "   ", "   ", 'i', Items.beef, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.rawHamburger, 1));
		this.putRecipe("BurgerCooked", new Object[] {"ik ", "   ", "   ", 'i', Items.cooked_beef, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.cookedHamburger, 1));
		this.putRecipe("Fishpieces", new Object[] {"ik ", "   ", "   ", 'i', Items.fish, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.fishpieces, 1));
		this.putRecipe("meatballs", new Object[] {"ik ", "   ", "   ", 'i', ItemLoader.cookedHamburger, 'k',  ItemLoader.knife}, new ItemStack(ItemLoader.meatballs, 3));
		
		this.putRecipe("cheesepress", new Object[] {"ipi", "ibi", "sss" , 'i', new ItemStack(Items.iron_ingot), 'p', new ItemStack(Blocks.planks, 1, 0), 'b', Items.bucket, 's', new ItemStack(Blocks.stone_slab, 1, 0)}, new ItemStack(BlockLoader.cheesePress, 1));
		this.putRecipe("autoCutter", new Object[] {"pki", "psp", "p p" , 'p', new ItemStack(Blocks.planks, 1, 0), 'k', ItemLoader.knife, 'i', new ItemStack(Items.iron_ingot), 's', new ItemStack(Blocks.wooden_slab, 1, 0)}, new ItemStack(BlockLoader.autoCutter, 1));
		this.putRecipe("juiceBlender", new Object[] {"sss", " ws", "sss" , 's', new ItemStack(Blocks.stone_slab, 1, 0), 'w', new ItemStack(Blocks.planks, 1, 0)}, new ItemStack(BlockLoader.juiceBlender, 1));
		this.putRecipe("oven", new Object[] {"iii", "irg", "sss", 'i', new ItemStack(Blocks.iron_block), 'r', new ItemStack(Blocks.iron_bars), 'g', new ItemStack(Blocks.glass_pane), 's', new ItemStack(Blocks.stone_slab, 1, 0)}, new ItemStack(BlockLoader.oven, 1));
		/*
		this.putRecipe("cookBook0", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.apple}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook1", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.porkchop}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook2", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.beef}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook3", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.carrot}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook4", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.potato}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook5", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.fish}, new ItemStack(ItemLoader.cookBook, 1));
		*/
		this.putRecipe("whiteout", new Object[] {"www", "www", "www" , 'w', new ItemStack(Items.dye, 1, 15)}, new ItemStack(BlockLoader.whiteout));
		this.putRecipe("vanillaIceCream", new Object[] {" i ", "bm ", " s " , 'i', Blocks.ice, 'b', new ItemStack(Items.dye, 1, 15), 'm', Items.milk_bucket, 's', new ItemStack(ItemLoader.slicedBread)}, new ItemStack(ItemLoader.vanillaIceCream));
		this.putRecipe("chocolateIceCream", new Object[] {" i ", "cm ", " s " , 'i', Blocks.ice, 'c', new ItemStack(ItemLoader.chocolate), 'm', Items.milk_bucket, 's', new ItemStack(ItemLoader.slicedBread)}, new ItemStack(ItemLoader.chocolateIceCream));
		this.putRecipe("strawberryIceCream", new Object[] {" i ", "tm ", " s " , 'i', Blocks.ice, 't', new ItemStack(ItemLoader.strawberry), 'm', Items.milk_bucket, 's', new ItemStack(ItemLoader.slicedBread)}, new ItemStack(ItemLoader.strawberryIceCream));
		this.putRecipe("icePop", new Object[] {" i ", " s " , 'i', Blocks.ice, 's', new ItemStack(Items.stick)}, new ItemStack(ItemLoader.icePop));
		this.putRecipe("neoIceCream", new Object[] {"vcs", " b " , 'v', new ItemStack(ItemLoader.vanillaIceCream), 'c', new ItemStack(ItemLoader.chocolateIceCream), 's', new ItemStack(ItemLoader.strawberryIceCream), 'b', Items.bowl}, new ItemStack(ItemLoader.neoIceCream));
		this.putRecipe("chocolateSpread", new Object[] {"gc ", "sb " , 'g', new ItemStack(ItemLoader.grater), 'c', new ItemStack(ItemLoader.chocolate), 's', Items.bowl, 'b', new ItemStack(ItemLoader.butter)}, new ItemStack(ItemLoader.chocolateSpread));
		this.putRecipe("butter", new ItemStack(ItemLoader.butter), new ItemStack(ItemLoader.butterMilk.setContainerItem(Items.bucket)));
		this.putRecipe("grater", new Object[] {"ii ", "ii ", "ss " , 'i', new ItemStack(Items.iron_ingot), 's', new ItemStack(Items.stick)}, new ItemStack(ItemLoader.grater));
		this.putRecipe("pancakes", new Object[] {"ws ", "bm " , 'w', Items.wheat, 's', Items.sugar, 'b', new ItemStack(ItemLoader.butter), 'm', Items.milk_bucket}, new ItemStack(ItemLoader.pancakes, 2));
		this.putRecipe("peanutButter", new ItemStack(ItemLoader.peanutButter, 1),  new ItemStack(ItemLoader.grater), new ItemStack(ItemLoader.peanut), new ItemStack (Items.bowl, 1), new ItemStack(ItemLoader.butter));
		this.putRecipe("grater1", new Object[] {"ss ", "ii ", "ii " , 's', new ItemStack(Items.stick), 'i', new ItemStack(Items.iron_ingot)}, new ItemStack(ItemLoader.grater, 1));
		this.putRecipe("knife", new Object[] {"ii ", "ii ", " j " , 'i', new ItemStack(Items.iron_ingot), 'j', new ItemStack(Items.stick)}, new ItemStack(ItemLoader.knife, 1));
		this.putRecipe("sushi", new ItemStack(ItemLoader.sushi),  new ItemStack(Blocks.tallgrass, 1, 1), new ItemStack(ItemLoader.fishpieces));
		this.putRecipe("chineseFood", new ItemStack(ItemLoader.chineseFood),  new ItemStack(ItemLoader.sushi), new ItemStack(ItemLoader.rawpasta), new ItemStack(Items.paper));
		this.putRecipe("chocolate", new Object[] {" s ", " m ", " c " , 's', new ItemStack(Items.sugar), 'm', new ItemStack(Items.milk_bucket), 'c', new ItemStack(Items.dye, 1, 3)}, new ItemStack(ItemLoader.chocolate));
		this.putRecipe("pork_kebab", new ItemStack(ItemLoader.pork_kebab, 2),  new ItemStack(Items.cooked_porkchop), new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.lettuce));
		this.putRecipe("steak_kebab", new ItemStack(ItemLoader.steak_kebab, 2),  new ItemStack(Items.cooked_beef), new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.lettuce));
		this.putRecipe("veal_kebab", new ItemStack(ItemLoader.veal_kebab, 2),  new ItemStack(ItemLoader.veal), new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.lettuce));	
		this.putRecipe("jelly", new Object[] {"gs ", "bu " , 'g', new ItemStack(ItemLoader.grater), 's', new ItemStack(ItemLoader.strawberry), 'b', new ItemStack(Items.bowl), 'u', new ItemStack(Items.sugar)}, new ItemStack(ItemLoader.jelly));
		this.putRecipe("yogurt", new ItemStack(ItemLoader.yogurt),  new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(Items.wheat));
		this.putRecipe("stawberryYogurt", new ItemStack(ItemLoader.stawberryYogurt),  new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(Items.wheat), new ItemStack(ItemLoader.strawberry));	
		this.putRecipe("frenchToast", new ItemStack(ItemLoader.frenchToast),  new ItemStack(ItemLoader.butter), new ItemStack(ItemLoader.toast), new ItemStack(ItemLoader.egg));
		this.putRecipe("sandwichPBN", new Object[] {" t ", " cp", " t " , 't', new ItemStack(ItemLoader.toast), 'c', new ItemStack(ItemLoader.chocolateSpread), 'p', new ItemStack(ItemLoader.peanutButter)}, new ItemStack(ItemLoader.sandwichPBN));
		this.putRecipe("sandwichBLT", new Object[] {" t ", "blo", " t " , 't', new ItemStack(ItemLoader.toast), 'b', new ItemStack(ItemLoader.cookedBacon), 'l', new ItemStack(ItemLoader.lettuce), 'o', new ItemStack(ItemLoader.tomato)}, new ItemStack(ItemLoader.sandwichBLT));
		this.putRecipe("sandwhichHamburger", new Object[] {" i ", " h ", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 'h', new ItemStack(ItemLoader.cookedHamburger)}, new ItemStack(ItemLoader.sandwhichHamburger));
		this.putRecipe("sandwhichGC", new Object[] {" i ", " c ", " i " , 'i', new ItemStack(ItemLoader.toast), 'c', new ItemStack(ItemLoader.cheeseSlice)}, new ItemStack(ItemLoader.sandwhichGC));
		this.putRecipe("sandwhichS", new Object[] {" i ", " s ", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 's', new ItemStack(ItemLoader.sausage)}, new ItemStack(ItemLoader.sandwhichS));
		this.putRecipe("sandwhichCB", new Object[] {" i ", " bc", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 'b', new ItemStack(ItemLoader.cookedBacon), 'c', new ItemStack(ItemLoader.cheeseSlice)}, new ItemStack(ItemLoader.sandwhichCB));
		this.putRecipe("sandwichC", new Object[] {" i ", " c ", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 'c', new ItemStack(ItemLoader.chocolateSpread)}, new ItemStack(ItemLoader.sandwichC));
		this.putRecipe("sandwichPB", new Object[] {" i ", " p ", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 'p', new ItemStack(ItemLoader.peanutButter)}, new ItemStack(ItemLoader.sandwichPB));
		this.putRecipe("sandwichPBJ", new Object[] {" i ", " pj", " i " , 'i', new ItemStack(ItemLoader.slicedBread), 'p', new ItemStack(ItemLoader.peanutButter), 'j', new ItemStack(ItemLoader.jelly)}, new ItemStack(ItemLoader.sandwichPBJ));
		this.putRecipe("sandwichCheeseburger", new Object[] {"ch " , 'c', new ItemStack(ItemLoader.cheeseSlice), 'h', new ItemStack(ItemLoader.sandwhichHamburger)}, new ItemStack(ItemLoader.sandwichCheeseburger));
		this.putRecipe("sandwichCheeseburger1", new Object[] {" t ", "ch ", " t " , 't', new ItemStack(ItemLoader.slicedBread), 'c', new ItemStack(ItemLoader.cheeseSlice), 'h', new ItemStack(ItemLoader.cookedHamburger)}, new ItemStack(ItemLoader.sandwichCheeseburger));
		this.putRecipe("sandwichSupremeBurger", new ItemStack(ItemLoader.sandwichSupremeBurger),  new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.lettuce), new ItemStack(ItemLoader.tomato), new ItemStack(ItemLoader.sandwichCheeseburger));
		this.putRecipe("rawpasta", new ItemStack(ItemLoader.rawpasta),  new ItemStack(Items.bowl), new ItemStack(ItemLoader.knife), new ItemStack(Items.wheat));
		this.putRecipe("cookedpasta", new ItemStack(ItemLoader.cookedpasta),  new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.rawpasta), new ItemStack(ItemLoader.tomato));
		this.putRecipe("meatballpasta1", new ItemStack(ItemLoader.meatballpasta),  new ItemStack(ItemLoader.meatballs), new ItemStack(ItemLoader.cookedpasta));
		this.putRecipe("meatballpasta2", new ItemStack(ItemLoader.meatballpasta),  new ItemStack(ItemLoader.meatballs), new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.rawpasta), new ItemStack(ItemLoader.tomato));
		this.putRecipe("meatballpasta3", new ItemStack(ItemLoader.meatballpasta),  new ItemStack(Items.bowl), new ItemStack(ItemLoader.meatballs), new ItemStack(ItemLoader.knife), new ItemStack(ItemLoader.knife), new ItemStack(Items.wheat), new ItemStack(ItemLoader.tomato));	
		this.putRecipe("tomatoSeeds", new ItemStack(ItemLoader.tomatoSeeds, 2),  new ItemStack(ItemLoader.tomato));
		this.putRecipe("uselettuceSeeds", new Object[] {"cs", 'c', new ItemStack(Items.clay_ball, 1), 's', new ItemStack(ItemLoader.rawlettuceSeeds)}, new ItemStack(ItemLoader.uselettuceSeeds, 2));
		
		this.putRecipe("CookedBacon", new ItemStack(ItemLoader.cookedBacon), new ItemStack(ItemLoader.bacon));
		this.putRecipe("toast", new ItemStack(ItemLoader.toast), new ItemStack(ItemLoader.slicedBread));
		this.putRecipe("egg", new ItemStack(ItemLoader.egg), new ItemStack(Items.egg));
		this.putRecipe("pureH2O", new ItemStack(ItemLoader.bucketpurifiedwater), new ItemStack(ItemLoader.bucketseaWater));
		this.putRecipe("cookedHamburger", new ItemStack(ItemLoader.cookedHamburger), new ItemStack(ItemLoader.rawHamburger));
		this.putRecipe("butterMilk", new ItemStack(ItemLoader.butterMilk), new ItemStack(Items.milk_bucket));
        this.putRecipe("dough", new ItemStack(ItemLoader.dough), new ItemStack(Items.wheat), new ItemStack(Items.water_bucket));

        //Oven Ones - Blocks.Carrots is removed in rendering
        this.putRecipe("muffin",new ItemStack(NBTFoodLoader.getItem("muffin")), new ItemStack(ItemLoader.dough), new ItemStack(Blocks.carrots), new ItemStack(ItemLoader.muffinPan), new ItemStack(ItemLoader.chocolate), new ItemStack(ItemLoader.strawberry), new ItemStack(ItemLoader.banana), new ItemStack(Items.apple), new ItemStack(ItemLoader.chocolate, 2), new ItemStack(Blocks.carrots));
        this.putRecipe("pizza", new ItemStack(NBTFoodLoader.getItem("pizza")), new ItemStack(ItemLoader.dough), new ItemStack(ItemLoader.tomato, 2), new ItemStack(Blocks.carrots), new ItemStack(ItemLoader.sausage), new ItemStack(Items.cooked_fished), new ItemStack(ItemLoader.cheeseSlice, 2), new ItemStack(ItemLoader.peanut, 3), new ItemStack(Blocks.carrots), new ItemStack(Blocks.carrots));
		//TODO place the things in here
	}
	public ItemStack[] getArray(String itemname){
		itemname = itemname.trim();
		if (recipesShaped.get(itemname) != null){
			ItemStack[] items = new ItemStack[10];
			int co = 0;
			for (ItemStack i : this.recipesShaped.get(itemname).recipeItems){
				items[co] = i;
				co++;
			}
			items[9] = this.recipesShaped.get(itemname).getRecipeOutput();
			return items;
		}
		else if (recipesShapeless.get(itemname) != null){
			ItemStack[] items = new ItemStack[10];
			int co = 0;
			for (Object i : this.recipesShapeless.get(itemname).recipeItems.toArray()){
				ItemStack ii = (ItemStack) i;
				items[co] = ii;
				co++;
			}
			items[9] = this.recipesShapeless.get(itemname).getRecipeOutput();
			return items;
		}
		else {
			return null;
		}
	}
	public void putRecipe(String itemname, Object[] par2ArrayOfObj, ItemStack out){
		String s = "";
        int i = 0;
        int j = 0;
        int k = 0;


        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);


            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }


        HashMap<Character, ItemStack> hashmap;


        for (hashmap = new HashMap<Character, ItemStack>(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;


            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }


            hashmap.put(character, itemstack1);
        }


        ItemStack[] aitemstack = new ItemStack[j * k];


        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);


            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }


        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, out);
        
		this.recipesShaped.put(itemname, shapedrecipes);


	}
	public void putRecipe(String itemname, ItemStack out, ItemStack... par2ArrayOfObj){
		ArrayList<ItemStack> arraylist = new ArrayList<ItemStack>();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;


        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];


            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }


                arraylist.add(new ItemStack((Block)object1));
            }
        }

        ShapelessRecipes shaplessR = new ShapelessRecipes(out, arraylist);
		this.recipesShapeless.put(itemname, shaplessR);
	}

	

}
