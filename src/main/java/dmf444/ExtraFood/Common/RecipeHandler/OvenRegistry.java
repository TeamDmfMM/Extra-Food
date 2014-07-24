package dmf444.ExtraFood.Common.RecipeHandler;


import java.util.ArrayList;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * @author mincramatt12
 *
 * 7/16/14, Written
 *
 *
 *
 *
 */
public class OvenRegistry {
	ArrayList<OvenRegistryItem> ovenitems = new ArrayList<OvenRegistryItem>();
	public OvenRegistry(){


	}
	public ItemStack getItem(ArrayList<ItemStack> itemsinoven){
		for (OvenRegistryItem i : ovenitems){
			if (this.containsAllItemsIgnoreExcess(itemsinoven, i.baseRecipe)){
				if (this.checkIfItemsAreEqualIngoreMissing(itemsinoven, i.getItemsAdditive())){
					return i.createItemStack(itemsinoven);


				}
			}
		}
		return null;
	}
	public boolean containsAllItemsIgnoreExcess(ArrayList<ItemStack> i1, ArrayList<ItemStack> i2){
		boolean truth = false;
		for (ItemStack it : i2){
			for (ItemStack itt : i1){
				if (itt == it){
					truth = true;
				}
			if (truth == false){
				return false;
			}
			else {
				truth = false;
			}
			}
		}
		return true;
	}
	public boolean checkIfItemsAreEqualIngoreMissing(ArrayList<ItemStack> i1, ArrayList<Item> i2){
		boolean truth = false;
		for (ItemStack it : i1){
			for (Item itt : i2){
				if (it.getItem() == itt){
					truth = true;
				}


			}
			if (truth == false){
				return false;
			}
			else {
				truth = false;
			}


		}
		return true;
	}
}
