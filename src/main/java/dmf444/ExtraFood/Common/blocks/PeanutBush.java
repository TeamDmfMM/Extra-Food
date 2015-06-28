package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class PeanutBush extends StrawberryBush {



	public PeanutBush(Material material){
		super(material);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
        this.disableStats();
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTickRandomly(true);
	}


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        int meta = state.getBlock().getMetaFromState(state);
        if (player.inventory.getCurrentItem() != null) {
            ItemStack is = player.inventory.getCurrentItem();
            if (is.getItem() == Items.dye) {
                if (is.getItemDamage() == 15) {
                    return false;
                }
            }
        }
        switch (meta) {
            case 7:
            case 8:
                if (!world.isRemote) {
                    ItemStack item1 = new ItemStack(ItemLoader.peanut, 4);
                    Entity Ientity1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item1);
                    world.spawnEntityInWorld(Ientity1);
                    world.setBlockState(pos, state.getBlock().getStateFromMeta(0), 2);
                    return true;
                }
            default:
                return false;
        }
    }

}
