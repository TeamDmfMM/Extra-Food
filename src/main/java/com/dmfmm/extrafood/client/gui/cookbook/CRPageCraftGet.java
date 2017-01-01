package com.dmfmm.extrafood.client.gui.cookbook;


import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.items.nbt.NBTFoodLoader;
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
        this.putRecipe("cheeseslice", new Object[] {"ik ", "   ", "   ", 'i', ItemLoader.CHEESE_WHEEL, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.CHEESE_SLICE, 8));
        this.putRecipe("sausage", new Object[] {"ik ", "   ", "   ", 'i', Items.PORKCHOP, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.SAUSAGE, 2));
        this.putRecipe("Bread", new Object[] {"ik ", "   ", "   ", 'i', Items.BREAD, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.SLICED_BREAD, 6));
        this.putRecipe("frenchFries", new Object[] {"ik ", "   ", "   ", 'i', Items.POTATO, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.FRENCH_FRIES, 1));
        this.putRecipe("BugerRaw", new Object[] {"ik ", "   ", "   ", 'i', Items.BEEF, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.RAW_HAMBURGER, 1));
        this.putRecipe("BurgerCooked", new Object[] {"ik ", "   ", "   ", 'i', Items.COOKED_BEEF, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.COOKED_HAMBURGER, 1));
        this.putRecipe("Fishpieces", new Object[] {"ik ", "   ", "   ", 'i', Items.FISH, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.FISH_PIECES, 1));
        this.putRecipe("meatballs", new Object[] {"ik ", "   ", "   ", 'i', ItemLoader.COOKED_HAMBURGER, 'k',  ItemLoader.KNIFE}, new ItemStack(ItemLoader.MEATBALLS, 3));

        this.putRecipe("cheesepress", new Object[] {"ipi", "ibi", "sss" , 'i', new ItemStack(Items.IRON_INGOT), 'p', new ItemStack(Blocks.PLANKS, 1, 0), 'b', Items.BUCKET, 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)}, new ItemStack(BlockLoader.CHEESE_PRESS, 1));
        this.putRecipe("autoCutter", new Object[] {"pki", "psp", "p p" , 'p', new ItemStack(Blocks.PLANKS, 1, 0), 'k', ItemLoader.KNIFE, 'i', new ItemStack(Items.IRON_INGOT), 's', new ItemStack(Blocks.WOODEN_SLAB, 1, 0)}, new ItemStack(BlockLoader.AUTO_CUTTER, 1));
        this.putRecipe("juiceBlender", new Object[] {"sss", " ws", "sss" , 's', new ItemStack(Blocks.STONE_SLAB, 1, 0), 'w', new ItemStack(Blocks.PLANKS, 1, 0)}, new ItemStack(BlockLoader.JUICE_BLENDER, 1));
        this.putRecipe("oven", new Object[] {"iii", "irg", "sss", 'i', new ItemStack(Blocks.IRON_BLOCK), 'r', new ItemStack(Blocks.IRON_BARS), 'g', new ItemStack(Blocks.GLASS_PANE), 's', new ItemStack(Blocks.STONE_SLAB, 1, 0)}, new ItemStack(BlockLoader.OVEN, 1));
		/*
		this.putRecipe("cookBook0", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.apple}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook1", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.PORKCHOP}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook2", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.BEEF}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook3", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.carrot}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook4", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.POTATO}, new ItemStack(ItemLoader.cookBook, 1));
		this.putRecipe("cookBook5", new Object[] {" b ", " l ", " f " , 'b', Items.book, 'l', Items.leather, 'f', Items.FISH}, new ItemStack(ItemLoader.cookBook, 1));
		*/
        this.putRecipe("whiteout", new Object[] {"www", "www", "www" , 'w', new ItemStack(Items.DYE, 1, 15)}, new ItemStack(BlockLoader.WHITEOUT));
        this.putRecipe("vanillaIceCream", new Object[] {" i ", "bm ", " s " , 'i', new ItemStack(Blocks.ICE), 'b', new ItemStack(Items.DYE, 1, 15), 'm', Items.MILK_BUCKET, 's', new ItemStack(ItemLoader.SLICED_BREAD)}, new ItemStack(ItemLoader.VANILLA_ICE_CREAM));
        this.putRecipe("chocolateIceCream", new Object[] {" i ", "cm ", " s " , 'i', new ItemStack(Blocks.ICE), 'c', new ItemStack(ItemLoader.CHOCOLATE), 'm', Items.MILK_BUCKET, 's', new ItemStack(ItemLoader.SLICED_BREAD)}, new ItemStack(ItemLoader.CHOCOLATE_ICE_CREAM));
        this.putRecipe("strawberryIceCream", new Object[] {" i ", "tm ", " s " , 'i', new ItemStack(Blocks.ICE), 't', new ItemStack(ItemLoader.STRAWBERRY), 'm', Items.MILK_BUCKET, 's', new ItemStack(ItemLoader.SLICED_BREAD)}, new ItemStack(ItemLoader.STRAWBERRY_ICE_CREAM));
        this.putRecipe("icePop", new Object[] {" i ", " s " , 'i', new ItemStack(Blocks.ICE), 's', new ItemStack(Items.STICK)}, new ItemStack(ItemLoader.ICE_POP));
        this.putRecipe("neoIceCream", new Object[] {"vcs", " b " , 'v', new ItemStack(ItemLoader.VANILLA_ICE_CREAM), 'c', new ItemStack(ItemLoader.CHOCOLATE_ICE_CREAM), 's', new ItemStack(ItemLoader.STRAWBERRY_ICE_CREAM), 'b', Items.BOWL}, new ItemStack(ItemLoader.NEOPOLITAN_ICE_CREAM));
        this.putRecipe("chocolateSpread", new Object[] {"gc ", "sb " , 'g', new ItemStack(ItemLoader.GRATER), 'c', new ItemStack(ItemLoader.CHOCOLATE), 's', Items.BOWL, 'b', new ItemStack(ItemLoader.BUTTER)}, new ItemStack(ItemLoader.CHOCOLATE_SPREAD));
        this.putRecipe("butter", new ItemStack(ItemLoader.BUTTER), new ItemStack(ItemLoader.BUTTER_MILK.setContainerItem(Items.BUCKET)));
        this.putRecipe("grater", new Object[] {"ii ", "ii ", "ss " , 'i', new ItemStack(Items.IRON_INGOT), 's', new ItemStack(Items.STICK)}, new ItemStack(ItemLoader.GRATER));
        this.putRecipe("pancakes", new Object[] {"ws ", "bm " , 'w', Items.WHEAT, 's', Items.SUGAR, 'b', new ItemStack(ItemLoader.BUTTER), 'm', Items.MILK_BUCKET}, new ItemStack(ItemLoader.PANCAKES, 2));
        this.putRecipe("peanutButter", new ItemStack(ItemLoader.PEANUT_BUTTER, 1),  new ItemStack(ItemLoader.GRATER), new ItemStack(ItemLoader.PEANUT), new ItemStack (Items.BOWL, 1), new ItemStack(ItemLoader.BUTTER));
        this.putRecipe("grater1", new Object[] {"ss ", "ii ", "ii " , 's', new ItemStack(Items.STICK), 'i', new ItemStack(Items.IRON_INGOT)}, new ItemStack(ItemLoader.GRATER, 1));
        this.putRecipe("KNIFE", new Object[] {"ii ", "ii ", " j " , 'i', new ItemStack(Items.IRON_INGOT), 'j', new ItemStack(Items.STICK)}, new ItemStack(ItemLoader.KNIFE, 1));
        this.putRecipe("sushi", new ItemStack(ItemLoader.SUSHI),  new ItemStack(Blocks.TALLGRASS, 1, 1), new ItemStack(ItemLoader.FISH_PIECES));
        this.putRecipe("chineseFood", new ItemStack(ItemLoader.CHINESE_FOOD),  new ItemStack(ItemLoader.SUSHI), new ItemStack(ItemLoader.RAW_PASTA), new ItemStack(Items.PAPER));
        this.putRecipe("chocolate", new Object[] {" s ", " m ", " c " , 's', new ItemStack(Items.SUGAR), 'm', new ItemStack(Items.MILK_BUCKET), 'c', new ItemStack(Items.DYE, 1, 3)}, new ItemStack(ItemLoader.CHOCOLATE));
        this.putRecipe("pork_kebab", new ItemStack(ItemLoader.PORK_KEBAB, 2),  new ItemStack(Items.COOKED_PORKCHOP), new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.LETTUCE));
        this.putRecipe("steak_kebab", new ItemStack(ItemLoader.STEAK_KEBAB, 2),  new ItemStack(Items.COOKED_BEEF), new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.LETTUCE));
        this.putRecipe("veal_kebab", new ItemStack(ItemLoader.VEAL_KEBAB, 2),  new ItemStack(ItemLoader.VEAL), new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.LETTUCE));
        this.putRecipe("jelly", new Object[] {"gs ", "bu " , 'g', new ItemStack(ItemLoader.GRATER), 's', new ItemStack(ItemLoader.STRAWBERRY), 'b', new ItemStack(Items.BOWL), 'u', new ItemStack(Items.SUGAR)}, new ItemStack(ItemLoader.JELLY));
        this.putRecipe("yogurt", new ItemStack(ItemLoader.YOGURT),  new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT));
        this.putRecipe("stawberryYogurt", new ItemStack(ItemLoader.STRAWBERRY_YOGURT),  new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(Items.WHEAT), new ItemStack(ItemLoader.STRAWBERRY));
        this.putRecipe("frenchToast", new ItemStack(ItemLoader.FRENCH_TOAST),  new ItemStack(ItemLoader.BUTTER), new ItemStack(ItemLoader.TOAST), new ItemStack(ItemLoader.EGG));
        this.putRecipe("sandwichPBN", new Object[] {" t ", " cp", " t " , 't', new ItemStack(ItemLoader.TOAST), 'c', new ItemStack(ItemLoader.CHOCOLATE_SPREAD), 'p', new ItemStack(ItemLoader.PEANUT_BUTTER)}, new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER_CHOCOLATE));
        this.putRecipe("sandwichBLT", new Object[] {" t ", "blo", " t " , 't', new ItemStack(ItemLoader.TOAST), 'b', new ItemStack(ItemLoader.COOKED_BACON), 'l', new ItemStack(ItemLoader.LETTUCE), 'o', new ItemStack(ItemLoader.TOMATO)}, new ItemStack(ItemLoader.SANDWICH_BLT));
        this.putRecipe("sandwhichHamburger", new Object[] {" i ", " h ", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 'h', new ItemStack(ItemLoader.COOKED_HAMBURGER)}, new ItemStack(ItemLoader.SANDWICH_HAMBURGER));
        this.putRecipe("sandwhichGC", new Object[] {" i ", " c ", " i " , 'i', new ItemStack(ItemLoader.TOAST), 'c', new ItemStack(ItemLoader.CHEESE_SLICE)}, new ItemStack(ItemLoader.SANDWICH_GRILLED_CHEESE));
        this.putRecipe("sandwhichS", new Object[] {" i ", " s ", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 's', new ItemStack(ItemLoader.SAUSAGE)}, new ItemStack(ItemLoader.SANDWICH_SAUSAGE));
        this.putRecipe("sandwhichCB", new Object[] {" i ", " bc", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 'b', new ItemStack(ItemLoader.COOKED_BACON), 'c', new ItemStack(ItemLoader.CHEESE_SLICE)}, new ItemStack(ItemLoader.SANDWICH_BACON_CHEESE));
        this.putRecipe("sandwichC", new Object[] {" i ", " c ", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 'c', new ItemStack(ItemLoader.CHOCOLATE_SPREAD)}, new ItemStack(ItemLoader.SANDWICH_CHOCOLATE));
        this.putRecipe("sandwichPB", new Object[] {" i ", " p ", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 'p', new ItemStack(ItemLoader.PEANUT_BUTTER)}, new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER));
        this.putRecipe("sandwichPBJ", new Object[] {" i ", " pj", " i " , 'i', new ItemStack(ItemLoader.SLICED_BREAD), 'p', new ItemStack(ItemLoader.PEANUT_BUTTER), 'j', new ItemStack(ItemLoader.JELLY)}, new ItemStack(ItemLoader.SANDWICH_PEANUTBUTTER_JAM));
        this.putRecipe("sandwichCheeseburger", new Object[] {"ch " , 'c', new ItemStack(ItemLoader.CHEESE_SLICE), 'h', new ItemStack(ItemLoader.SANDWICH_HAMBURGER)}, new ItemStack(ItemLoader.SANDWICH_CHEESEBURGER));
        this.putRecipe("sandwichCheeseburger1", new Object[] {" t ", "ch ", " t " , 't', new ItemStack(ItemLoader.SLICED_BREAD), 'c', new ItemStack(ItemLoader.CHEESE_SLICE), 'h', new ItemStack(ItemLoader.COOKED_HAMBURGER)}, new ItemStack(ItemLoader.SANDWICH_CHEESEBURGER));
        this.putRecipe("sandwichSupremeBurger", new ItemStack(ItemLoader.SANDWICH_SUPREME_BURGER),  new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.LETTUCE), new ItemStack(ItemLoader.TOMATO), new ItemStack(ItemLoader.SANDWICH_CHEESEBURGER));
        this.putRecipe("rawpasta", new ItemStack(ItemLoader.RAW_PASTA),  new ItemStack(Items.BOWL), new ItemStack(ItemLoader.KNIFE), new ItemStack(Items.WHEAT));
        this.putRecipe("cookedpasta", new ItemStack(ItemLoader.COOKED_PASTA),  new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.RAW_PASTA), new ItemStack(ItemLoader.TOMATO));
        this.putRecipe("meatballpasta1", new ItemStack(ItemLoader.MEATBALL_PASTA),  new ItemStack(ItemLoader.MEATBALLS), new ItemStack(ItemLoader.COOKED_PASTA));
        this.putRecipe("meatballpasta2", new ItemStack(ItemLoader.MEATBALL_PASTA),  new ItemStack(ItemLoader.MEATBALLS), new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.RAW_PASTA), new ItemStack(ItemLoader.TOMATO));
        this.putRecipe("meatballpasta3", new ItemStack(ItemLoader.MEATBALL_PASTA),  new ItemStack(Items.BOWL), new ItemStack(ItemLoader.MEATBALLS), new ItemStack(ItemLoader.KNIFE), new ItemStack(ItemLoader.KNIFE), new ItemStack(Items.WHEAT), new ItemStack(ItemLoader.TOMATO));
        this.putRecipe("tomatoSeeds", new ItemStack(ItemLoader.TOMATO_SEEDS, 2),  new ItemStack(ItemLoader.TOMATO));
        this.putRecipe("uselettuceSeeds", new Object[] {"cs", 'c', new ItemStack(Items.CLAY_BALL, 1), 's', new ItemStack(ItemLoader.RAW_LETTUCE_SEEDS)}, new ItemStack(ItemLoader.LETTUCE_SEEDS, 2));

        this.putRecipe("CookedBacon", new ItemStack(ItemLoader.COOKED_BACON), new ItemStack(ItemLoader.BACON));
        this.putRecipe("toast", new ItemStack(ItemLoader.TOAST), new ItemStack(ItemLoader.SLICED_BREAD));
        this.putRecipe("egg", new ItemStack(ItemLoader.EGG), new ItemStack(Items.EGG));
        this.putRecipe("pureH2O", new ItemStack(ItemLoader.BUCKET_PURIFIED_WATER), new ItemStack(ItemLoader.BUCKET_SEA_WATER));
        this.putRecipe("cookedHamburger", new ItemStack(ItemLoader.COOKED_HAMBURGER), new ItemStack(ItemLoader.RAW_HAMBURGER));
        this.putRecipe("butterMilk", new ItemStack(ItemLoader.BUTTER_MILK), new ItemStack(Items.MILK_BUCKET));
        this.putRecipe("dough", new ItemStack(ItemLoader.DOUGH), new ItemStack(Items.WHEAT), new ItemStack(Items.WATER_BUCKET));

        //Oven Ones - Blocks.Carrots is removed in rendering
        this.putRecipe("muffin",new ItemStack(NBTFoodLoader.getItem("muffin")), new ItemStack(ItemLoader.DOUGH), new ItemStack(Blocks.CARROTS), new ItemStack(ItemLoader.MUFFIN_PAN), new ItemStack(ItemLoader.CHOCOLATE), new ItemStack(ItemLoader.STRAWBERRY), new ItemStack(ItemLoader.BANANA), new ItemStack(Items.APPLE), new ItemStack(ItemLoader.CHOCOLATE, 2), new ItemStack(Blocks.CARROTS));
        this.putRecipe("pizza", new ItemStack(NBTFoodLoader.getItem("pizza")), new ItemStack(ItemLoader.DOUGH), new ItemStack(ItemLoader.TOMATO, 2), new ItemStack(Blocks.CARROTS), new ItemStack(ItemLoader.SAUSAGE), new ItemStack(Items.COOKED_FISH), new ItemStack(ItemLoader.CHEESE_SLICE, 2), new ItemStack(ItemLoader.OLIVE, 3), new ItemStack(Blocks.CARROTS), new ItemStack(Blocks.CARROTS));
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