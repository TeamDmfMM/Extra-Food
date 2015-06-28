package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Common.WorldGen.BananaWorldGenTrees;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BananaTreeSapling extends BlockBush implements IGrowable
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    //public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockPlanks.EnumType.class);
    //private static final String __OBFID = "CL_00000305";

    protected BananaTreeSapling()
    {
        float f = 0.4F;
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, pos, state, rand);

            if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(world, pos, state, rand);
            }
        }
    }


    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        Object object = rand.nextInt(14) == 0 ? new WorldGenBigTree(true) :  new BananaWorldGenTrees(false, 6, 3, 3, true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        if (!flag) {
            return;
        }

        IBlockState iblockstate1 = Blocks.air.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(pos.add(i1, 0, j1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1 + 1, 0, j1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1, 0, j1 + 1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i1 + 1, 0, j1 + 1), iblockstate1, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate1, 4);
        }

        if (!((WorldGenerator)object).generate(worldIn, rand, pos.add(i1, 0, j1)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i1, 0, j1), state, 4);
                worldIn.setBlockState(pos.add(i1 + 1, 0, j1), state, 4);
                worldIn.setBlockState(pos.add(i1, 0, j1 + 1), state, 4);
                worldIn.setBlockState(pos.add(i1 + 1, 0, j1 + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs par2, List par3)
    {
        par3.add(new ItemStack(item, 1, 0));

    }


    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0;
        i |= ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {STAGE});
    }

}