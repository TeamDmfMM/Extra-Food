package dmf444.ExtraFood.Core.Crossmod.NEI;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIEFConfig implements IConfigureNEI{



	@Override
	public void loadConfig() {
		//if(ConfigHandler.useNEI){
		API.registerRecipeHandler(new NEIAutoCutterHandler());
		API.registerUsageHandler(new NEIAutoCutterHandler());
		API.registerUsageHandler(new NEIJuiceBlenderHandler());
		API.registerRecipeHandler(new NEIJuiceBlenderHandler());
		API.registerUsageHandler(new NEICheesePressHandler());
		API.registerRecipeHandler(new NEICheesePressHandler());		
		//}
		//API.hideItem(new ItemStack(ItemLoader.knife));
	}
	
	
	@Override
	public String getName() {
		return "Extra Food";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

}
