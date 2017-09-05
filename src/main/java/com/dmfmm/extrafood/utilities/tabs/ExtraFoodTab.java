package com.dmfmm.extrafood.utilities.tabs;

import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.library.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtraFoodTab extends CreativeTabs {

    public static ExtraFoodTab INSTANCE = new ExtraFoodTab();


    public ExtraFoodTab() {
        super(ModInfo.MOD_ID);
    }


    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemLoader.CHEESE_WHEEL);
    }
}