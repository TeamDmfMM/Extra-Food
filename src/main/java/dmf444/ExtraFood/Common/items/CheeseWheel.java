package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CheeseWheel extends ItemFood {

	public CheeseWheel(int par2, float f, boolean b) {
		super(8, 0.6F, false);
		this.setMaxStackSize(64);
		this.setCreativeTab(EFTabs.INSTANCE);
		this.setTextureName("extrafood:cheese_wheel");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer Player)
    {
		 --par1ItemStack.stackSize;
	        Player.getFoodStats().addStats(8, 0.6F);
	        par2World.playSoundAtEntity(Player, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(par1ItemStack, par2World, Player);
	        if (!par2World.isRemote) {
	        Player.addChatComponentMessage(new ChatComponentText("That tasted good!"));
	        }
		return par1ItemStack;
	        
    }

}
