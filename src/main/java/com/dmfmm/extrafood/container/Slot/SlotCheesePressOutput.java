package com.dmfmm.extrafood.container.Slot;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotCheesePressOutput extends Slot {


    public SlotCheesePressOutput(IInventory par1iInventory, int par2, int par3, int par4) {
        super(par1iInventory, par2, par3, par4);
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack){
        return super.onTake(player, stack);
    }

    @Override
    public boolean isItemValid(ItemStack i){
        return false;
    }


}