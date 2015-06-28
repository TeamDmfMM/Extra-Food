package dmf444.ExtraFood.Common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class GeneralFluid extends BlockFluidClassic {

	private String fluidType;
    
    public GeneralFluid(Fluid fluid, Material material) {
            super(fluid, material);
            
    }
    /*
    @Override
    public IIcon getIcon(int side, int meta) {
    	return side <= 1 ? RenderIcon.getIcon("Fluid" + fluidType) : RenderIcon.getIcon("Fluid" + fluidType, 1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
    	RenderIcon.addIcon("Fluid" + fluidType,register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + fluidType + "_Still"));
    	RenderIcon.addIcon("Fluid" + fluidType + "1",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + fluidType + "_Flow"));
    }
    */
    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.canDisplace(world, pos);
    }
    
    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, pos);
    }
    
}