package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
 
public class CraftingAchievements{

	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event){
		Item item = event.crafting.getItem();
		EntityPlayer thePlayer = event.player;
 
			if (item.equals(Item.getItemFromBlock(BlockLoader.cheesePress))){
				event.player.addStat(AchieveLoad.cheesePress, 1);
			}else if (item.equals(ItemLoader.knife)){
				//EFLog.error("PING!");
				event.player.addStat(AchieveLoad.obtainKnife, 1);
			}

	}
 
	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
		Item item = event.smelting.getItem();
		EntityPlayer p = event.player;
  	}
}

