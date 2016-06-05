package dmf444.ExtraFood.Common.blocks.Plants;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import net.minecraft.util.EnumWorldBlockLayer;

//import net.minecraft.util.AxisAlignedBB;

/**
 * Created by TeamDMFMM on 3/24/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therefore
 * credit us, just don't steal large portions of this.
 */
public class GrapeVines extends Block implements IShearable{

    public static final PropertyInteger GROWTH = PropertyInteger.create("growth", 0, 4);

    public GrapeVines() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(GROWTH, 0));
        this.setCreativeTab(EFTabs.INSTANCE);
        this.setTickRandomly(true);
       // this.setBlockBounds(0, 0.8f, 0, 1, 1, 1);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.GROUND);
        this.disableStats();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        this.checkAndDropBlock(world, pos, state);

        if (world.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = (Integer) state.getValue(GROWTH);

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
                if(foundAvaiable){
                    world.setBlockState(pos.offset(facing), this.getDefaultState(), 2);
                   // world.markBlockForUpdate(pos.offset(facing)); real vines make no notify, so me no make notify
                }
            }
        }
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.getBlockState(pos).getValue(GROWTH) != 4) {
            return false;
        }else{
            //SPAWN ITEM

            if(!world.isRemote) {
                           world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemLoader.grapes)));
                            }
            world.setBlockState(pos, this.getDefaultState(), 2);

            // world.setBlockState(pos, this.getDefaultState(), 2);
            //  world.markBlockForUpdate(pos);
            return true;
        }
    }


    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        this.checkAndDropBlock(world, pos, state);
    }
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor)
    {
        super.onNeighborChange(world, pos, neighbor);
        if (world instanceof World) {
            this.checkAndDropBlock((World) world, pos, world.getBlockState(pos));
        }
    }

    protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
    {
        if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0, 0.8f, 0, 1, 1, 1);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(new ItemStack(Blocks.VINE));
        return itemStacks;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(GROWTH, meta);
    }

    public int getMetaFromState(IBlockState state)
    {
        return (Integer) state.getValue(GROWTH);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GROWTH);
    }
}