package dmf444.ExtraFood.Common.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.ExtraFood;

public class Oven extends BlockContainer {

    //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
    //And the second three are the top-right corner.
    public Oven(int id) {
            super(id, Material.wood);
            this.setCreativeTab(EFTabs.INSTANCE);
            //this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 3.0F, 0.6F);
    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world) {
            return new TileEntityOven();
    }
    
    //You don't want the normal render type, or it wont render properly.
    @Override
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
    
    //This is the icon to use for showing the block in your hand.
    public void registerIcons(IconRegister icon) {
            this.blockIcon = icon.registerIcon("extrafood:Zycrafted");
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
