package dmf444.ExtraFood.Common.blocks;


import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;


public class StrawberryBush extends Block implements IGrowable {



	public StrawberryBush(Material material){
		super(material);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
        this.disableStats();
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTickRandomly(true);
	}



	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
	    {
	        super.updateTick(world, pos, state, random);


//	        if (world.getBlockLightValue(x, y + 1, z) >= 9) 
	        // im just gonna change this to my own code, okay?
	        //NO IT'S NOT OK!!!! I WANT MY CODE
	        //MOMMY- HE STOLE MY CODE!!!

	        if (world.getBlockLightOpacity(pos.north()) >= 9) {
	        	// Can survive, next!
	        	int meta = state.getBlock().getMetaFromState(state);


	        	// Can grow more?
	        	if (meta < 7){
	        		// Yes, yes it can!
	        		// Now, should I use my magical power to make it grow a bit?
	        		// Well, first lets check if it is in nice rows:
	        		float modifier = this.getGrowthModifierForBlock(world, pos.getX(), pos.getY(), pos.getZ());
	        		// Now, with the modifier in mind, check if we should add to the growth:
	        		if (random.nextInt((int)(25.0 / modifier) + 1) == 0){
	        			// Randomly give it a little boost:
	        			if (random.nextInt(7) == 0) {meta += 2;}
	        			else {meta += 1;}
	        			world.setBlockState(pos, state.getBlock().getStateFromMeta(meta), 2);
	        		}

	        	}
	        	// No, lets go home now :(
	        }
	    }
	}


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
    	int meta = state.getBlock().getMetaFromState(state);
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
    	
    	case 4: case 5: case 6:
    		if(!world.isRemote){
    		ItemStack item = new ItemStack(ItemLoader.strawberry, 2);
    		Entity Ientity = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item);
			world.spawnEntityInWorld(Ientity);world.setBlockState(pos, state.getBlock().getStateFromMeta(0), 2);
			return true;
    		}
    	case 7: case 8:
    		if(!world.isRemote){
    		ItemStack item1 = new ItemStack(ItemLoader.strawberry, 4);
    		Entity Ientity1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item1);
			world.spawnEntityInWorld(Ientity1);
            world.setBlockState(pos, state.getBlock().getStateFromMeta(0), 2);
    		return true;
    		}
    	}
    	return false;
    }


	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block){
		boolean drop = false; //False don't drop. True break
		
		if(!world.isSideSolid(pos.down(), EnumFacing.UP)){
			drop = true;
		}
		if(drop == true){
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
		}
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
		public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient){
			return state.getBlock().getMetaFromState(state) != 7;
		}

		@Override
		public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
			//Copy of BlockCrops
			return true;
		}
		@Override
		public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
			this.onBonemealEvent(world, pos, state);
		}


	    public void onBonemealEvent(World world, BlockPos pos, IBlockState state)
	    {
	        int meta = state.getBlock().getMetaFromState(state) + 1;


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
            world.setBlockState(pos, state.getBlock().getStateFromMeta(meta), 2);
	    }

	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }


	    private float getGrowthModifierForBlock(World world, int x, int y, int z)
	    {
	        float f = 1.0F;
	        Block block = world.getBlockState(new BlockPos(x, y, z - 1)).getBlock();
	        Block block1 = world.getBlockState(new BlockPos(x, y, z + 1)).getBlock();
	        Block block2 = world.getBlockState(new BlockPos(x - 1, y, z)).getBlock();
	        Block block3 = world.getBlockState(new BlockPos(x + 1, y, z)).getBlock();
	        Block block4 = world.getBlockState(new BlockPos(x - 1, y, z - 1)).getBlock();
	        Block block5 = world.getBlockState(new BlockPos(x + 1, y, z - 1)).getBlock();
	        Block block6 = world.getBlockState(new BlockPos(x + 1, y, z + 1)).getBlock();
	        Block block7 = world.getBlockState(new BlockPos(x - 1, y, z + 1)).getBlock();
	        boolean flag = block2 == this || block3 == this;
	        boolean flag1 = block == this || block1 == this;
	        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;


	        for (int l = x - 1; l <= x + 1; ++l)
	        {
	            for (int i1 = z - 1; i1 <= z + 1; ++i1)
	            {
	                float f1 = 0.0F;


	                if (world.getBlockState(new BlockPos(l, y - 1, i1)).getBlock() == Blocks.dirt || world.getBlockState(new BlockPos(l, y - 1, i1)).getBlock() == Blocks.grass)
	                {
	                    f1 = 1.0F;


	                    if (world.getBlockState(new BlockPos(l, y - 1, i1)).getBlock().isFertile(world, new BlockPos(l, y - 1, i1)))
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
