package dmf444.ExtraFood;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import dmf444.ExtraFood.Client.renderer.BerryRender;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.EventHandler.BucketHandler;
import dmf444.ExtraFood.Common.EventHandler.ExtraFood_EventBonemeal;
import dmf444.ExtraFood.Common.EventHandler.TestHandle;
import dmf444.ExtraFood.Common.RecipeHandler.CRPageCraftGet;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.RegistryAutoCutter;
import dmf444.ExtraFood.Common.WorldGen.StrawberryWorldGen;
import dmf444.ExtraFood.Common.WorldGen.TreeManager;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.AchieveLoad;
import dmf444.ExtraFood.Core.CraftingRecipies;
import dmf444.ExtraFood.Core.GuiHandler;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.util.ConfigHandler;
import dmf444.ExtraFood.util.EFLog;


@Mod(modid = ModInfo.MId,name = ModInfo.Mname, version = ModInfo.Vers)
//channel={"ExtraFoodRC"}, packetHandler = PacketHandler.class)
public class ExtraFood {
	@Instance(value = "ExtraFood")
	public static ExtraFood instance;
	
	@SidedProxy(clientSide= ModInfo.Clientproxy, serverSide= ModInfo.Serverproxy)
	public static CommonProxy proxy;
	
	
	public static CRPageCraftGet crafterPage;
	public static RegistryAutoCutter registryCutter;
	TreeManager treeManager = new TreeManager();
	
	public static SimpleNetworkWrapper JBTanknet;

	
	
		@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
			
			EFLog.info("Extra Food has been activated, loading blocks,items and Events");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
			
		FluidLoader.initiateFluids();
		BlockLoader.initiateBlocks();
		ItemLoader.initiateItems();
		ItemLoader.initiateFoods();

		
		if (ConfigHandler.GenBananaTrees){
		GameRegistry.registerWorldGenerator(treeManager, 0);
		MinecraftForge.EVENT_BUS.register(new ExtraFood_EventBonemeal());
		}
		GameRegistry.registerWorldGenerator(new StrawberryWorldGen(), 0);
		
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		AchieveLoad.loadAc();
		
		JBTanknet = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MId);
		JBTanknet.registerMessage(PacketJBTank.Handler.class, PacketJBTank.class, 1,Side.CLIENT);

		
		
			EFLog.info("Cleared EF's Registry");
		
	}
		

	@EventHandler
	public void load(FMLInitializationEvent event){
		
		BlockLoader.initTileEntity();
		
		proxy.registerRenderers();
		this.registryCutter = new RegistryAutoCutter();
		CraftingRecipies.craftering();
		CraftingRecipies.furnacing();
		
		proxy.registerKeybinds();


		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		crafterPage = new CRPageCraftGet();
		JuiceRegistry.instance = new JuiceRegistry();
	}
}
