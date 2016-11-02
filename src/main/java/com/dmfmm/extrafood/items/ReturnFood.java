package com.dmfmm.extrafood.items;

import com.dmfmm.extrafood.init.ItemLoader;
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

    public ReturnFood(String name, int foodbar, float saturation, Item item)
    {
        super(name, foodbar, saturation);
        this.setMaxStackSize(1);
        this.ReturnStack = item;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living)
    {
        super.onFoodEaten(stack, world, (EntityPlayer)living);
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
        if(stack.getItem().equals(ItemLoader.BUTTER_MILK)) {
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