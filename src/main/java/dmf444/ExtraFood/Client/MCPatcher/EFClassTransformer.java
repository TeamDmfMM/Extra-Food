/*
package dmf444.ExtraFood.Client.MCPatcher;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.launchwrapper.IClassTransformer;

public class EFClassTransformer implements IClassTransformer {

	@Override
	public byte[] transform(String arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		if (1 == 2){
		return patchClassInJar(arg0,arg2,arg0,EFFMLLoadingPlugin.location);}
		return null;
	}
	public byte[] patchClassInJar(String name, byte[] bytes, String ObfName, File location) {
        try {
        	//open the jar as zip
            ZipFile zip = new ZipFile(location);
          //find the file inside the zip that is called te.class or net.minecraft.entity.monster.EntityCreeper.class
          //replacing the . to / so it would look for net/minecraft/entity/monster/EntityCreeper.class
            ZipEntry entry = zip.getEntry(name.replace('.', '/') + ".class");
            if (entry == null) {
                System.out.println(name + " not found in " + location.getName());
            } else {
            	//serialize the class file into the bytes array
                InputStream zin = zip.getInputStream(entry);
                bytes = new byte[(int) entry.getSize()];
                zin.read(bytes);
                zin.close();
                System.out.println("[" + "ExtraFood-patcher" + "]: " + "Class " + name + " patched!");
            }
            zip.close();
        } catch (Exception e) {
            throw new RuntimeException("Error overriding " + name + " from " + location.getName(), e);
        }
      //return the new bytes
        return bytes;
    }

}
*/
