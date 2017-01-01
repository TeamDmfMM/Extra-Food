package com.dmfmm.extrafood;

import com.dmfmm.extrafood.client.gui.cookbook.CRPageCraftGet;
import com.dmfmm.extrafood.crafting.AutoCutterRegistry;
import com.dmfmm.extrafood.crafting.CraftingRecipies;
import com.dmfmm.extrafood.crafting.JuiceRegistry;
import com.dmfmm.extrafood.crafting.Oven.OvenRegistry;
import com.dmfmm.extrafood.init.*;
import com.dmfmm.extrafood.items.nbt.NBTFoodLoader;
import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.network.ChannelHandler;
import com.dmfmm.extrafood.utilities.Banners;
import com.dmfmm.extrafood.utilities.ConfigHandler;
import com.dmfmm.extrafood.utilities.EFLog;
import com.dmfmm.extrafood.utilities.GuiHandler;
import com.dmfmm.extrafood.utilities.proxy.CommonProxy;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION)
public class ExtraFood {

    @Instance(value = ModInfo.MOD_ID)
    public static ExtraFood INSTANCE;

    @SidedProxy(clientSide= ModInfo.CLIENT_PROXY, serverSide= ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;


    public static Side side;
    public static CRPageCraftGet crafterPage;
    public static AutoCutterRegistry registryCutter;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EFLog.tell("Extra Food has begun Pre-init");

        side = event.getSide();
        ConfigHandler.init(new File(event.getModConfigurationDirectory(), ModInfo.MOD_ID + ".cfg"));

        FluidLoader.initiateFluids();
        BlockLoader.registerBlocks();
        ItemLoader.registerItems();
        NBTFoodLoader.initiateItems();
        NBTFoodLoader.register();
        EventsLoader.loadEvents();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        ChannelHandler.init();


        proxy.preInit();

        EFLog.tell("Extra Food has finished Pre-init");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        EFLog.tell("Extra Food has begun Init");

        TileEntityLoader.initTileEntity();

        proxy.registerRenderers();
        Banners.init();
        this.registryCutter = new AutoCutterRegistry();
        CraftingRecipies.craftering();
        CraftingRecipies.furnacing();

        proxy.registerKeybinds();
        proxy.intermodComm();
        proxy.init();

        EFLog.tell("Extra Food has finished Init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        EFLog.tell("Extra Food has begun Post-init");

        crafterPage = new CRPageCraftGet();
        JuiceRegistry.instance = new JuiceRegistry();
        OvenRegistry.instance = new OvenRegistry();
        proxy.postInit();

        EFLog.tell("Extra Food has finished Post-init");
    }

}
