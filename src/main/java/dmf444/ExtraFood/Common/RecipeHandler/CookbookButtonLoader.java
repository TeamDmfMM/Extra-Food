package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CookbookButtonLoader {

	public ArrayList<CookbookTab> buttons;
	public static CookbookButtonLoader bookButton = new CookbookButtonLoader();
	public Dictionary<String, Boolean> truth;
	public Dictionary<String, Integer> multiNum;

	public CookbookButtonLoader() {
		// TODO Auto-generated constructor stub
		this.buttons = new ArrayList<CookbookTab>();
		this.truth = new Hashtable<String, Boolean>();
		this.multiNum = new Hashtable<String, Integer>();
		
		CookbookTab t = new CookbookTab("generic");
		t.display = new ItemStack(BlockLoader.cheesePress);
		// TODO Add buttons here
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 12, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 9, 3, new ItemStack(ItemLoader.cheeseWheel), "cheesewheel", "cheesepress"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesewheel", "knife" ));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 3, 4, new ItemStack(ItemLoader.knife), "knife"));
		
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 10, new ItemStack(ItemLoader.bacon), "bacon", 1, "knife"));
		this.buttons.add(t);
		
		t = new CookbookTab("autocutter");
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 3, 4, new ItemStack(BlockLoader.autoCutter), "autocutter"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 5, 6, new ItemStack(ItemLoader.sausage), "sausage", 0, "autocutter"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 5, 2, new ItemStack(ItemLoader.slicedBread), "Bread", 0, "autocutter"));
		t.display = new ItemStack(BlockLoader.autoCutter);
		this.buttons.add(t);
		
		t = new CookbookTab("juiceBlender");
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(BlockLoader.juiceBlender), "juiceblender", 0));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 2, new ItemStack(ItemLoader.bucketstrawberry), "StrawberryJuice", 1, "juiceblender"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 5, 7, new ItemStack(ItemLoader.bucketcarrot), "CarrotJuice", 1, "juiceblender"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 10, 7, new ItemStack(ItemLoader.bucketbanana), "BananaJuice", 1, "juiceblender"));
		t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 5, new ItemStack(ItemLoader.bucketseaWater), "SeaWater", 1));
		t.display = new ItemStack(BlockLoader.juiceBlender);
		this.buttons.add(t);

		//TODO on add book page, add multi buttons
		  //this.truth.put("knife", true);


	}
	
	/*
	 * This is what will catch for multiple pages, default is 1 (Page 0 and Page 1)
	 */	
	public int NumOfPages(String page){
		if (this.multiNum.get(page) != null){
			return this.multiNum.get(page);
		} else {
			return 1;
		}
	}
	
	/*
	 * Catches calls for more than one page, default is false, changable above
	 */	
	public Boolean DoesHaveMultiPage(String page){
		if (this.truth.get(page) != null){
		return this.truth.get(page);
		} else {
			return false;
		}	
	}
	
	public ArrayList<ArrayList<int[]>> getXYCoordsOfLineForButton(String name, String pagename){
		try {
		ArrayList<ArrayList<int[]>> xys = new ArrayList<ArrayList<int[]>>();
		ClickTab ctr = this.find(name, pagename);
		List<String> pre = Arrays.asList(ctr.pre);
		ArrayList<ClickTab> prectr = new ArrayList<ClickTab>();
		for (String p : pre){
			prectr.add(this.find(p, pagename));
		}
		for (ClickTab ct : prectr){
			ArrayList<int[]> arraytemp = new ArrayList<int[]>();
			arraytemp.add(new int[]{ctr.x, ctr.y});
			arraytemp.add(new int[]{ct.x, ct.y});
			xys.add(arraytemp);
		}
		return xys;}
		catch (Exception e){
			return null;
		}


	}
	private ClickTab find(String name, String pagename){
		for (CookbookTab tabb : this.buttons){
		if (tabb.name == pagename){
		for (ClickTab tab : tabb.buttons){
			if (tab.pagename == name){
				return tab;
			}
		}}}
		return null;
	}

	protected void drawHorizontalLine(int par1, int par2, int par3, int par4, CookBookGUI gui)
    {
        if (par2 < par1)
        {
            int i1 = par1;
            par1 = par2;
            par2 = i1;
        }


        gui.drawRect(par1, par3, par2 + 1, par3 + 1, par4);
    }


    protected void drawVerticalLine(int par1, int par2, int par3, int par4, CookBookGUI gui)
    {
        if (par3 < par2)
        {
            int i1 = par2;
            par2 = par3;
            par3 = i1;
        }


        gui.drawRect(par1, par2 + 1, par1 + 1, par3, par4);
    }

    public ArrayList<ClickTab> getButtons(String tab){
    	for (CookbookTab tabb : this.buttons){
    		if (tabb.name == tab){
    			return tabb.buttons;
    		}
    	}


    	return null;
    }





}
