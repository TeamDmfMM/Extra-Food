package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

//This class should be renamed, but it was my first mod item EVER, so it will stay. Note:
//The string and message were not original, but were added for usablility
public class CheeseWheel extends ItemFood {
	
	private String message;

	public CheeseWheel(int par2, float f, boolean b, String msg) {
		super(8, 0.6F, false);
		this.setMaxStackSize(64);
		this.setCreativeTab(EFTabs.INSTANCE);
		//this.setTextureName("extrafood:cheese_wheel");
		this.message = msg;
	}
	

		@Override
		public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
		{
			--stack.stackSize;

			if (entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entityLiving;
				player.getFoodStats().addStats(8, 0.6F);
				world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				if (!world.isRemote) {
					player.addChatComponentMessage(new TextComponentString(this.message));
				}
			}
		return stack;
	        
    }

}
