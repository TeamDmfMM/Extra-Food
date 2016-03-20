package dmf444.ExtraFood.Common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class EdibleFluid extends Fluid {

    int HUNGER;
    float STARVE;
    
    public EdibleFluid(String fluidName, ResourceLocation still, ResourceLocation flowing, int hunger, float saturation) {
        super(fluidName, still, flowing);
        this.HUNGER = hunger;
        this.STARVE = saturation;
    }

    
}