package com.dmfmm.extrafood.items.nbt;

import com.dmfmm.extrafood.utilities.tabs.OvenFoodTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import java.util.*;

public class NBTFood extends ItemFood {

	public String name;
	public NBTFoodSpecs specs;


	
	public NBTFood(String name){
		super(0,0,false);
		specs = NBTFoodRegistry.food.getSpecs(name);
		
		//icons = new Hashtable<String, IIcon>();
		this.setCreativeTab(OvenFoodTab.INSTANCE);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.name = name;
		
	}


	 public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase elb)
	    {
				if (elb instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)elb;
					player.getFoodStats().addStats(getHunger(stack), getSaturation(stack));
					world.playSound(player, player.getPosition(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
					this.onFoodEaten(stack, world, player);
				}

				stack.shrink(1);
				return stack;
	    }

	
	public int getHunger(ItemStack stack){
		NBTTagCompound comp = stack.getTagCompound();
		String key;
    	ArrayList<String> things = new ArrayList<String>();
		getAdditives(comp, things);
		if (specs.info.get(things) != null){
            try {
                return (int) specs.info.get(things).get(0);
            }catch (Exception e){}
            try {
                return (int) Math.round((float) specs.info.get(things).get(0));
            }catch(Exception re){}
        }
    	else {
    		return (int) specs.defualtHunger[0];
    	}
        return (int) specs.defualtHunger[0];
	}


	public float getSaturation(ItemStack stack){
		NBTTagCompound comp = stack.getTagCompound();
		String key;
    	ArrayList<String> things = new ArrayList<String>();
		getAdditives(comp, things);
		if (specs.info.get(things) != null){
    		return (float) specs.info.get(things).get(1);
    	}
    	else {
    		return specs.defualtHunger[1];
    	}
	}


	public void addInformation(ItemStack stack, EntityPlayer player, List text, boolean idk) {
		NBTTagCompound comp = stack.getTagCompound();
    	String key;
    	if (comp == null){
    		return;
    	}
    	ArrayList<String> things = new ArrayList<String>();
		getAdditives(comp, things);
		for (String i : things){
    		if (I18n.canTranslate("add." + name + "." + i)){
    			text.add("- " + TextFormatting.GREEN.toString() + I18n.translateToLocal("add." + name + "." + i));
    		}
    		else{
    			text.add("- " + i);
    		}
    	}
	}

	private void getAdditives(NBTTagCompound comp, ArrayList<String> things) {
		String key;
		for (Object keyb : comp.getKeySet().toArray()){
			key = (String)keyb;
			if (specs.addtypes.containsKey(key)){
				continue;
			}
			if (comp.hasKey(key)){
				if (comp.getBoolean(key)){
					things.add(key);
				}
			}
		}
	}


	public ArrayList<String> getIconNames(ItemStack t) {

		ArrayList<String> ret = new ArrayList<>();

		Map<String, String> possibleicons = new HashMap<>();

		Set<String> keys = specs.additives.keySet();
		//System.out.println(keys);
		for (String key : keys){
			String iconstring = specs.additives.get(key);
			possibleicons.put(key, iconstring);
		}

		NBTTagCompound comp = t.getTagCompound();

		String key;
		ArrayList<String> things = new ArrayList<String>();
		if(comp != null) {
			for (Object keyb : comp.getKeySet().toArray()) {
				key = (String) keyb;
				if (specs.addtypes.containsKey(key)) {

					continue;
				}
				if (comp.hasKey(key)) {
					if (comp.getBoolean(key)) {
						things.add(key);
					}
				}
			}
		}
		for (String thing : things){
			ret.add(possibleicons.get(thing));
		}

		return ret;



	}

	public String getBase(){
		return specs.defualtIcon;
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
    
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> things){
		for (ArrayList<String> i: specs.info.keySet()){
			//System.out.println("Here's my value of i: " + i );
			ItemStack toAdd = new ItemStack(item);
			toAdd.setTagCompound(getNBT(i));
			things.add(toAdd);
		}
	}

	public ArrayList<String> ar(String... strings){
		ArrayList<String> rval = new ArrayList<String>();
		for (String i : strings){
			rval.add(i);
		}
		return rval;
	}
}

