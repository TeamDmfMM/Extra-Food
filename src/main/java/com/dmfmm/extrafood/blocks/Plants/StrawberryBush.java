package com.dmfmm.extrafood.blocks.Plants;



import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class StrawberryBush extends BlockCrops{


    public StrawberryBush(String name){
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.setHardness(0.0F);
        this.disableStats();
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setTickRandomly(true);
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, BlockPos blockPos, EnumFacing side)
    {
        return true;
    }

    @Override
    protected Item getSeed()
    {
        return Item.getItemFromBlock(BlockLoader.STRAWBERRY_BUSH);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
    if (player.inventory.getCurrentItem() != null){
            ItemStack is = player.inventory.getCurrentItem();
            if (is.getItem() == Items.DYE){
                if (is.getItemDamage() == 15){
                    return false;
                }
            }

        }
        this.output(state, world, pos);
        return false;
    }
    protected void output(IBlockState state, World world, BlockPos pos){
        int states = (Integer) state.getValue(AGE);
        switch (states) {
            default:
                break;

            case 4:
            case 5:
            case 6:
                if (!world.isRemote) {
                    ItemStack item = new ItemStack(ItemLoader.STRAWBERRY, 2);
                    Entity Ientity = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item);
                    world.spawnEntityInWorld(Ientity);
                    world.setBlockState(pos, getDefaultState(), 2);
                    break;
                }
            case 7:
            case 8:
                if (!world.isRemote) {
                    ItemStack item1 = new ItemStack(ItemLoader.STRAWBERRY, 4);
                    Entity Ientity1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item1);
                    world.spawnEntityInWorld(Ientity1);
                    world.setBlockState(pos, getDefaultState(), 2);
                    break;
                }
        }
    }

    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor){
        boolean drop = false; //False don't drop. True break

        if(!world.isSideSolid(pos.down(), EnumFacing.UP, true)){
            drop = true;
        }
        if(drop == true){
            this.dropBlockAsItem((World) world, pos, world.getBlockState(pos), 0);
            ((World)world).setBlockToAir(pos);
        }
    }



    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}

