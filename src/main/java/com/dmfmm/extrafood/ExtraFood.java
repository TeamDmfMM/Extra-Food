package com.dmfmm.extrafood;

import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.utilities.EFLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION)
public class ExtraFood {

    @Instance(value = ModInfo.MOD_ID)
    public static ExtraFood INSTANCE;

    public static Side side;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EFLog.tell("Extra Food has begun Pre-init");

        side = event.getSide();


        EFLog.tell("Extra Food has finished Pre-init");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        EFLog.tell("Extra Food has begun Init");


        EFLog.tell("Extra Food has finished Init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        EFLog.tell("Extra Food has begun Post-init");


        EFLog.tell("Extra Food has finished Post-init");
    }

}
