package com.dmfmm.extrafood.crafting;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;


public class AutoCutterRegistry {

    ArrayList<RecipeAutoCutter> recipes = new ArrayList<RecipeAutoCutter>();


    public AutoCutterRegistry(){
        //this.registerRecipe(new RecipeAutoCutter(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8)));
        //this.registerRecipe(new RecipeAutoCutter(new ItemStack(Items.porkchop, 1), new ItemStack(ItemLoader.sausage, 2)));
    }
    public void registerRecipe(RecipeAutoCutter recipe){
        recipes.add(recipe);
    }

    public void registerRecipe(ItemStack input, ItemStack output){
        registerRecipe(new RecipeAutoCutter(input, output));
    }

    public ItemStack getItemOutput(ItemStack in){
        for (int i = 0; i < recipes.size(); i++){
            if (recipes.get(i).in.getItem() == in.getItem()){
                return recipes.get(i).out;
            }
        }
        return null;
    }
    @SuppressWarnings("unused")
    public Boolean isInput(ItemStack items){
        for (int i = 0; i < recipes.size(); i++){
            if (recipes.get(i).in.getItem() == items.getItem()){
                return true;
            }
            return false;
        }
        return false;
    }
    public ItemStack getItemInput(int location){
        return recipes.get(location).in;
    }
    public  int getLength(){
        return recipes.size();
    }
    public ArrayList getArray(){
        return recipes;
    }

public class RecipeAutoCutter {

    public ItemStack in;
    public ItemStack out;

    public RecipeAutoCutter(ItemStack in, ItemStack out){
        this.in = in;
        this.out = out;
    }
}

}