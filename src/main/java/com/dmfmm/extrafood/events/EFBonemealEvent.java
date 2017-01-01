package com.dmfmm.extrafood.events;


import com.dmfmm.extrafood.blocks.Plants.GrapeVines;
import com.dmfmm.extrafood.init.BlockLoader;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EFBonemealEvent {

    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
        if(event.getBlock().getBlock().equals(BlockLoader.GRAPE_VINE)){
            if(!event.getWorld().isRemote)
                ((GrapeVines)event.getBlock().getBlock()).updateTick(event.getWorld(), event.getPos(), event.getWorld().getBlockState(event.getPos()), event.getWorld().rand);
            event.setResult(Event.Result.ALLOW);
        }
    }
}