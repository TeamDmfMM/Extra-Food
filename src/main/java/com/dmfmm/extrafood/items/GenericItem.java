package com.dmfmm.extrafood.items;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;

public class GenericItem extends Item{

    public GenericItem(String itemName){
        super();
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setRegistryName(itemName);
        this.setUnlocalizedName(itemName);

    }
}
