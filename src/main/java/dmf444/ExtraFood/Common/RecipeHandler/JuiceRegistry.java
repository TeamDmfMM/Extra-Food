package dmf444.ExtraFood.Common.RecipeHandler;


import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.util.Dictionary;
import java.util.Hashtable;


public class JuiceRegistry {




	public Dictionary<Item,Fluid > juices;
	public Dictionary<Fluid, String> juicenames;
	public Dictionary<Fluid, float[]> juicecolors;

	public static JuiceRegistry instance = null;

	public JuiceRegistry(){
		//TODO Registry jucies here
		juices = new Hashtable<Item, Fluid>();
		//juicenames = new Hashtable<Fluid, String>();
		juicecolors = new Hashtable<Fluid, float[]>();
		
		registerJuice(FluidLoader.Fstrawberryjuice, ItemLoader.strawberry);
		registerJuice(FluidLoader.Fbananajuice, ItemLoader.banana);
		registerJuice(FluidLoader.Fcarrotjuice, Items.carrot);

		registerColor(FluidLoader.Fbananajuice, 211, 230, 78);
		registerColor(FluidLoader.Fstrawberryjuice, 199, 0, 4);
		registerColor(FluidLoader.Fcarrotjuice, 255, 110, 18);


	}
	public void registerColor(Fluid i, int r, int g, int b){
		this.juicecolors.put(i, new float[] {r / 255.0f, g / 255.0f, b / 255.0f});
	}
	public float[] getColor(ItemStack i){
		return this.juicecolors.get(this.getJuiceFromItemStack(i));
	}

	public void registerJuice(Fluid fluid, Item item){
		juices.put(item, fluid);
		//juicenames.put(fluid, texture);
	}
	public Fluid getJuiceFromItemStack(ItemStack is){
		try {
		return this.juices.get(is.getItem());}
		catch (Exception e) {
			return null;
		}
	}
/*	public String getTextureFromJuice(Fluid juice){
		try {
			return this.juicenames.get(juice);}
			catch (Exception e) {
				return null;
			}
	}*/




}
