package dmf444.ExtraFood.Common.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Client.ClientProxy;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.EFLog;
import dmf444.ExtraFood.util.RenderIcon;

public class PeanutBush extends Block implements IGrowable {



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
	  public IIcon getIcon(int side, int meta){
		  if (meta  < 7)
	        {
	            if (meta >= 4 && meta < 7)
	            {
	                meta = 5;
	                return RenderIcon.getIcon("Peanut", 1);
	            }


	            return RenderIcon.getIcon("Peanut");
	        }
	        else
	        {
	            return RenderIcon.getIcon("Peanut", 2);
	        }
	}


	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
	    {
	        super.updateTick(world, x, y, z, random);


//	        if (world.getBlockLightValue(x, y + 1, z) >= 9) 
	        // im just gonna change this to my own code, okay?
	        //NO IT'S NOT OK!!!! I WANT MY CODE
	        //MOMMY- HE STOLE MY CODE!!!
//	        {
//	            int l = world.getBlockMetadata( x, y, z);
//
//	            if (l < 7)
//	            {
//	                float f = this.magicStuff(world,  x, y, z);
//
//	                if (random.nextInt((int)(25.0F / f) + 1) == 0)
//	                {
//	                    ++l;
//	                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
//	                }
//	            }
//	        }
	        if (world.getBlockLightValue(x, y + 1, z) >= 9) {
	        	// Can survive, next!
	        	int meta = world.getBlockMetadata(x, y, z);


	        	// Can grow more?
	        	if (meta < 7){
	        		// Yes, yes it can!
	        		// Now, should I use my magical power to make it grow a bit?
	        		// Well, first lets check if it is in nice rows:
	        		float modifier = this.getGrowthModifierForBlock(world, x, y, z);
	        		// Now, with the modifier in mind, check if we should add to the growth:
	        		if (random.nextInt((int)(25.0 / modifier) + 1) == 0){
	        			// Randomly give it a little boost:
	        			if (random.nextInt(7) == 0) {meta += 2;}
	        			else {meta += 1;}
	        			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	        		}




	        	}
	        	// No, lets go home now :(
	        }
	    }
	}


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float what, float these, float are) {
    	int meta = world.getBlockMetadata(x, y, z);
    	if (player.inventory.getCurrentItem() != null){
    		ItemStack is = player.inventory.getCurrentItem();
    		if (is.getItem() == Items.dye){
    			if (is.getItemDamage() == 15){
    				return false;
    			}
    		}
    	}
    	switch (meta) {
    	case -1:
    		return false;
    	
    	case 7: case 8:
    		if(!world.isRemote){
    		ItemStack item1 = new ItemStack(ItemLoader.peanut, 4);
    		Entity Ientity1 = new EntityItem(world, x, y, z, item1);
			world.spawnEntityInWorld(Ientity1);
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    		return true;
    		}
    	}
    	return false;
    }
    /*
    private ArrayList<Integer> SlotsWithItem = new ArrayList<Integer>();
    
	private boolean isSpaceInInv(EntityPlayer player, int numberIn) {
		if(player.inventory.getFirstEmptyStack() == -1 && !player.inventory.hasItem(ItemLoader.peanut)){
			return false; //Player has no empty inventory and has no strawberry
		} else if(player.inventory.getFirstEmptyStack() != -1){
				return true;
		} else if(player.inventory.hasItem(ItemLoader.peanut)){
			this.getItemStacks(player);
			if (SlotsWithItem.isEmpty()){
				return false;
			}
			for(int i = 0; i <= SlotsWithItem.size() - 1; ++i){
				//ItemStack item = player.inventory.getStackInSlot(SlotsWithItem.get(i));
				//EFLog.error(SlotsWithItem.get(i));
				if(player.inventory.getStackInSlot(SlotsWithItem.get(i)).stackSize < 64 && player.inventory.getStackInSlot(SlotsWithItem.get(i)).stackSize + numberIn <= 64){
					return true;
				}		//player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.strawberry, 2));
			}
			return false;
		}
		return true;
	}
	private void getItemStacks(EntityPlayer player){
		SlotsWithItem.clear();
		for(int i = 0; i < player.inventory.mainInventory.length; ++i){
			if(player.inventory.mainInventory[i].isItemEqual(new ItemStack(ItemLoader.peanut))){
				SlotsWithItem.add(i);
			}
		}
	}	*/
    @Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		boolean drop = false; //False don't drop. True break
		
		if(!world.isSideSolid(x, y - 1, z, ForgeDirection.UP)){
			drop = true;
		}
		if(drop == true){
			this.dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlockToAir(x, y, z);
		}
	}

	//private void placeInInv(EntityPlayer player) {
	//	player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.peanut, 4));	
	//}

	 @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister iiconr)
	    {

	        	RenderIcon.addIcon("Peanut", ModInfo.MId.toLowerCase() + ":Plants/peanut_stage_0", iiconr);
	        	RenderIcon.addIcon("Peanut" + "1", ModInfo.MId.toLowerCase() + ":Plants/peanut_stage_1", iiconr);
	        	RenderIcon.addIcon("Peanut" + "2", ModInfo.MId.toLowerCase() + ":Plants/peanut_stage_2", iiconr);

	    }
	 @SideOnly(Side.CLIENT)
	    public int getRenderType()
	    {
	        return  ClientProxy.bushrender.getRenderId();
	    }
		public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
		@Override
		public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
			return world.getBlockMetadata(x, y, z) != 7;
		}
		@Override
		public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
			//Copy of BlockCrops
			return true;
		}
		@Override
		public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
			this.onBonemealEvent(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);			
		}


	    public void onBonemealEvent(World world, int x, int y, int z)
	    {
	        int meta = world.getBlockMetadata(x, y, z) + 1;


	        boolean randfact = world.rand.nextInt(3) <= 1;
	        if (meta < 7){
		        if ( randfact && meta == 6){
		        	meta += 1;
		        }
		        else if (randfact && meta >= 4){
		        	meta += 2;
		        }
		        else if (randfact && meta < 4){
		        	meta += 3;
		        }
		        else {
		        	meta += 1;
		        }
	        }


	        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	    }
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }


	    private float getGrowthModifierForBlock(World world, int x, int y, int z)
	    {
	        float f = 1.0F;
	        Block block = world.getBlock(x, y, z - 1);
	        Block block1 = world.getBlock(x, y, z + 1);
	        Block block2 = world.getBlock(x - 1, y, z);
	        Block block3 = world.getBlock(x + 1, y, z);
	        Block block4 = world.getBlock(x - 1, y, z - 1);
	        Block block5 = world.getBlock(x + 1, y, z - 1);
	        Block block6 = world.getBlock(x + 1, y, z + 1);
	        Block block7 = world.getBlock(x - 1, y, z + 1);
	        boolean flag = block2 == this || block3 == this;
	        boolean flag1 = block == this || block1 == this;
	        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;


	        for (int l = x - 1; l <= x + 1; ++l)
	        {
	            for (int i1 = z - 1; i1 <= z + 1; ++i1)
	            {
	                float f1 = 0.0F;


	                if (world.getBlock(l, y - 1, i1) == Blocks.dirt || world.getBlock(l, y - 1, i1) == Blocks.grass)
	                {
	                    f1 = 1.0F;


	                    if (world.getBlock(l, y - 1, i1).isFertile(world, l, y - 1, i1))
	                    {
	                        f1 = 3.0F;
	                    }
	                }


	                if (l != x || i1 != z)
	                {
	                    f1 /= 4.0F;
	                }


	                f += f1;
	            }
	        }


	        if (flag2 || flag && flag1)
	        {
	            f /= 2.0F;
	        }


	        return f;
	    }
}
