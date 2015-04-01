package dmf444.ExtraFood.Core.Crossmod.forestry;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import forestry.api.circuits.ChipsetManager;
import forestry.api.circuits.ICircuitLayout;
import forestry.api.farming.Farmables;
import forestry.api.farming.IFarmable;

public class ForestryFarming{

	public static void addFarms(){
		//FMLInterModComms.sendMessage("forestry", "add-farmable-crop", String.format("farmWheat@%s.+2", BlockLoader.tomatoCrop));
		Farmables.farmables.get("farmVegetables").add(new FarmCrop(new ItemStack(ItemLoader.tomatoSeeds), BlockLoader.tomatoCrop, 7));
		Farmables.farmables.get("farmVegetables").add(new FarmCrop(new ItemStack(ItemLoader.uselettuceSeeds), BlockLoader.lettuceCrop, 7));
		Farmables.farmables.put("farmBush", new ArrayList<IFarmable>());
		Farmables.farmables.get("farmBush").add(new FarmClick(BlockLoader.strawberryBush, 7));
		Farmables.farmables.get("farmBush").add(new FarmClick(BlockLoader.peanutbush, 7));
		
	}
	
	public static void registerCircut(){
		Circuit.farmBushManaged = new Circuit("managedBush", FarmLogicBush.class);
		
		ICircuitLayout layoutManaged = ChipsetManager.circuitRegistry.getLayout("forestry.farms.managed");
		ChipsetManager.solderManager.addRecipe(layoutManaged, new ItemStack(ItemLoader.strawberry), Circuit.farmBushManaged);
	}

}
