package com.dmfmm.extrafood.events;

import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.utilities.ConfigHandler;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class ConfigChangeEvent {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e){
        if(e.getModID().equalsIgnoreCase(ModInfo.MOD_ID)){
            ConfigHandler.loadConfig();
        }
    }

}