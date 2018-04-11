package com.dmfmm.extrafood.blocks.Machines;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.blocks.BlockContainerRotate;
import com.dmfmm.extrafood.tileentities.CheesePressTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class CheesePress extends BlockContainerRotate {

    public CheesePress(String name) {
        super(Material.ROCK, name);


    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new CheesePressTileEntity();
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }



    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        //code to open gui explained later
        player.openGui(ExtraFood.INSTANCE, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }


}
