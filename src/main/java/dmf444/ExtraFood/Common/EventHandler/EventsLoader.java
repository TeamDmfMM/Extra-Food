package dmf444.ExtraFood.Common.EventHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import dmf444.ExtraFood.Common.WorldGen.PeanutWorldGen;
import dmf444.ExtraFood.Common.WorldGen.StrawberryWorldGen;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import dmf444.ExtraFood.Core.GuiHandler;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.ConfigHandler;

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
			MinecraftForge.EVENT_BUS.register(new ExtraFood_eventTextureHook());
			//Chest Generation
			ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
			//Load the Achivements
			AchieveLoad.loadAc();
			FMLCommonHandler.instance().bus().register(new CraftingAchievements());
			
	}
}
