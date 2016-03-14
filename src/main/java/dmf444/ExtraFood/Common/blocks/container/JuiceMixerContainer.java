package dmf444.ExtraFood.Common.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class JuiceMixerContainer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
