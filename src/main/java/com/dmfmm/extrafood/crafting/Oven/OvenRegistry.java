package com.dmfmm.extrafood.crafting.Oven;


import com.dmfmm.extrafood.init.ItemLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class OvenRegistry {

    public static OvenRegistry instance;

    public ArrayList<OvenRegistryRecipe> recipes = new ArrayList<OvenRegistryRecipe>();

    public OvenRegistry(){
        addRecipeWithoutPan("pizza", 3, is(ItemLoader.DOUGH, 1), is(ItemLoader.TOMATO, 2));
        addRecipe("muffin", 3, is(ItemLoader.MUFFIN_PAN, 1), is(ItemLoader.DOUGH, 1));
    }

    public void addRecipeWithoutPan(String foodname, int time, ItemStack... st){
        addRecipe(foodname, time, null, st);
    }

    public void addRecipe(String foodname, int time, ItemStack pan, ItemStack... st){
        ArrayList<ItemStack> is = new ArrayList<ItemStack>();
        for (ItemStack istacker : st){
            is.add(istacker);
        }

        OvenRegistryRecipe recipe = new OvenRegistryRecipe(foodname, time, pan, is);
        recipes.add(recipe);
    }
    public ItemStack is(Item i, int amount){
        return new ItemStack(i, amount);
    }
    public boolean ok(ItemStack[] items){
        ArrayList<ItemStack> twit = new ArrayList<ItemStack>();
        int i = 0;
        for (ItemStack thingy : items){
            if (i == 4){
                break;
            }
            twit.add(thingy);
            i++;
        }
        ItemStack pan = items[4];
        for (OvenRegistryRecipe recipe : recipes){
            if (recipe.isRecipePossible(twit, pan)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<ItemStack> getArrayList(ItemStack[] items){
        ArrayList<ItemStack> twit = new ArrayList<ItemStack>();
        int i = 0;
        for (ItemStack thingy : items){
            if (i == 4){
                break;
            }
            twit.add(thingy);
            i++;
        }
        return twit;
    }

    public OvenRegistryRecipe getRecipe(ItemStack[] items){
        ArrayList<ItemStack> twit = new ArrayList<ItemStack>();
        int i = 0;
        for (ItemStack thingy : items){
            if (i == 4){
                break;
            }
            twit.add(thingy);
            i++;
        }
        ItemStack pan = items[4];
        for (OvenRegistryRecipe recipe : recipes){
            if (recipe.isRecipePossible(twit, pan)){
                return recipe;
            }
        }
        return null;
    }

}