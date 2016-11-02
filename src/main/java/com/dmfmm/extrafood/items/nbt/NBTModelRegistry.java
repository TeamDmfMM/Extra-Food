package com.dmfmm.extrafood.items.nbt;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */

@SideOnly(Side.CLIENT)
public class NBTModelRegistry {
    private static NBTModelRegistry ourInstance = new NBTModelRegistry();

    public static NBTModelRegistry getInstance() {
        return ourInstance;
    }

    private NBTModelRegistry() {

        for (NBTFoodSpecs spec : NBTFoodRegistry.food.foods){
            models.put(spec, new ModelResourceLocation("extrafood:" + spec.hackyModelName, "inventory"));
        }

    }

    public Map<NBTFoodSpecs, ModelResourceLocation> models = new HashMap<>();
}
