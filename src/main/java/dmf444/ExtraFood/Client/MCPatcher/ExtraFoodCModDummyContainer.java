package dmf444.ExtraFood.Client.MCPatcher;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;

import java.util.Arrays;

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
	



