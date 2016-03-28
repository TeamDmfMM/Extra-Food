package dmf444.ExtraFood.Core.util;

import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraftforge.common.util.EnumHelper;

public class Banners {


    public void init() {
        addPattern("cheese", "cw", new ItemStack(ItemLoader.cheeseWheel, 1));

    }

    public static void addPattern(String name, String id, ItemStack craftingItem) {
        name = "extrafood_" + name;
        id = "ef_" + id;
        EnumHelper.addEnum(TileEntityBanner.EnumBannerPattern.class, name.toUpperCase(), new Class[]{String.class, String.class, ItemStack.class}, new Object[]{name, id, craftingItem});
    }

}
