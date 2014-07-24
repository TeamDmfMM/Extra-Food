package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockJuiceBlender extends BlockContainer{

	protected BlockJuiceBlender(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(EFTabs.INSTANCE);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
	        EntityPlayer player, int metadata, float what, float these, float are) {
		player.openGui(ExtraFood.instance, 3, world, x, y, z);
		return true;
	}


	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		// TODO Auto-generated method stub
		return new TileEntityJuiceBlender();
	}
	public int getRenderType() {
        return -1;
}

//It's not an opaque cube, so you need this.
@Override
public boolean isOpaqueCube() {
        return false;
}

//It's not a normal block, so you need this too.
public boolean renderAsNormalBlock() {
        return false;
}
	public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("extrafood:ItemJuiceBlender");
}
    private void setDefaultDirection(World world, int x, int y, int z, EntityLivingBase entity) {
    	int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

		if(rotation == 0) {
		world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(rotation == 1) {
		world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(rotation == 2) {
		world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(rotation == 3) {
		world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

		
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack Itemstack) {
		
 super.onBlockAdded(world, x, y, z);
 this.setDefaultDirection(world, x, y, z, entity);
}


}
