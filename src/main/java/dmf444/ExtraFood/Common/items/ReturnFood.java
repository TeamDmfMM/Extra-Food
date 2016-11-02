package dmf444.ExtraFood.Common.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ReturnFood extends StanFood
{

	private Item ReturnStack;
	
    public ReturnFood(int foodbar, float saturation, Item items)
    {
        super(foodbar, saturation);
        this.setMaxStackSize(1);
        this.ReturnStack = items;
    }

    public ItemStack onItemUseFinish(ItemStack p_77654_1_, World p_77654_2_, EntityLivingBase p_77654_3_)
    {
        super.onFoodEaten(p_77654_1_, p_77654_2_, (EntityPlayer)p_77654_3_);
        return new ItemStack(ReturnStack);
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
    public EnumAction getItemUseAction(ItemStack stack)
    {
        if(stack.getItem().equals(ItemLoader.butterMilk)) {
            return EnumAction.DRINK;
        }else{
            return EnumAction.EAT;
        }
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (player.canEat(false)){
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult<>(EnumActionResult.FAIL, stack);
    }
}