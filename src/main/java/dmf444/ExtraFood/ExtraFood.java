package dmf444.ExtraFood;

import dmf444.ExtraFood.Client.modelbake.ModelDynGlassbottle;
import dmf444.ExtraFood.Client.modelbake.NBTFoodModel;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.EventHandler.EventsLoader;
import dmf444.ExtraFood.Common.EventHandler.ExtraFood_EventBonemeal;
import dmf444.ExtraFood.Common.RecipeHandler.CRPageCraftGet;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.OvenRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.RegistryAutoCutter;
import dmf444.ExtraFood.Common.WorldGen.TreeManager;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodLoader;
import dmf444.ExtraFood.Core.CraftingRecipies;
import dmf444.ExtraFood.Core.Crossmod.CrossModModules;
import dmf444.ExtraFood.Core.GuiHandler;
import dmf444.ExtraFood.Core.Packets.ChannelHandler;
import dmf444.ExtraFood.Core.Packets.PacketJBTank;
import dmf444.ExtraFood.Core.init.BlockTextureRegistry;
import dmf444.ExtraFood.Core.init.ExceptionTextureRegistry;
import dmf444.ExtraFood.Core.init.ItemTextureRegistry;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.Core.util.Banners;
import dmf444.ExtraFood.Core.util.ConfigHandler;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = ModInfo.MId,name = ModInfo.Mname, version = ModInfo.Vers)

public class ExtraFood {
	@Instance(value = "ExtraFood")
	public static ExtraFood instance;
	
	@SidedProxy(clientSide= ModInfo.Clientproxy, serverSide= ModInfo.Serverproxy)
	public static CommonProxy proxy;
	
	
	public static CRPageCraftGet crafterPage;
	public static RegistryAutoCutter registryCutter;
	TreeManager treeManager = new TreeManager();


	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

        EFLog.info("Extra Food has been activated, loading blocks,items and Events");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
			
		FluidLoader.initiateFluids();
		BlockLoader.initiateBlocks();
		ItemLoader.initiateItems();
		ItemLoader.initiateFoods();
		NBTFoodLoader.initiateItems();
		NBTFoodLoader.register();
		if (ConfigHandler.GenBananaTrees){
		GameRegistry.registerWorldGenerator(treeManager, 0);
		}
		MinecraftForge.EVENT_BUS.register(new ExtraFood_EventBonemeal());
		//GameRegistry.registerWorldGenerator(new OliveTreeManager(), 0);
		
		EventsLoader.loadEvents();
		//Gui Handler Registration
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//Init the packet Handler
		ChannelHandler.init();

		CrossModModules.preInit();
		proxy.preInit();
        if (event.getSide() == Side.CLIENT) {
			OBJLoader.instance.addDomain(ModInfo.MId);
			ModelLoaderRegistry.registerLoader(ModelDynGlassbottle.LoaderDynBucketz.instance);
			ModelLoaderRegistry.registerLoader(NBTFoodModel.ModelLodaer.instance);
            ExceptionTextureRegistry.registerExceptiions();

        }
		
		EFLog.info("Cleared EF's Registry");
		
	}
		

	@EventHandler
	public void load(FMLInitializationEvent event){
		EFLog.info("Extra Food is in Init, loading stuff");
			BlockLoader.initTileEntity();
		
			proxy.registerRenderers();
		Banners.init();
			this.registryCutter = new RegistryAutoCutter();
			CraftingRecipies.craftering();
			CraftingRecipies.furnacing();
		
			proxy.registerKeybinds();
			proxy.intermodComm();
			CrossModModules.load();

        if(event.getSide() == Side.CLIENT){

            BlockTextureRegistry.RegisterBlockTextures();
            ItemTextureRegistry.registerItemTextures();


        }

		EFLog.info("Finished all INIT!");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		crafterPage = new CRPageCraftGet();
		JuiceRegistry.instance = new JuiceRegistry();
		OvenRegistry.instance = new OvenRegistry();



	}

}
