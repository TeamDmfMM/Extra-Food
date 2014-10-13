package dmf444.ExtraFood.Common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dmf444.ExtraFood.Core.EFTabs;

public class DrinkActionFood extends StanFood{

	private int FoodBarCount;
	private float SaturationCount;
	
	    public DrinkActionFood(int foodbar, float saturation)
	    {
	    	super(foodbar, saturation);
	        this.setMaxStackSize(1);
	        this.setCreativeTab(EFTabs.INSTANCE);
	        this.FoodBarCount = foodbar;
	        this.SaturationCount = saturation;
	    }
	    
	    public ItemStack onEaten(ItemStack par1, World world, EntityPlayer Player)
	    {
	    	Player.getFoodStats().addStats(FoodBarCount, SaturationCount);
	        if (!Player.capabilities.isCreativeMode)
	        {
	            --par1.stackSize;
	        }
	        this.onFoodEaten(par1, world, Player);
	        	return par1;
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
	        return EnumAction.drink;
	    }

	    /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	    {
	    	if (player.canEat(false)){
	    		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
	    	}
	        return itemstack;
	    }
}
