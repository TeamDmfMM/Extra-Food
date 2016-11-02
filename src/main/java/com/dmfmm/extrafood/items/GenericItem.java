package com.dmfmm.extrafood.items;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;

public class GenericItem extends Item{

    public GenericItem(String itemName, boolean autoLoad){
        super();
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setRegistryName(itemName);

        if(ExtraFood.side == Side.CLIENT && autoLoad){
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(ModInfo.MOD_TEXTURE_PREFIX + this.getRegistryName()));
        }
    }
}
