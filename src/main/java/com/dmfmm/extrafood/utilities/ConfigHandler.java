package com.dmfmm.extrafood.utilities;

import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class ConfigHandler {

    public static Configuration config;

    //ALL CONFIGS MUST BE PROTECTED!!!
    public static boolean GenBananaTrees;
    public static boolean FeelLikeAure;
    public static boolean useNEI;
    public static boolean overrideWater;

    public static void init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
            loadConfig();
        }

    }

    public static void loadConfig(){
        //Put config here
        GenBananaTrees = config.get(Configuration.CATEGORY_GENERAL, "GenBananaTrees", true, "Allow Banana Trees to spawn").getBoolean(true);
        FeelLikeAure = config.get("MISC", "FeelLikeAure", false, "Instead of French Fries, you get Potato Lava").getBoolean(false);
        useNEI = config.get(Configuration.CATEGORY_GENERAL, "UseNEI", false, "If NEI is installed, it will show mod recipies").getBoolean(false);
        overrideWater = config.get(Configuration.CATEGORY_GENERAL, "Remove&ReplaceWaterBuckets", true, "By disabling this, you will not be able to drink water buckets").getBoolean(true);


        if(config.hasChanged()){
            config.save();
        }
    }
}