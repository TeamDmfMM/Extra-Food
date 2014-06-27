package dmf444.ExtraFood.Common.blocks.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
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
	Item idToUse = null;
	
	public SlotFilter(IInventory par1iInventory, int par2, int par3, int par4, Item knife) {
		super(par1iInventory, par2, par3, par4);
		idToUse = knife;}
		
		// TODO Auto-generated constructor stub
	public boolean isItemValid(ItemStack is){
		if (is.getItem() == idToUse){
			return true;
		}
		return false;
	}

}
