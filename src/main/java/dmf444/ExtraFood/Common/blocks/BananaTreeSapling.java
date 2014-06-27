package dmf444.ExtraFood.Common.blocks;

import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Core.BananaWorldGenTrees;
import dmf444.ExtraFood.Core.EFTabs;

public class BananaTreeSapling extends BlockSapling
{
    public static final String[] WOOD_TYPES = new String[] {"banana"};
    @SideOnly(Side.CLIENT)
    private IIcon[] saplingIcon;

    public BananaTreeSapling()
    {
        super();
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                this.markOrGrowMarked(par1World, par2, par3, par4, par5Random);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        p_149691_2_ &= 7;
        return saplingIcon[MathHelper.clamp_int(p_149691_2_, 0, 5)];
    }
    public void markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        if ((l & 8) == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
        }
        else
        {
            this.growTree(par1World, par2, par3, par4, par5Random);
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree (World world, int x, int y, int z, Random random)
    {
        int md = world.getBlockMetadata(x, y, z) % 8;
        world.setBlock(x, y, z, Blocks.air);
        WorldGenerator obj = null;


        obj = new BananaWorldGenTrees(false, 6, 3, 3, true);


        if (!(obj.generate(world, random, x, y, z)))
            world.setBlock(x, y, z, this, md + 8, 3);
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1 & 3;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Block par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    //@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    /*public void registerIcons(IIconRegister par1IconRegister)
    {
        this.saplingIcon = new IIcon[WOOD_TYPES.length];

        for (int i = 0; i < this.saplingIcon.length; ++i)
        {
            this.saplingIcon[i] = par1IconRegister.registerIcon("extrafood:ban_" + WOOD_TYPES[i]);
        }
    }*/
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        for (int i = 0; i < saplingIcon.length; ++i)
        {
        	saplingIcon[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + WOOD_TYPES[i]);
        }
    }

}
