package dmf444.ExtraFood.Common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class EdibleFluid extends Fluid {

    int HUNGER;
    float STARVE;
    
    public EdibleFluid(String fluidName, ResourceLocation still, ResourceLocation flowing, int hunger, float saturation) {
        super(fluidName.toLowerCase(), still, flowing);
        this.HUNGER = hunger;
        this.STARVE = saturation;
    }

    
}