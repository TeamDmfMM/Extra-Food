package dmf444.ExtraFood.Common.EventHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import dmf444.ExtraFood.Common.blocks.BlockLoader; 
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import net.minecraft.stats.Achievement;
 
public class TestHandle implements ICraftingHandler {
 
	@Override 
	public void onCrafting(EntityPlayer player, ItemStack item,
				IInventory craftMatrix) {
 
			if (item.itemID == BlockLoader.cheesePress.blockID){
						player.addStat(AchieveLoad.cheesePress, 1);
			}
			else if (item.itemID == ItemLoader.knife.itemID){
						player.addStat(AchieveLoad.obtainKnife, 1);
			}
			// TODO Auto-generated method stub
	}
 
  	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
 
	// TODO Auto-generated method stub
 
  	}
}
 
