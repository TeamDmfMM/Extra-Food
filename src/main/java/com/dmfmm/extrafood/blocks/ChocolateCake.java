package com.dmfmm.extrafood.blocks;


import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.library.ItemLib;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.block.BlockCake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChocolateCake extends BlockCake implements ICustomItemBlock{


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
        return new ItemStack(this.getCustomItemBlock(), 1);
    }

    @Override
    public Item getCustomItemBlock() {
        return new ItemBlockSpecial(BlockLoader.CHOCOLATE_CAKE_BLOCK).setMaxStackSize(1).setUnlocalizedName(ItemLib.CHOCOLATE_CAKE).setRegistryName(ItemLib.CHOCOLATE_CAKE).setCreativeTab(ExtraFoodTab.INSTANCE);
    }
}
