package dmf444.ExtraFood.Core.util;
import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class ConfigHandler
{
	public static boolean GenBananaTrees;
	public static boolean FeelLikeAure;
	public static boolean useNEI;
	public static boolean overrideWater;
    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        Configuration configuration = new Configuration(configFile);



        try
        {
            // Load the configuration file
            configuration.load();


            // Read in properties from configuration file
            //configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
            GenBananaTrees = configuration.get(Configuration.CATEGORY_GENERAL, "GenBananaTrees", true, "Allow Banana Trees to spawn").getBoolean(true);
            FeelLikeAure = configuration.get("MISC", "FeelLikeAure", false, "Instead of French Fries, you get Potato Lava").getBoolean(false);
            useNEI = configuration.get(Configuration.CATEGORY_GENERAL, "UseNEI", false, "If NEI is installed, it will show mod recipies").getBoolean(false);
            overrideWater = configuration.get(Configuration.CATEGORY_GENERAL, "Remove&ReplaceWaterBuckets", true, "By disabling this, you will not be able to drink water buckets").getBoolean(true);
        }
        catch (Exception e)
        {
            // Log the exception
        }
        finally
        {
            //Save the configuration file
            configuration.save();
        }
    }
}
