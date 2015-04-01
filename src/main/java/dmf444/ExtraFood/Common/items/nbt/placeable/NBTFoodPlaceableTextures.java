package dmf444.ExtraFood.Common.items.nbt.placeable;

import java.util.HashMap;
import java.util.Map;

public class NBTFoodPlaceableTextures {

	public static NBTFoodPlaceableTextures i  = new NBTFoodPlaceableTextures();
	
	public Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	
	public NBTFoodPlaceableTextures(){
		//TODO add texturescome
	}
	
	public void addType(String name){
		data.put(name, new HashMap<String, String>());
	}
	
	public void addOverlay(String name, String additive, String location){
		data.get(name).put(additive, location);
	}
	public String getOverlay(String name, String additive){
		return data.get(name).get(additive);
	}
}

