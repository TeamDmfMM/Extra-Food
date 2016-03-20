package dmf444.ExtraFood.Client.modelbake;

import dmf444.ExtraFood.Common.items.nbt.NBTFoodRegistry;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodSpecs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Enumeration;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */

@SideOnly(Side.CLIENT)
public class TextureInjector {


    @SubscribeEvent
    public void sticherEventPre(TextureStitchEvent.Pre event) {
        for (NBTFoodSpecs spec : NBTFoodRegistry.food.foods){

            event.map.registerSprite(new ResourceLocation(spec.defualtIcon));

            Enumeration<String> enumt = spec.additives.elements();

            while (enumt.hasMoreElements()) {
                String s = enumt.nextElement();

                event.map.registerSprite(new ResourceLocation(s));
            }

        }
    }

}
