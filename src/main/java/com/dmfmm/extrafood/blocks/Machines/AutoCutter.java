package com.dmfmm.extrafood.blocks.Machines;

import dmf444.ExtraFood.Common.blocks.BlockContainerRotate;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class AutoCutter extends BlockContainerRotate {

    public AutoCutter() {
        super(Material.wood);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        //code to open gui explained later
        player.openGui(ExtraFood.instance, 1, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new AutoCutterTileEntity();
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
        return -1;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

}
