package dmf444.ExtraFood.Common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.RenderIcon;

public class GeneralFluid extends BlockFluidClassic {

	private String fluidType;
    
    public GeneralFluid(String fluidTextureName, Fluid fluid, Material material) {
            super(fluid, material);
            this.fluidType = fluidTextureName;
            
    }
    
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
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
}