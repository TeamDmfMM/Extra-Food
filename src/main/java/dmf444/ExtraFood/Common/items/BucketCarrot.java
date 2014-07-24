package dmf444.ExtraFood.Common.items;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;


public class BucketCarrot extends ItemBucket{

	private int FoodStat;
	private float SaturationLvl;

	public BucketCarrot(int foodBar, float saturation) {
		super(BlockLoader.Bcarrotjuice);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:bucket_carrot");
		this.setUnlocalizedName("BucketCarrot");
		this.FoodStat = foodBar;
		this.SaturationLvl = saturation;


	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World par2World, EntityPlayer Player)
    {
		 --stack.stackSize;
	        Player.getFoodStats().addStats(FoodStat, SaturationLvl);
	        par2World.playSoundAtEntity(Player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

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
        return EnumAction.drink;
    }
	
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_){
		ItemStack t = super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
		if (t.getItem() == ItemLoader.bucketcarrot){
			p_77659_3_.setItemInUse(p_77659_1_, 32);
			return p_77659_1_;
		}
		else {
			return t;
		}
	}

}
