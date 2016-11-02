package com.dmfmm.extrafood.blocks.Plants;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BananaBlock extends Block {


    public BananaBlock(Material material) {
        super(material);
        this.setCreativeTab(EFTabs.INSTANCE);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);

    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemLoader.banana;
    }
    public int quantityDropped(Random rand) {
        return rand.nextInt(7) +3;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }


}
