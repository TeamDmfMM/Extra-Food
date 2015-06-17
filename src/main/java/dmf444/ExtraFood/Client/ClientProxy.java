package dmf444.ExtraFood.Client;

import dmf444.ExtraFood.Client.renderer.*;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.blocks.tileentity.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{

	public static BerryRender bushrender;
	
	public void registerRenderers(){ 
		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new RendererJuiceBlender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new RenderOven());
		ClientRegistry.bindTileEntitySpecialRenderer(JuiceMixerTileEntity.class, new JuiceMixerRenderer());
		//JuiceRegistry.instance = new JuiceRegistry();
		//bushrender = new BerryRender();
		//RenderingRegistry.registerBlockHandler(bushrender);
		
		
		
	}
	@Override
	public void intermodComm(){
		//FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}
}

