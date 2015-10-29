package dmf444.ExtraFood.Common.EventHandler;

import cpw.mods.fml.common.eventhandler.Event.Result;
import dmf444.ExtraFood.Common.blocks.OliveTreeSapling;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.entity.player.BonemealEvent;
import dmf444.ExtraFood.Common.blocks.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;

public class ExtraFood_EventBonemeal {

    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.block.equals(BlockLoader.saplingBanana))
            {
                    if (!event.world.isRemote)
                    {
                            ((BananaTreeSapling)BlockLoader.saplingBanana).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
                    }
                    event.setResult(Result.ALLOW);  //allow the bonemeal consumption and prevent other possible effects
            }else if(event.block == BlockLoader.oliveBush){
                if(!event.world.isRemote){
                    ((OliveTreeSapling)BlockLoader.oliveBush).growz(event.world, event.x, event.y, event.z, event.world.rand);
                }
                //event.setResult(Result.ALLOW);
            }
    }
}