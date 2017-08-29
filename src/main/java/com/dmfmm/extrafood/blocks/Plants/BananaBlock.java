package com.dmfmm.extrafood.blocks.Plants;


import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BananaBlock extends Block {


    public BananaBlock(Material material, String name) {
        super(material);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        //this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);

    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemLoader.BANANA;
    }
    public int quantityDropped(Random rand) {
        return rand.nextInt(7) +3;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }


}
