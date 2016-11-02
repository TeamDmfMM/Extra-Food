package com.dmfmm.extrafood.utilities.tabs;


import com.dmfmm.extrafood.library.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OvenFoodTab extends CreativeTabs {

    public static OvenFoodTab INSTANCE = new OvenFoodTab();


    public OvenFoodTab() {
        super(ModInfo.MOD_ID + ".OvenFood");
    }


    @Override
    public ItemStack getIconItemStack() {
        ItemStack bob = new ItemStack(NBTFoodLoader.getItem("pizza"));
        bob.setTagCompound(((NBTFood) NBTFoodLoader.getItem("pizza")).getNBT("pepperoni", "cheese"));
        return bob;
    }


    @Override
    public Item getTabIconItem() {
        return this.getIconItemStack().getItem();
    }
}
