package dmf444.ExtraFood.Common.EventHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader; 
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import net.minecraft.stats.Achievement;
 
public class TestHandle extends SlotCrafting {
    private EntityPlayer thePlayer;

	public TestHandle(EntityPlayer p_i1823_1_, IInventory p_i1823_2_,
			IInventory p_i1823_3_, int p_i1823_4_, int p_i1823_5_,
			int p_i1823_6_) {
		super(p_i1823_1_, p_i1823_2_, p_i1823_3_, p_i1823_4_, p_i1823_5_, p_i1823_6_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCrafting(ItemStack item){
 
			if (item == new ItemStack(BlockLoader.cheesePress)){
						this.thePlayer.addStat(AchieveLoad.cheesePress, 1);
			}
			else if (item == new ItemStack(ItemLoader.knife)){
						this.thePlayer.addStat(AchieveLoad.obtainKnife, 1);
			}
			 //TODO Auto-generated method stub
	}
 

	public void onSmelting(EntityPlayer player, ItemStack item) {
 
	 //TODO Auto-generated method stub

  	}
}

