package com.dmfmm.extrafood.blocks.Machines;



import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.blocks.BlockContainerRotate;
import com.dmfmm.extrafood.tileentities.JuiceMixerTileEntity;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJuiceMixer  extends BlockContainerRotate {

    public BlockJuiceMixer(String name) {
        super(Material.IRON, name);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new JuiceMixerTileEntity();
    }
    /*public int getRenderType() {
        return -1;
    }*/

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean isBlockNormalCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity == null || player.isSneaking()) {return false;}

        player.openGui(ExtraFood.INSTANCE, 4, world, pos.getX(), pos.getY(), pos.getZ());
        return true;


    }

    public AxisAlignedBB setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
    {
        if((world.getBlockState(pos).getBlock() instanceof BlockJuiceMixer)) {
            EnumFacing dir = world.getBlockState(pos).getValue(this.FACING);
            switch (dir) {
                case EAST:
                    return new AxisAlignedBB(0, 0, 0, 0.8f, 1.15f, 1);
                case WEST:
                    return new AxisAlignedBB(0.20f, 0, 0, 1, 1.15f, 1);
                case NORTH:
                    return new AxisAlignedBB(0, 0, 0.20f, 1, 1.15f, 1);
                case SOUTH:
                    return new AxisAlignedBB(0, 0, 0, 1, 1.15f, 0.8f);
                default:
                    return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
            }
        }
        return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    }

    /*public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return setBlockBoundsBasedOnState(worldIn, pos);
    }*/

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return setBlockBoundsBasedOnState(source, pos);
    }

}