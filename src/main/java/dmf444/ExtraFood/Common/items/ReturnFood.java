package dmf444.ExtraFood.Common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public ItemStack onItemUseFinish(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        super.onFoodEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return new ItemStack(ReturnStack);
    }
}