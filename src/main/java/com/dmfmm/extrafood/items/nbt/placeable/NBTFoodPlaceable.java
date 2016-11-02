package com.dmfmm.extrafood.items.nbt.placeable;

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import dmf444.ExtraFood.Core.util.TextureUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodSpecs;

public class NBTFoodPlaceable extends Item{

public String name;
	
	public NBTFoodSpecs specs;
	
	public Dictionary<String, IIcon> icons;
	
	public BlockContainer toPlace;
	
	public IIcon base;
	
	public NBTFoodPlaceable(String name, BlockContainer place) {
		super();
		this.name = name;
		this.toPlace = place;
		
		
	}
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
	
	public void bindBlockTexture(ItemStack stack, int w, int h){
		NBTTagCompound comp = stack.stackTagCompound;
		String key;
    	ArrayList<String> things = new ArrayList<String>();
    	for (Object keyb : comp.func_150296_c().toArray()){
    		key = (String)keyb;
    		if (!Collections.list(specs.additives.keys()).contains(key)){
    			continue;
    		}
    		if (comp.hasKey(key)){
    			if (comp.getBoolean(key)){
    				things.add(key);
    			}
    		}
    	}
    	if (things.size() == 0){
    		String s = NBTFoodPlaceableTextures.i.getOverlay(name, "base");
    		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(s));
    	}
    	else {
    		String s = NBTFoodPlaceableTextures.i.getOverlay(name, "base");
    		String s2 = NBTFoodPlaceableTextures.i.getOverlay(name, things.get(0));
    		
    		TextureUtil.genTexture(new ResourceLocation(s), new ResourceLocation(s2), w, h);
    		
    		if (things.size() > 1){
    			boolean f = true;
    			for (String t : things){
    				if (f){
    					f = false;
    					continue;
    				}
    				s = NBTFoodPlaceableTextures.i.getOverlay(name, t);
    				TextureUtil.addTexture(new ResourceLocation(s), w, h);
    			}
    		}
    	}
	}
	public int getRenderPasses(int k){
		return 5;
	}
	
	public boolean onItemUse(ItemStack istack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		TileEntityNBTFoodPlaceable t = new TileEntityNBTFoodPlaceable();
		
		t.istack = istack;
		t.type = this;
		t.specs = specs;
		
		world.setBlock(x, y+1, z, toPlace);
		world.setTileEntity(x, y+1, z, t);
		istack = null;
		
		return true;
	}
	
	public int getHunger(ItemStack stack){
		NBTTagCompound comp = stack.stackTagCompound;
		String key;
    	ArrayList<String> things = new ArrayList<String>();
    	for (Object keyb : comp.func_150296_c().toArray()){
    		key = (String)keyb;
    		if (!Collections.list(specs.additives.keys()).contains(key)){
    			continue;
    		}
    		if (comp.hasKey(key)){
    			if (comp.getBoolean(key)){
    				things.add(key);
    			}
    		}
    	}
    	if (specs.info.get(things) != null){
    		return (int) specs.info.get(things).get(0);
    	}
    	else {
    		return (int) specs.defualtHunger[0];
    	}
	}
	
	public float getSaturation(ItemStack stack){
		NBTTagCompound comp = stack.stackTagCompound;
		String key;
    	ArrayList<String> things = new ArrayList<String>();
    	for (Object keyb : comp.func_150296_c().toArray()){
    		key = (String)keyb;
    		if (!Collections.list(specs.additives.keys()).contains(key)){
    			continue;
    		}
    		if (comp.hasKey(key)){
    			if (comp.getBoolean(key)){
    				things.add(key);
    			}
    		}
    	}
    	if (specs.info.get(things) != null){
    		return (float) specs.info.get(things).get(1);
    	}
    	else {
    		return specs.defualtHunger[1];
    	}
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List text, boolean idk) {
		NBTTagCompound comp = stack.stackTagCompound;
    	String key;
    	if (comp == null){
    		return;
    	}
    	ArrayList<String> things = new ArrayList<String>();
    	for (Object keyb : comp.func_150296_c().toArray()){
    		key = (String)keyb;
    		if (!Collections.list(specs.additives.keys()).contains(key)){
    			continue;
    		}
    		if (comp.hasKey(key)){
    			if (comp.getBoolean(key)){
    				things.add(key);
    			}
    		}
    	}
    	for (String i : things){
    		if (StatCollector.canTranslate("add." + name + "." + i)){
    			text.add("- " + EnumChatFormatting.GREEN.toString() + StatCollector.translateToLocal("add." + name + "." + i));
    		}
    		else{
    			text.add("- " + i);
    		}
    	}
	}
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
    	ArrayList<String> keys = Collections.list(specs.additives.keys());
    	System.out.println(keys);
    	for (String key : keys){
    		String iconstring = specs.additives.get(key);
    		icons.put(key, iconRegister.registerIcon(iconstring));
    	}
    	
    	base = iconRegister.registerIcon(specs.defualtIcon);
    }
	
    
    
    public IIcon getIcon(ItemStack stack, int pass){
    	NBTTagCompound comp = stack.stackTagCompound;
    	if (comp == null){
    		return base;
    	}
    	String key;
    	ArrayList<String> things = new ArrayList<String>();
    	for (Object keyb : comp.func_150296_c().toArray()){
    		key = (String)keyb;
    		if (!Collections.list(specs.additives.keys()).contains(key)){
    			continue;
    		}
    		if (comp.hasKey(key)){
    			if (comp.getBoolean(key)){
    				things.add(key);
    			}
    		}
    	}
    	if (pass == 0){
    		return base;
    	}
    	else {
    		int length = things.size();
    		if (pass > length){
    			pass = length;
    		}
    		if (length == 0){
    			return base;
    		}
    		System.out.println(icons.get(Collections.list(specs.additives.keys()).get(pass - 1)).getIconName());
    		return icons.get(things.get(pass - 1));
    		
    	}
    	
    }
    
    public NBTTagCompound getNBT(String... strings){
    	return getNBT(ar(strings));
    }
    
    public NBTTagCompound getNBT(ArrayList<String> things){
    	NBTTagCompound compound = new NBTTagCompound();
    	for (String i : things){
    		compound.setBoolean(i, true);
    	}
    	return compound;
    }
    public ArrayList<String> ar(String... strings){
		ArrayList<String> rval = new ArrayList<String>();
		for (String i : strings){
			rval.add(i);
		}
		return rval;
	}
    public void getSubItems(Item item, CreativeTabs tab, List things){

    	for (ArrayList<String> i: Collections.list(specs.info.keys())){
    		System.out.println("Here's my value of i: " + i );
    		ItemStack toAdd = new ItemStack(item);
    		toAdd.setTagCompound(getNBT(i));
    		things.add(toAdd);
    	}
    }
}*/

