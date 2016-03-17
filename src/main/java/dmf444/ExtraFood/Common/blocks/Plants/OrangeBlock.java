package dmf444.ExtraFood.Common.blocks.Plants;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by TeamDMFMM on 3/16/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class OrangeBlock extends Block {


    public OrangeBlock() {
        super(Material.cactus);
        this.setBlockBounds(0.2F, 0.4F, 0.2F, 0.8F, 1.0F, 0.8F);

    }

    public boolean isOpaqueCube() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return null;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemLoader.orange;
    }

    public int quantityDropped(Random rand) {
        return rand.nextInt(2) + 1;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }


}