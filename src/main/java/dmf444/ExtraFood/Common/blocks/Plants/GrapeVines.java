package dmf444.ExtraFood.Common.blocks.Plants;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by TeamDMFMM on 3/24/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therefore
 * credit us, just don't steal large portions of this.
 */
public class GrapeVines extends Block implements IShearable{

    public static final PropertyInteger GROWTH = PropertyInteger.create("growth", 0, 4);

    public GrapeVines() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(GROWTH, 0));
        this.setCreativeTab(EFTabs.INSTANCE);
        this.setTickRandomly(true);
        this.setBlockBounds(0, 0.8f, 0, 1, 1, 1);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        this.checkAndDropBlock(world, pos, state);

        if (world.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = ((Integer)state.getValue(GROWTH)).intValue();

            if (i < 4) {
                if (rand.nextInt((int)(25.0F / 2) + 1) == 0) {
                    world.setBlockState(pos, state.withProperty(GROWTH, i+1), 2);
                }
            }else if(i == 4){
                EnumFacing facing = null;
                boolean foundAvaiable = false;
                if(world.isAirBlock(pos.east()) && !world.isAirBlock(pos.east().up())){
                    facing = EnumFacing.EAST;
                    foundAvaiable = true;
                }else if(world.isAirBlock(pos.north()) && !world.isAirBlock(pos.north().up())){
                    facing = EnumFacing.NORTH;
                    foundAvaiable = true;
                }else if(world.isAirBlock(pos.west()) && !world.isAirBlock(pos.west().up())){
                    facing = EnumFacing.WEST;
                    foundAvaiable = true;
                }else if(world.isAirBlock(pos.south()) && !world.isAirBlock(pos.south().up())){
                    facing = EnumFacing.SOUTH;
                    foundAvaiable = true;
                }
                if(foundAvaiable && facing != null){
                    world.setBlockState(pos.offset(facing), this.getDefaultState(), 2);
                    world.markBlockForUpdate(pos.offset(facing));
                }
            }
        }
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (world.getBlockState(pos).getValue(GROWTH) != 4) {
            return false;
        }else{
            //SPAWN ITEM
            if(!world.isRemote) {
                world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemLoader.grapes)));
            }
            world.setBlockState(pos, this.getDefaultState(), 2);
            world.markBlockForUpdate(pos);
            return true;
        }


    }
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        this.checkAndDropBlock(world, pos, state);
    }
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
        this.checkAndDropBlock(worldIn, pos, state);
    }

    protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
    {
        if (world.getBlockState(pos.up()).getBlock() == Blocks.air || world.getBlockState(pos.up()).getBlock().getBlockBoundsMinY() != 0) {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockState(pos, Blocks.air.getDefaultState(), 3);
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(new ItemStack(Blocks.vine));
        return itemStacks;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(GROWTH, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(GROWTH)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {GROWTH});
    }
}
