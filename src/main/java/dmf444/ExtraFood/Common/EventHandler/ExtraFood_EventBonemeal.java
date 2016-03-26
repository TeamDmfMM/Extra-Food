package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.blocks.Plants.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.Plants.GrapeVines;
import dmf444.ExtraFood.Common.blocks.Plants.OliveTreeSapling;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExtraFood_EventBonemeal {

    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
         if(event.block.getBlock().equals(BlockLoader.grapeVine)){
             if(!event.world.isRemote)
                 ((GrapeVines)event.block.getBlock()).updateTick(event.world, event.pos, event.world.getBlockState(event.pos), event.world.rand);
             event.setResult(Event.Result.ALLOW);
         }
    }
}