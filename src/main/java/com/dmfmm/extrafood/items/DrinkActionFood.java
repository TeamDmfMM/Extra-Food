package com.dmfmm.extrafood.items;


import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class DrinkActionFood extends StanFood{

    private int FoodBarCount;
    private float SaturationCount;

    public DrinkActionFood(String name, int foodbar, float saturation)
    {
        super(name, foodbar, saturation);
        this.setMaxStackSize(1);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.FoodBarCount = foodbar;
        this.SaturationCount = saturation;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack par1, World world, EntityLivingBase living)
    {
        if(living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;
            player.getFoodStats().addStats(FoodBarCount, SaturationCount);
            if (!player.capabilities.isCreativeMode) {
                par1.shrink(1);
            }
            this.onFoodEaten(par1, world, player);
        }
        return par1;
    }


    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand)
    {
        if (player.canEat(false)){
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
        }
        return new ActionResult<>(EnumActionResult.FAIL,  itemstack);
    }
}
