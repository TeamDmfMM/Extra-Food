package com.dmfmm.extrafood.events;


import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.utilities.EFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class AchievementsEvent {

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event){
        Item item = event.crafting.getItem();
        EntityPlayer thePlayer = event.player;

        if (item.equals(Item.getItemFromBlock(BlockLoader.CHEESE_PRESS))){
            event.player.addStat(EFAchievementPage.MAKE_CHEESE_PRESS, 1);
        }else if (item.equals(ItemLoader.KNIFE)){
            //EFLog.error("PING!");
            event.player.addStat(EFAchievementPage.OBTAIN_CHEESE, 1);
        }

    }

    @SubscribeEvent
    public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
        Item item = event.smelting.getItem();
        EntityPlayer p = event.player;
    }
}