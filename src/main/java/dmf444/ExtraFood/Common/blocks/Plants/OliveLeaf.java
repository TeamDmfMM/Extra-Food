package dmf444.ExtraFood.Common.blocks.Plants;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.Plants.BananaLeaf;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class OliveLeaf extends BananaLeaf {

    public static final PropertyInteger  METALVL = PropertyInteger.create("growth", 0, 4);

    public OliveLeaf(){
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)).withProperty(METALVL, 0));
    }

    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(rand.nextInt((10-1)+1) == 4 && ((Integer)state.getValue(METALVL)).intValue() < 4){
            world.setBlockState(pos, state.withProperty(METALVL, Integer.valueOf(((Integer) state.getValue(METALVL)).intValue() + 1)), 2);
        }

        super.updateTick(world, pos, state, rand);
    }
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockLoader.oliveBush);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int meta = ((Integer)world.getBlockState(pos).getValue(METALVL)).intValue();
        if(meta < 4){
            return false;
        } else{
            if(!world.isRemote) {
                EntityItem olives = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemLoader.olive));
                world.spawnEntityInWorld(olives);
            }
            world.setBlockToAir(pos);
            world.setBlockState(pos, state.withProperty(METALVL, 1));
            return true;
        }
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {CHECK_DECAY, DECAYABLE, METALVL});
    }


    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0;

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }
        int addenum=10000;
        switch (((Integer)state.getValue(METALVL)).intValue()){
            case 0:
                addenum = 10000;
                break;
            case 1:
                addenum = 20000;
                break;
            case 2:
                addenum = 30000;
                break;
            case 3:
                addenum = 40000;
                break;
            case 5:
                addenum = 50000;
                break;
    }
        return addenum+i;
    }
    public IBlockState getStateFromMeta(int meta)
    {
        int one = (meta != 0) ? Integer.parseInt("" + Integer.toString(meta).charAt(0)) : 1;
        int metaz = meta - (one*10000);

        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((metaz & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((metaz & 8) > 0)).withProperty(METALVL, one - 1);
    }
}
