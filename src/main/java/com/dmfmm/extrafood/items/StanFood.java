package com.dmfmm.extrafood.items;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class StanFood extends ItemFood{

    public StanFood(String itemName, int amount, float saturation, boolean isWolfMeat, boolean customLoader, String loader) {
        super(amount, saturation, isWolfMeat);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setRegistryName(itemName);
        this.setUnlocalizedName(itemName);

        GameRegistry.register(this);

        if(ExtraFood.side == Side.CLIENT){
            if(!customLoader) {
                ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName().toString(), "inventory"));
            }else{
                ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(ModInfo.MOD_TEXTURE_PREFIX + loader));
            }
        }
    }

    public StanFood(String itemName, int amount, float saturation) {
        this(itemName, amount, saturation, false, false, "");
    }

    public StanFood(String itemName, int amount, float saturation, boolean isWolfMeat) {
        this(itemName, amount, saturation, isWolfMeat, false, "");
    }
}
