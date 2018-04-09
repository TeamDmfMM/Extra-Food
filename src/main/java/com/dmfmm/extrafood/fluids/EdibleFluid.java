package com.dmfmm.extrafood.fluids;

import com.dmfmm.extrafood.library.ModInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;


public class EdibleFluid extends Fluid {

    int hunger;
    float starve;
    private static final String still = "fluid_%s_still";
    private static final String flow = "fluid_%s_flow";

    public EdibleFluid(String fluidName, String resourceName, int hunger, float saturation) {
        super(fluidName.toLowerCase(), rl(still, resourceName), rl(flow, resourceName));
        this.hunger = hunger;
        this.starve = saturation;
    }

    public EdibleFluid(String fluidName, int hunger, float saturation) {
        this(fluidName, fluidName, hunger, saturation);
    }


    private static String localize(String type, String fluid){
        return String.format(type, fluid);
    }

    private static ResourceLocation rl(String type, String name){
        return new ResourceLocation(ModInfo.MOD_RESOURCE_FLUIDS + localize(type, name));
    }

}