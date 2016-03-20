package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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
	public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer Player)
    {
		 --par1ItemStack.stackSize;
	        Player.getFoodStats().addStats(8, 0.6F);
	        par2World.playSoundAtEntity(Player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(par1ItemStack, par2World, Player);
	        if (!par2World.isRemote) {
	        Player.addChatComponentMessage(new TextComponentString(message));
	        }
		return par1ItemStack;
	        
    }

}
