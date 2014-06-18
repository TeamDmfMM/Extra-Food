package dmf444.ExtraFood.Common.EventHandler;

import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;
import dmf444.ExtraFood.Common.blocks.BananaTreeSapling;
import dmf444.ExtraFood.Common.blocks.BlockLoader;

public class ExtraFood_EventBonemeal {
    @ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.ID == BlockLoader.saplingBanana.blockID)
            {
                    if (!event.world.isRemote)
                    {
                            ((BananaTreeSapling)BlockLoader.saplingBanana).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
                    }
                    event.setResult(Result.ALLOW);  //allow the bonemeal consumption and prevent other possible effects
            }
    }
}