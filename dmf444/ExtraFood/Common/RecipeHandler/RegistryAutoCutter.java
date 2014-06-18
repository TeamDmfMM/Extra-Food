package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class RegistryAutoCutter {
	ArrayList<RecipeAutoCutter> recipes = new ArrayList<RecipeAutoCutter>();


	public RegistryAutoCutter(){
		this.registerRecipe(new RecipeAutoCutter(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8)));
	}
	public void registerRecipe(RecipeAutoCutter recipe){
		recipes.add(recipe);
	}
	public ItemStack getItemOutput(ItemStack in){
		for (int i = 0; i < recipes.size(); i++){
			if (recipes.get(i).in.itemID == in.itemID){
				return recipes.get(i).out;
			}
		}
		return null;
	}


}
