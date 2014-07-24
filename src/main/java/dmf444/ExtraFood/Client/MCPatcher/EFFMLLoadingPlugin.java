package dmf444.ExtraFood.Client.MCPatcher;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class EFFMLLoadingPlugin implements IFMLLoadingPlugin {
	// The location of the coremod.
	public static File location;

	@Override
	public String[] getASMTransformerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModContainerClass() {
		// TODO Auto-generated method stub
		return ExtraFoodCModDummyContainer.class.getName();
	}

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		location = (File) data.get("coremodLocation");

	}



	@Override
	public String getAccessTransformerClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
