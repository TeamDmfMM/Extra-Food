package com.dmfmm.extrafood.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Grater extends GenericItem {

    public Grater()
    {
        super("grater", true);
        this.maxStackSize = 1;
        this.setMaxDamage(150);
        //this.setTextureName("extrafood:grater");
        this.setContainerItem(this);
    }


    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack copiedStack = itemstack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;
        return copiedStack;
    }

    public boolean hasContainerItem(ItemStack itemstack)
    {
        return true;
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = new ItemStack(Items.IRON_INGOT);
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
}