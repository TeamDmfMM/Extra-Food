package dmf444.ExtraFood.Client;

import cpw.mods.fml.client.registry.ClientRegistry;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Client.renderer.RenderOven;
import dmf444.ExtraFood.Client.renderer.RendererJuiceBlender;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;

public class ClientProxy extends CommonProxy{
	public void registerRenderers(){ 
		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new RendererJuiceBlender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new RenderOven());
		
	}
}

