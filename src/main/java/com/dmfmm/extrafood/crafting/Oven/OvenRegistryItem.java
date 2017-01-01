package com.dmfmm.extrafood.crafting.Oven;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;


public class OvenRegistryItem {
    // The nbttagstring that will be added when this additive is put in


    public Dictionary<Item, String> itemsAdditive;


    public ArrayList<ItemStack> baseRecipe;


    public ItemStack base;


    public OvenRegistryItem(ArrayList<ItemStack> recipe, ItemStack baseout){
        this.baseRecipe = recipe;
        this.base = baseout;
        this.itemsAdditive = new Hashtable<Item, String>();


    }
    public void addAdditive(Item item, String tag){
        itemsAdditive.put(item, tag);


    }
    public ItemStack createItemStack(ArrayList<ItemStack> add){
        ItemStack item = this.base.copy();
        item.setTagCompound(new NBTTagCompound());
        for (ItemStack itemst : add){
            Item s = itemst.getItem();
            if (itemsAdditive.get(s) != null){
                item.getTagCompound().setBoolean(itemsAdditive.get(s), true);
            }
        }
        return item;
    }
    public ArrayList<Item> getItemsAdditive(){
        ArrayList<Item> i = new ArrayList<Item>();
        Enumeration<Item> iss = this.itemsAdditive.keys();
        while (iss.hasMoreElements()){
            i.add(iss.nextElement());
        }
        return i;
    }






}
