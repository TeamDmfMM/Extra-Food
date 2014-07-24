package dmf444.ExtraFood.Client.MCPatcher;

import java.util.Arrays;

import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;

public class ExtraFoodCModDummyContainer extends DummyModContainer {

	public ExtraFoodCModDummyContainer() {
		super (new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "extrafood-patch";
		meta.name = "ExtraFood-patcher";
		meta.version = "1.0";
		meta.credits = "The guys on the minecraft forums for giving great tutorials on how to do these things";
		meta.authorList = Arrays.asList("mincrmatt12");
		meta.description = "";
		meta.updateUrl = "";
		meta.url = "";
		meta.screenshots = new String[0];
		meta.logoFile = "";
	}

	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}


	@Subscribe
	public void modConstruction(FMLConstructionEvent evt){

	}

	@Subscribe
	public void init(FMLInitializationEvent evt) {

	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent evt) {


	}

	@Subscribe
	public void postInit(FMLPostInitializationEvent evt) {


	}


}
	



