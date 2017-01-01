package com.dmfmm.extrafood.container.Slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/*
 * This class is an extension to the
 * default slot in vanilla Minecraft.
 *
 * It will only allow one type of item
 * in it.
 *
 * Params: inventory, id, x, y, itemidtoallow
 */
public class SlotFilter extends Slot {
    Item[] idToUse;

    public SlotFilter(IInventory par1iInventory, int par2, int par3, int par4, Item knife) {
        super(par1iInventory, par2, par3, par4);
        idToUse = new Item[]{knife};
    }

    public SlotFilter(IInventory par1iInventory, int par2, int par3, int par4, Item... items) {
        super(par1iInventory, par2, par3, par4);
        idToUse = items;
    }

    // TODO Auto-generated constructor stub
    public boolean isItemValid(ItemStack is){
        for(int i = 0; i < idToUse.length; i++){
            if(idToUse[i].equals(is.getItem())){
                return true;
            }
        }
        return false;
    }

}