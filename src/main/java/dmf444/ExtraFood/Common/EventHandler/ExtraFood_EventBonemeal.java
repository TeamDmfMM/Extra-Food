package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.Plants.GrapeVines;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ExtraFood_EventBonemeal {

    public void onUseBonemeal(BonemealEvent event)
    {
        if(event.getBlock().getBlock().equals(BlockLoader.grapeVine)){
              if(!event.getWorld().isRemote)
                                 ((GrapeVines)event.getBlock().getBlock()).updateTick(event.getWorld(), event.getPos(), event.getWorld().getBlockState(event.getPos()), event.getWorld().rand);
                       event.setResult(Event.Result.ALLOW);
                     }
    }
}