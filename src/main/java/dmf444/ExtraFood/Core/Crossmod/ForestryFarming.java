package dmf444.ExtraFood.Core.Crossmod;

import cpw.mods.fml.common.event.FMLInterModComms;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import forestry.api.farming.Farmables;

public class ForestryFarming {

	public static void test(){
		FMLInterModComms.sendMessage("forestry", "add-farmable-crop", String.format("farmWheat@%s.-1", BlockLoader.tomatoCrop));
	}
}
