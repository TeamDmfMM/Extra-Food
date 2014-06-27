package dmf444.ExtraFood.Common.blocks;

import java.util.Random;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BananaBlock extends Block {

	public BananaBlock(Material material) {
		super(material);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
	
	}
	
	public boolean isOpaqueCube()
	    {
	        return false;
	    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	        return null;
	    }
	
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public Item getItemDropped(int metadata, Random random, int fortune) {
    	return ItemLoader.banana;
    }
    public int quantityDropped(Random rand) {
    	return rand.nextInt(7) +3;
    	}
    
}
