package dmf444.ExtraFood.Common.blocks.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
/*
 * This class is an extension to the
 * defualt slot in vanilla minecraft.
 * 
 * It will only allow one type of item
 * in it.
 * 
 * Params: inventory, id, x, y, itemidtoallow
 */
public class SlotFilter extends Slot {
	int idToUse = -1;
	
	public SlotFilter(IInventory par1iInventory, int par2, int par3, int par4, int par5) {
		super(par1iInventory, par2, par3, par4);
		idToUse = par5;
		
		// TODO Auto-generated constructor stub
	}
	public boolean isItemValid(ItemStack is){
		if (is.itemID == idToUse){
			return true;
		}
		return false;
	}

}
