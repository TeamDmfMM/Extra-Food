package com.dmfmm.extrafood.crafting;


import com.dmfmm.extrafood.init.FluidLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.util.Collections;
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

        registerJuice(FluidLoader.Fstrawberryjuice, ItemLoader.STRAWBERRY);
        registerJuice(FluidLoader.Fbananajuice, ItemLoader.BANANA);
        registerJuice(FluidLoader.Fcarrotjuice, Items.CARROT);
        registerJuice(FluidLoader.Fwatermelonjuice, Items.MELON);
        registerJuice(FluidLoader.Fapplejuice, Items.APPLE);
        registerJuice(FluidLoader.Forangejuice, ItemLoader.ORANGE);
        registerJuice(FluidLoader.Fgrapejuice, ItemLoader.GRAPES);
        registerJuice(FluidLoader.FpinappleJuice, ItemLoader.PINEAPPLE);

        registerColor(FluidLoader.Fbananajuice, 211, 230, 78);
        registerColor(FluidLoader.Fstrawberryjuice, 199, 0, 4);
        registerColor(FluidLoader.Fcarrotjuice, 255, 110, 18);
        registerColor(FluidLoader.Fwatermelonjuice, 229, 65, 46);
        registerColor(FluidLoader.Fapplejuice, 237, 291, 98);
        registerColor(FluidLoader.Forangejuice, 255, 140, 0);
        registerColor(FluidLoader.Fgrapejuice, 75, 0, 130);
        registerColor(FluidLoader.FpinappleJuice, 221, 246, 87);


    }
    public void registerColor(Fluid i, int r, int g, int b){
        this.juicecolors.put(i, new float[] {r / 255.0f, g / 255.0f, b / 255.0f});
    }
    public float[] getColor(ItemStack i){
        return this.juicecolors.get(this.getJuiceFromItemStack(i));
    }
    public float[] getColor(Fluid f){return this.juicecolors.get(f);}

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

    public Item[] getValidItems(){
        Item[] carl = new Item[juices.size()];
        return Collections.list(juices.keys()).toArray(carl);
    }
/*	public String getTextureFromJuice(Fluid juice){
		try {
			return this.juicenames.get(juice);}
			catch (Exception e) {
				return null;
			}
	}*/




}