package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReturnFoodDrink extends StanFood{

	private int FoodBarCount;
	private float SaturationCount;
	
	    public ReturnFoodDrink(int foodbar, float saturation)
	    {
	    	super(foodbar, saturation);
	        this.setMaxStackSize(1);
	        this.setCreativeTab(EFTabs.INSTANCE);
	        this.FoodBarCount = foodbar;
	        this.SaturationCount = saturation;
	    }
	    
	    public ItemStack onItemUseFinish(ItemStack par1, World world, EntityPlayer Player)
	    {
	    	Player.getFoodStats().addStats(FoodBarCount, SaturationCount);
	        if (!Player.capabilities.isCreativeMode)
	        {
	            --par1.stackSize;
	        }
	        this.onItemUseFinish(par1, world, Player);
	        	return par1.stackSize <= 0 ? new ItemStack(Items.bucket) : par1;
	    }


	    /**
	     * How long it takes to use or consume an item
	     */
	    public int getMaxItemUseDuration(ItemStack p_77626_1_)
	    {
	        return 32;
	    }

	    /**
	     * returns the action that specifies what animation to play when the items is being used
	     */
	    public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	        return EnumAction.DRINK;
	    }

	    /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
	    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	    {
	    	if (p_77659_3_.canEat(false)){
	    		p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
	    	}
	        return p_77659_1_;
	    }
}

