package dmf444.ExtraFood.Common.EventHandler;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.entity.player.BonemealEvent;
import dmf444.ExtraFood.Common.blocks.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;

public class ExtraFood_EventBonemeal {

    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.block == BlockLoader.saplingBanana)
            {
                    if (!event.world.isRemote)
                    {
                            ((BananaTreeSapling)BlockLoader.saplingBanana).growTree(event.world, event.x, event.y, event.z, event.world.rand);
                    }
                    event.setResult(Result.ALLOW);  //allow the bonemeal consumption and prevent other possible effects
            }
    }
}