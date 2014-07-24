package dmf444.ExtraFood.Common.fluids;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.FluidIcon;

public class BananaJuice extends BlockFluidClassic {

    
    public BananaJuice(Fluid fluid, Material material) {
            super(fluid, material);
            
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
    return side <= 1 ? FluidIcon.getIcon("Fluid" + "BananaJuice") : FluidIcon.getIcon("Fluid" + "BananaJuice", 1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {

    	FluidIcon.addIcon("Fluid" + "BananaJuice",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "BananaJuice" + "_Still"));
    	FluidIcon.addIcon("Fluid" + "BananaJuice" + "1",register.registerIcon(ModInfo.MId.toLowerCase() + ":fluid/Fluid_" + "BananaJuice" + "_Flow"));

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