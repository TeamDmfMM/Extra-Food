package com.dmfmm.extrafood.container.Slot;


import com.dmfmm.extrafood.utilities.EFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotCheesePressOutput extends Slot {


    public SlotCheesePressOutput(IInventory par1iInventory, int par2, int par3,
                                 int par4) {
        super(par1iInventory, par2, par3, par4);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack){
        par1EntityPlayer.addStat(EFAchievementPage.AQUIRE_CHEESE, 1);
    }
    @Override
    public boolean isItemValid(ItemStack i){
        return false;
    }


}