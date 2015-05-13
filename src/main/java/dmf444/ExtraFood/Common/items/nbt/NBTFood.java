package dmf444.ExtraFood.Common.items.nbt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Core.OvenFoodTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.*;

public class NBTFood extends ItemFood {
	public String name;
	
	public NBTFoodSpecs specs;
	
	public Dictionary<String, IIcon> icons;
	
	
	public IIcon base;
	
	public NBTFood(String name){
		super(0,0,false);
		specs = NBTFoodRegistry.food.getSpecs(name);
		
		icons = new Hashtable<String, IIcon>();
		this.setCreativeTab(OvenFoodTab.INSTANCE);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.name = name;
		
	}
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
	
	
	
	public int getRenderPasses(int k){
		return 5;
	}
	
	 public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	    {
	        --stack.stackSize;
	        player.getFoodStats().addStats(getHunger(stack), getSaturation(stack));
	        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(stack, world, player);
	        return stack;
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
    	//System.out.println(keys);
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
    		//System.out.println(icons.get(Collections.list(specs.additives.keys()).get(pass - 1)).getIconName());
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
    
    public void getSubItems(Item item, CreativeTabs tab, List things){
    	for (ArrayList<String> i: Collections.list(specs.info.keys())){
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

