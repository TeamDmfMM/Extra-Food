package com.dmfmm.extrafood.blocks.Machines;


import dmf444.ExtraFood.Common.blocks.BlockContainerRotate;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJuiceMixer  extends BlockContainerRotate{//extends BlockContainerRotate

    public BlockJuiceMixer() {
        super(Material.iron);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        // TODO Auto-generated method stub
        return new JuiceMixerTileEntity();
    }
    /*public int getRenderType() {
        return -1;
    }*/

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity == null || player.isSneaking()) {return false;}

        player.openGui(ExtraFood.instance, 4, world, pos.getX(), pos.getY(), pos.getZ());
        return true;


    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
    {
        EnumFacing dir = world.getBlockState(pos).getValue(this.FACING);
        switch (dir){
            case EAST:
                this.setBlockBounds(0, 0, 0, 0.8f, 1.15f, 1);
                break;
            case WEST:
                this.setBlockBounds(0.20f, 0, 0, 1, 1.15f, 1);
                break;
            case NORTH:
                this.setBlockBounds(0, 0, 0.20f, 1, 1.15f, 1);
                break;
            case SOUTH:
                this.setBlockBounds(0, 0, 0, 1, 1.15f, 0.8f);
                break;
            default:
                this.setBlockBounds(0, 0, 0, 1, 1, 1);
        }
    }

}