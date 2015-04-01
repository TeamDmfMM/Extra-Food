package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodLoader;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodRegistry;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodSpecs;
import dmf444.ExtraFood.util.EFLog;

public class OvenRegistryRecipe {
	public ArrayList<ItemStack> items;
	public String food;
	public ItemStack extra;
	
	public int time;
	
	public OvenRegistryRecipe(String foodname, int time, ArrayList<ItemStack> stacks){
		this(foodname, time, null, stacks);
	}
	
	
	
	public OvenRegistryRecipe(String foodname, int time, ItemStack pan, ArrayList<ItemStack> stacks){
		
		ArrayList<ItemStack> is = new ArrayList<ItemStack>();
		for (ItemStack istacker : stacks){
			is.add(istacker);
		}
		items = is;
		
		food = foodname;
		extra = pan;
		this.time = time;
	}
	
	public ItemStack getRecipeOutput(ArrayList<ItemStack> inventory){
		ItemStack istack = new ItemStack(NBTFoodLoader.getItem(food));
		NBTFoodSpecs specs = NBTFoodRegistry.food.getSpecs(food);
		ArrayList<String> things = new ArrayList<String>();
		boolean fine;
		for (ItemStack i : inventory){
			fine = false;
			if ( i == null){
				continue;
			}
			for (String tester : Collections.list(specs.addtypes.keys())){
				if (ok(i,specs.addtypes.get(tester))){
					//EFLog.error("Were good here cap'n");
					if (istack.stackTagCompound == null){
						istack.stackTagCompound = new NBTTagCompound();
					}
					istack.stackTagCompound.setBoolean(tester, true);
					things.add(tester);
					fine = true;
				}
				
			}
			if (fine == true){
				continue;
			}
			for (ItemStack i1 : items){
				//EFLog.error(items);
				//EFLog.error(i1);
				//EFLog.error(i);
				if (ok(i, i1)){
					//EFLog.error("yup!");
					fine=true;
				}
			}
			if (fine == true){
				continue;
			}
			//EFLog.error("nuu 180");
			return null;
		}
		if (specs.non.contains(things)){
			//EFLog.error("nuu 567");
			return null;
		}
		return istack;
		
	}
	public int getTime(ArrayList<ItemStack> inventory){
		NBTFoodSpecs specs = NBTFoodRegistry.food.getSpecs(food);
		ArrayList<String> things = new ArrayList<String>();
		boolean fine;
		for (ItemStack i : inventory){
			fine = false;
			for (String tester : Collections.list(specs.addtypes.keys())){
				if (ok(i,specs.addtypes.get(tester))){
					things.add(tester);
					fine = true;
				}
			}
			
		}
		return (time + things.size() * 15) * 20;
	}
	public boolean isRecipePossible(ArrayList<ItemStack> inventory, ItemStack pan){
		//EFLog.error("Hi");
		if (containsAll(inventory, items)){
			//EFLog.error("hello");
			if (getRecipeOutput(inventory) == null){
				//EFLog.error("nuuu 1");
				return false;
				
			}
			if (extra == null){
				return true;
			}
			if (extra != null && ok(pan, extra)){
				return true;
			}
			//EFLog.error("nuu 1.5");
			return false;
		}
		//EFLog.error("nuu 2");
		return false;
	}
	public boolean containsAll(ArrayList<ItemStack> i1, ArrayList<ItemStack> i2){
		ArrayList<ItemStack> tester = new ArrayList<ItemStack>();
		for (ItemStack is : i2){
			for (ItemStack itt : i1){
				if (ok(itt, is)){
					tester.add(is);
				}
			}
		}
		
		return tester.equals(i2);
	}
	public boolean ok(ItemStack i1, ItemStack i2){
		if (i1 != null && i2 != null){
			//EFLog.error("derp");
			if (i1.getItem() == i2.getItem()){
				//EFLog.error("derp derp");
				if (i1.getItemDamage() == i2.getItemDamage()){
					///EFLog.error("derp derp derp");
					if (i1.stackSize >= i2.stackSize){
						//EFLog.error("yaaaay");
						return true;
					}
				}
			}
		}
		if (i1 == null && i2 == null){
			return true;
		}
		return false;
	}
	
}
