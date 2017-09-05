package com.dmfmm.extrafood.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;


public class EdibleFluid extends Fluid {

    int hunger;
    float starve;

    public EdibleFluid(String fluidName, ResourceLocation still, ResourceLocation flowing, int hunger, float saturation) {
        super(fluidName.toLowerCase(), still, flowing);
        this.hunger = hunger;
        this.starve = saturation;
    }


}