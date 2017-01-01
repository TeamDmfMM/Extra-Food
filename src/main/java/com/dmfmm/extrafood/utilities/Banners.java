package com.dmfmm.extrafood.utilities;


import com.dmfmm.extrafood.init.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraftforge.common.util.EnumHelper;

public class Banners {


    public static void init() {
        addPattern("cheese", "cw", new ItemStack(ItemLoader.CHEESE_WHEEL, 1));

    }

    public static void addPattern(String name, String id, ItemStack craftingItem) {
        name = "extrafood_" + name;
        id = "ef_" + id;
        EnumHelper.addEnum(TileEntityBanner.EnumBannerPattern.class, name.toUpperCase(), new Class[]{String.class, String.class, ItemStack.class}, new Object[]{name, id, craftingItem});
    }

}