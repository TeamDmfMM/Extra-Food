package dmf444.ExtraFood.Client.modelbake;

import dmf444.ExtraFood.Common.items.nbt.NBTModelRegistry;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class ModelBakeInjector {

    public static final ModelBakeInjector instance = new ModelBakeInjector();

    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event) {

        for (ModelResourceLocation l : NBTModelRegistry.getInstance().models.values()) {


            Object getter = event.modelRegistry.getObject(l);

            if (getter instanceof IBakedModel) {
                IBakedModel existing = (IBakedModel) getter;
                NBTFoodSmartItemModel custom = new NBTFoodSmartItemModel(existing);
                event.modelRegistry.putObject(l, custom);
            }
        }


    }

}
