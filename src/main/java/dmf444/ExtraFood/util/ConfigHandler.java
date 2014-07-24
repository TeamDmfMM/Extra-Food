package dmf444.ExtraFood.util;
import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class ConfigHandler
{
	public static boolean GenBananaTrees;
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
