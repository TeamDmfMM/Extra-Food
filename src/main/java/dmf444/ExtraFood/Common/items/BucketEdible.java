package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BucketEdible extends ItemBucket {
	
	private int FoodStat;
	private float SaturationLvl;

	
	public BucketEdible(int foodBar, float saturation, Block fluidBlock, String localName){
		super(fluidBlock);
		this.setCreativeTab(EFTabs.INSTANCE);
        this.setUnlocalizedName(localName);

		this.FoodStat = foodBar;
		this.SaturationLvl = saturation;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer Player)
    {
		 --stack.stackSize;
	        Player.getFoodStats().addStats(FoodStat, SaturationLvl);
            world.playSoundAtEntity(Player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
	        if (!world.isRemote) {
	        Player.addChatComponentMessage(new TextComponentString("That tasted good!"));
	        }
		return stack.stackSize <= 0 ? new ItemStack(Items.bucket) : stack;
	        
    }
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }
	
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_){
		ItemStack t = super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
		if (t.getItem() == this){
			p_77659_3_.setItemInUse(p_77659_1_, 32);
			return p_77659_1_;
		}
		else {
			return t;
		}
	}

}
