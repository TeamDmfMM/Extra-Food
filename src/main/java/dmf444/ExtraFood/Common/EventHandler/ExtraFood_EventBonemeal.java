package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.blocks.Plants.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.Plants.OliveTreeSapling;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ExtraFood_EventBonemeal {

    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.getBlock() == BlockLoader.saplingBanana)
            {
                    if (!event.getWorld().isRemote)
                    {
                            ((BananaTreeSapling)BlockLoader.saplingBanana).grow(event.getWorld(), event.getPos(), event.getBlock().getBlock().getBlockState().getBaseState(), event.getWorld().rand);
                    }
                    event.setResult(Event.Result.ALLOW);  //allow the bonemeal consumption and prevent other possible effects
            } else if(event.getBlock() == BlockLoader.oliveBush){
                if(!event.getWorld().isRemote){
                    ((OliveTreeSapling)BlockLoader.oliveBush).generateTree(event.getWorld(), event.getPos(), event.getBlock().getBlock().getBlockState().getBaseState(), event.getWorld().rand);
                }
            }
    }
}