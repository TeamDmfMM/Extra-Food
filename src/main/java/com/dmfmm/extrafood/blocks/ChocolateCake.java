package com.dmfmm.extrafood.blocks;


import com.dmfmm.extrafood.init.ItemLoader;
import net.minecraft.block.BlockCake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChocolateCake extends BlockCake{    


	public ChocolateCake(String name)
    {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ItemLoader.CHOCOLATE_CAKE, 1);
    }

}
