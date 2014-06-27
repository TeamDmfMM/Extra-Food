package dmf444.ExtraFood.Core;

import java.awt.Font;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FontLoader {//Broken class use not!
	
		  // Prepare a static "cache" mapping font names to Font objects.
		  private static String[] names = { "SourceSansPro-Light.ttf" };

		  private static Map<String, Font> cache = new ConcurrentHashMap<String, Font>(names.length);
		  static {
		    for (String name : names) {
		      cache.put(name, getFont(name));
		    }
		  }

		  public static Font getFont(String name) {
		    Font font = null;
		    if (cache != null) {
		      if ((font = cache.get(name)) != null) {
		        return font;
		      }
		    }
		    String fName = "assets/extrafood/fonts/" + name;
		    try {
		      InputStream is = FontLoader.class.getResourceAsStream(fName);
		      font = Font.createFont(Font.TRUETYPE_FONT, is);
		    } catch (Exception ex) {
		      ex.printStackTrace();
		      System.err.println(fName + " not loaded.  Using serif font.");
		      font = new Font("serif", Font.PLAIN, 24);
		    }
		    return font;
		  }
		}
