package com.dmfmm.extrafood.items.nbt;

import com.dmfmm.extrafood.library.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

public class NBTFoodLoader {
	
	public static Dictionary<String, Item> foods = new Hashtable<String, Item>();
	public static ArrayList<String> registered = new ArrayList<String>();
	
	public static void initiateItems(){
		NBTFoodRegistry.food = new NBTFoodRegistry();
		addItem("pizza");
		addItem("muffin");
	}
	
	public static void addItem(String foodname){
		foods.put(foodname, new NBTFood(foodname));
	}
	
	public static void register(){
		for (String food : Collections.list(foods.keys())){
			if (registered.contains(food)){
				continue;
			}
			else {
				GameRegistry.register(foods.get(food), new ResourceLocation(ModInfo.MOD_ID, "NBT" + food));
			}
		}
	}
	
	public static Item getItem(String name){
		return foods.get(name);
	}

}
	
