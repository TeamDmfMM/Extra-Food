package com.dmfmm.extrafood.blocks.Machines;

import dmf444.ExtraFood.Common.blocks.BlockContainerRotate;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockJuiceBlender extends BlockContainerRotate{


    public BlockJuiceBlender() {
        super(Material.rock);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        player.openGui(ExtraFood.instance, 3, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityJuiceBlender();
    }
    public int getRenderType() {
        return -1;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

}
