package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.blocks.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ExtraFood_EventBonemeal {

    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.block == BlockLoader.saplingBanana)
            {
                    if (!event.world.isRemote)
                    {
                            ((BananaTreeSapling)BlockLoader.saplingBanana).grow(event.world, event.pos, event.block.getBlock().getBlockState().getBaseState(), event.world.rand);
                    }
                    event.setResult(Event.Result.ALLOW);  //allow the bonemeal consumption and prevent other possible effects
            }
    }
}