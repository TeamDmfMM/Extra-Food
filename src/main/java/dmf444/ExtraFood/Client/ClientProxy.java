package dmf444.ExtraFood.Client;

import dmf444.ExtraFood.Client.renderer.*;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.blocks.tileentity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy{

	
	public void registerRenderers(){

		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new JuiceBlenderRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new OvenRenderer());
	//	ClientRegistry.bindTileEntitySpecialRenderer(JuiceMixerTileEntity.class, new JuiceMixerRenderer());
		//JuiceRegistry.instance = new JuiceRegistry();

		
		
		
	}
	@Override
	public void intermodComm(){
		//FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}

	public void preInit() {
		//OBJLoader.instance.addDomain(ModInfo.MId);
		//MinecraftForge.EVENT_BUS.register(this);
	//	OBJRender.init();
	}

	@SubscribeEvent
	public void onTextureStitchEvent(TextureStitchEvent event){
		event.map.registerSprite(new ResourceLocation("extrafood:model/JuiceMixer1"));
	}
}

