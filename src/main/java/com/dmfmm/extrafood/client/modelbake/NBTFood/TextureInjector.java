package com.dmfmm.extrafood.client.modelbake.NBTFood;

import com.dmfmm.extrafood.items.nbt.NBTFoodRegistry;
import com.dmfmm.extrafood.items.nbt.NBTFoodSpecs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Enumeration;

/**
 * Created by TeamDMFMM on 1/22/2017. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */

@SideOnly(Side.CLIENT)
public class TextureInjector {


    @SubscribeEvent
    public void sticherEventPre(TextureStitchEvent.Pre event) {
        for (NBTFoodSpecs spec : NBTFoodRegistry.food.foods){

            event.getMap().registerSprite(new ResourceLocation(spec.defualtIcon));

            for (String s : spec.additives.values()) {
                event.getMap().registerSprite(new ResourceLocation(s));
            }

        }
    }

}
