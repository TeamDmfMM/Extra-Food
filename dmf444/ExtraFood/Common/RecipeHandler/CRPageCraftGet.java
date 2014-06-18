package dmf444.ExtraFood.Common.RecipeHandler;


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;


public class CRPageCraftGet {


	Dictionary<String,ShapedRecipes> recipesShaped;
	Dictionary<String,ShapelessRecipes> recipesShapeless;


	public CRPageCraftGet() {
		this.recipesShaped = new Hashtable();
		this.recipesShapeless = new Hashtable();
		this.putRecipe("cheesepress", new Object[] {"ipi", "ibi", "sss", 'i', Item.ingotIron, 'p', Block.planks, 'b', Item.bucketEmpty, 's', new ItemStack(Block.stoneSingleSlab, 1, 0)}, new ItemStack(BlockLoader.cheesePress));
		//TODO place the things in here
		// TODO Auto-generated constructor stub
	}
	public ItemStack[] getArray(String itemname){
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
		else if (recipesShaped.get(itemname) != null){
			ItemStack[] items = new ItemStack[10];
			int co = 0;
			for (Object i : this.recipesShapeless.get(itemname).recipeItems.toArray()){
				ItemStack ii = (ItemStack) i;
				items[co] = ii;
				co++;
			}
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


        HashMap hashmap;


        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
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
	public void putRecipe(String itemname, ItemStack out, Object[] par2ArrayOfObj){
		ArrayList arraylist = new ArrayList();
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


		this.recipesShapeless.put(itemname, new ShapelessRecipes(out, arraylist));
	}


}
