package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import dmf444.ExtraFood.Core.util.BPHelp;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Default class for blocks that can be rotated, keeps all the other blocks cleaner
 */
public class BlockContainerRotate extends Block implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public enum RelativeDirection {
        LEFT(-1),
        RIGHT(1),
        FRONT(0),
        DOWN(-10),
        UP(-11),
        BACK(-2);

        // Index in EnumFacing.HORIZONTALS relative to facing
        private int relativeIndex;

        RelativeDirection(int relative) {
            relativeIndex = relative;
        }

        public int getRelativeIndex() {
            return this.relativeIndex;
        }

        public EnumFacing getTrueDirection(EnumFacing in) {
            int facingIndex = in.getHorizontalIndex();
            if (facingIndex == -1) {
                if (in == EnumFacing.DOWN) {
                    return EnumFacing.DOWN;
                }
                else {
                    return EnumFacing.UP;
                }
            }
            facingIndex += relativeIndex;
            facingIndex %= 4;
            return EnumFacing.HORIZONTALS[facingIndex];
        }

        public static RelativeDirection getRelativeDirection(EnumFacing in, EnumFacing forwards) {
            int index = in.getHorizontalIndex() - forwards.getHorizontalIndex();
            for (RelativeDirection r : RelativeDirection.values()) {
                if (r.getRelativeIndex() == index) {
                    return r;
                }
            }
            if (in == EnumFacing.DOWN) {
                return DOWN;
            }
            else {
                return UP;
            }
        }
    }

    public BlockContainerRotate(Material material) {
        super(material);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    public static EnumFacing getFacing(World worldIn, BlockPos blockPos) {
        IBlockState blockState = worldIn.getBlockState(blockPos);
        EnumFacing facingIn = blockState.getValue(FACING);
        return facingIn;
    }

    public static EnumFacing getTrueDirectionFromRelative(RelativeDirection relativeDirection, World worldIn, BlockPos blockPos) {
        IBlockState blockState = worldIn.getBlockState(blockPos);
        EnumFacing facingIn = blockState.getValue(FACING);
        return relativeDirection.getTrueDirection(facingIn);
    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }


    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        world.setBlockState(pos, state.withProperty(FACING, BPHelp.getFFE(world, pos, entity, true)), 2);
    }
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, BPHelp.getFFE(worldIn, pos, placer, true));
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        dropItems(world, pos);
        super.breakBlock(world, pos, state);
    }

    private void dropItems(World world, BlockPos pos){
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof IInventory)) {
            return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world,
                        pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz,
                        new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
        EntityItem e = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
        world.spawnEntityInWorld(e);

    }

    //Copy for 1.8
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

}
