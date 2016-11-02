package dmf444.ExtraFood.Common.items.nbt;

import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.*;

public class NBTFoodRegistry {
	
	public static NBTFoodRegistry food;

	public ArrayList<NBTFoodSpecs> foods;
	
	public NBTFoodSpecs getSpecs(String name){
		for (NBTFoodSpecs i : foods){
			if (Objects.equals(i.name, name)){
				return i;
			}
		}
		return null;
	}
	
	public NBTFoodRegistry(){
		// TODO Place food registries in here
		foods = new ArrayList<NBTFoodSpecs>();
		addFoods("pizza", Pizza_ADD, p +"pizzaBase", new float[] {10, 9}, lst(ar("pepperoni","fish")));
		addFood("muffin", Muffin_ADD, Muffin_Type, p +"muffinBase", new float[]{6, 3}, lst(ar()));
				

				
				
						
	}
	private String p = "extrafood:items/oven/";
	private Dictionary<String, ArrayList<Object>> Pizza_ADD = dict("pepperoni", p +"pizzaPepperoni", is(ItemLoader.sausage), "fish", p +"pizzaFish", is(Items.COOKED_FISH), "olives", p +"pizzaOlive", new ItemStack(ItemLoader.olive, 3), "cheese", p +"pizzaCheese", new ItemStack(ItemLoader.cheeseSlice, 2));
	private Dictionary<String, ArrayList<Object>> Muffin_ADD = dict("chocolate_chip", p +"muffinChocolate", is(ItemLoader.chocolate), "strawberry", p +"muffinStrawberry", is(ItemLoader.strawberry), "banana", p +"muffinBanana", is(ItemLoader.banana), "apple", p +"muffinApple", is(Items.APPLE), "Doublechocolate", p +"muffinDoubleChocolate", new ItemStack(ItemLoader.chocolate, 2));
	
	
	private Dictionary<ArrayList<String>, ArrayList<Object>> Muffin_Type = createInfo("chocolate_chip", 8, 4, "strawberry", 10, 4,"Doublechocolate", 12, 2, "apple", 10, 5, "banana", 10, 6);//, "banana", "chocolate_chip", 15, 6
	
	
	
	
	
	
	
	
	
	//Added space.... fixes my visuals :)
	public void addFood(String name, Dictionary<String, ArrayList<Object>> adds, Dictionary<ArrayList<String>, ArrayList<Object>> info, String dIcon, float[] dHunger, ArrayList<ArrayList<String>> non){
		NBTFoodSpecs spec = new NBTFoodSpecs();
		spec.additives = convert(adds);
		spec.addtypes = convert2(adds);
		spec.name = name;
		spec.defualtIcon = dIcon;
		spec.defualtHunger = dHunger;
		spec.info = info;
		spec.non = non;
		spec.setupModelName();
		foods.add(spec);

		
	}
	public void addFoods(String name, Dictionary<String, ArrayList<Object>> adds, String dIcon, float[] dHunger, ArrayList<ArrayList<String>> non){
		NBTFoodSpecs spec = new NBTFoodSpecs();
		spec.additives = convert(adds);
		spec.addtypes = convert2(adds);
		spec.name = name;
		spec.defualtIcon = dIcon;
		spec.defualtHunger = dHunger;
		spec.non = non;
		spec.setup();
		foods.add(spec);
		
	}

	
	public Dictionary<String,String> convert(Dictionary<String,ArrayList<Object>> to){
		Dictionary<String,String> d = new Hashtable<String,String>();
		for (String i : Collections.list(to.keys())){
			d.put(i, (String) to.get(i).get(0));
		}
		return d;
	}
	
	public Dictionary<String,ItemStack> convert2(Dictionary<String,ArrayList<Object>> to){
		Dictionary<String,ItemStack> d = new Hashtable<String,ItemStack>();
		for (String i : Collections.list(to.keys())){
			if (to.get(i).get(1) == null){
				d.put(i, new ItemStack(Items.REDSTONE));
			}
			else {
				d.put(i, (ItemStack) to.get(i).get(1));
			}
		}
		return d;
	}
	public ItemStack is(Item i){
		return new ItemStack(i, 1);
	}
	
	public ArrayList<String> ar(String... strings){
		ArrayList<String> rval = new ArrayList<String>();
		for (String i : strings){
			rval.add(i);
		}
		Collections.sort(rval);
		return rval;
	}
	public ArrayList<ArrayList<String>> lst(ArrayList<String>... strings){
		ArrayList<ArrayList<String>> rval = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> i : strings){
			rval.add(i);
		}
		return rval;
	}
	
	public Dictionary<String, ArrayList<Object>> dict(Object... strings){
		Dictionary<String, ArrayList<Object>> d = new Hashtable<String, ArrayList<Object>>();
		String key = "";
		String val1 = "";
		ArrayList<Object> thing = null;
		int ready = 0;
		for (Object s : strings){
			if (ready == 0){
				key = (String) s;
				ready = 1;
				
			}
			else if (ready == 1){
				val1 = (String) s;
				ready = 2;
				
			}
			else {
				thing = new ArrayList<Object>();
				thing.add(val1);
				thing.add(s);
				ready = 0;
				d.put(key, thing);
			}
		}
		//System.out.println(d);
		return d;
		
	}
	/**
	 * Continous list of Info
	 * 
	 * String item
	 * int Hunger
	 * int Saturation
	 */
	public Dictionary<ArrayList<String>, ArrayList<Object>> createInfo(Object... info){
		Dictionary<ArrayList<String>, ArrayList<Object>> rval = new Hashtable<ArrayList<String>, ArrayList<Object>>();
		String defining = "";
		ArrayList<String> strings = new ArrayList<String>();
		boolean ggg = false;
		float[] dmfmm = new float[2];
		boolean done = false;
		for (Object o : info){
			if (o instanceof String){
				if (ggg == false){
					ggg = true;
					defining = (String) o;
					strings.add(defining);
				}
				else {
					strings.add((String) o);
				}
			}
			if (o instanceof Float || o instanceof Integer){
				float ot;
				if (o instanceof Integer){
					ot = new Float((int)o);
				}
				else {
					ot = (float)o;
				}
				if (done == false){
					dmfmm[0] = (float) ot;
					done = true;
				}
				else {
					dmfmm[1] = (float) ot;
					done = false;
					
					ggg = false;
					
					ArrayList<Object> tttt = new ArrayList<Object>();
					
					tttt.add(dmfmm[0]);
					tttt.add(dmfmm[1]);
					//System.out.println("Strings: " + strings);
					rval.put((ArrayList<String>) strings.clone(), tttt);
					strings.clear();
				}
			}
		}
		//System.out.println(Collections.list(rval.keys()).size());
		return (Dictionary<ArrayList<String>, ArrayList<Object>>)rval;
	}
	
	public static ItemStack getPizzaDisplay(){
		ItemStack bob = new ItemStack(NBTFoodLoader.getItem("pizza"));
		bob.setTagCompound(((NBTFood)(bob.getItem())).getNBT("pepperoni", "cheese"));
		//bob.setTagCompound();
		return bob;
	}
    public static ItemStack getMuffinDisplay(){
        ItemStack bob = new ItemStack(NBTFoodLoader.getItem("muffin"));
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setBoolean("Doublechocolate", true);
		bob.setTagCompound(tagCompound);
		EFLog.error(((NBTFood) bob.getItem()).getIconNames(bob).size());
        return bob;
    }
	
}

