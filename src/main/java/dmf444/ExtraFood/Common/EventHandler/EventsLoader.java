package dmf444.ExtraFood.Common.EventHandler;

import dmf444.ExtraFood.Common.WorldGen.PeanutWorldGen;
import dmf444.ExtraFood.Common.WorldGen.StrawberryWorldGen;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EventsLoader {
	

	public static void loadEvents() {

			//Generate Bushes
			GameRegistry.registerWorldGenerator(new StrawberryWorldGen(), 0);
			GameRegistry.registerWorldGenerator(PeanutWorldGen.peanutGen, 0);
			//Bucket Pickup Handler
			MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
			//Add Seeds to the grass list
			MinecraftForge.addGrassSeed(new ItemStack(ItemLoader.tomatoSeeds), 20);
			MinecraftForge.addGrassSeed(new ItemStack(ItemLoader.rawlettuceSeeds), 25);
			//Hook allows other mods to use liquid Textures
			    //MinecraftForge.EVENT_BUS.register(new ExtraFood_eventTextureHook());
			//Chest Generation
			ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
			//Load the Achivements
			AchieveLoad.loadAc();
			MinecraftForge.EVENT_BUS.register(new CraftingAchievements());
			
	}
}
