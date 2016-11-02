package com.dmfmm.extrafood.utilities;

import com.dmfmm.extrafood.library.ModInfo;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class EFLog {

    public static void log(Level logLevel, Object object)
    {
        FMLLog.log(ModInfo.MOD_ID, logLevel, String.valueOf(object));
    }


    public static void all(Object object)
    {
        log(Level.ALL, object);
    }


    public static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }

    public static void tell(Object object)
    {
        log(Level.INFO, "**************************");
        log(Level.INFO, "*" + object);
        log(Level.INFO, "**************************");
    }

    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }


    public static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }


    public static void info(Object object)
    {
        log(Level.INFO, object);
    }


    public static void off(Object object)
    {
        log(Level.OFF, object);
    }


    public static void trace(Object object)
    {
        log(Level.TRACE, object);
    }


    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }
}
