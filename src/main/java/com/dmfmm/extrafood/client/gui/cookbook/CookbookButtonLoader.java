package com.dmfmm.extrafood.client.gui.cookbook;


import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.items.nbt.NBTFoodRegistry;
import com.dmfmm.extrafood.utilities.ConfigHandler;
import net.minecraft.item.ItemStack;

import java.util.*;

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

        CookbookTab t = new CookbookTab("GettingStarted");
        t.buttons.add(new ClickTab(6, 4, ItemLoader.COOKBOOK, "basicKnowlege"));
        t.buttons.add(new ClickTab(8, 6, new ItemStack(BlockLoader.STRAWBERRY_BUSH), "worldGen"));
        t.buttons.add(new ClickTab(8, 8, new ItemStack(ItemLoader.TOMATO), "plants"));
        t.buttons.add(new ClickTab(10, 4, new ItemStack(BlockLoader.WHITEOUT), "boneBlock"));
        t.buttons.add(new ClickTab(2, 4, ItemLoader.KNIFE, "knife"));
        t.buttons.add(new ClickTab(4, 6, ItemLoader.GRATER, "grater"));
        t.render = "extrafood:textures/gui/cookbookimages/GettingStarted.png";
        this.buttons.add(t);

        t = new CookbookTab("HomeCookedFood");
        t.buttons.add(new ClickTab(6, 4, ItemLoader.SANDWICH_BLT, "sandwiches"));
        t.buttons.add(new ClickTab(6, 2, ItemLoader.PEANUT_BUTTER, "spread"));
        t.buttons.add(new ClickTab(2, 3, ItemLoader.EGG, "egg"));
        t.buttons.add(new ClickTab(2, 5, ItemLoader.FRENCH_TOAST, "frenchToast", "egg"));
        t.buttons.add(new ClickTab(4, 4, ItemLoader.BACON, "bacon"));
        t.buttons.add(new ClickTab(5, 3, ItemLoader.PANCAKES, "pancake"));
        t.buttons.add(new ClickTab(2, 7, ItemLoader.VEAL, "veal"));
        t.buttons.add(new ClickTab(2, 9, ItemLoader.VEAL_KEBAB, "kebab_veal", "veal"));
        t.buttons.add(new ClickTab(4, 9, ItemLoader.PORK_KEBAB, "pork_kebab"));
        t.buttons.add(new ClickTab(6, 9, ItemLoader.STEAK_KEBAB, "steak_kebab"));
        t.buttons.add(new ClickTab(8, 8, ItemLoader.MEATBALL_PASTA, "pasta"));
        t.buttons.add(new ClickTab(10, 9, ItemLoader.CHINESE_FOOD, "chinese", "pasta", "sushi"));
        t.buttons.add(new ClickTab(10, 7, ItemLoader.SUSHI, "sushi"));
        t.buttons.add(new ClickTab(5, 7, ItemLoader.CHOCOLATE, "chocolate"));
        t.buttons.add(new ClickTab(7, 6, ItemLoader.CHOCOLATE_ICE_CREAM, "ChoIC", "chocolate", "ipop"));
        t.buttons.add(new ClickTab(8, 4, ItemLoader.ICE_POP, "ipop"));
        t.buttons.add(new ClickTab(10, 3, ItemLoader.STRAWBERRY_ICE_CREAM, "StrawIC", "ipop"));
        t.buttons.add(new ClickTab(8, 2, ItemLoader.VANILLA_ICE_CREAM, "VanIC", "ipop"));
        t.buttons.add(new ClickTab(10, 5, ItemLoader.NEOPOLITAN_ICE_CREAM, "NeoIC", "ipop"));
        t.render = "extrafood:textures/gui/cookbookimages/GeneralFood.png";
        this.buttons.add(t);

        t = new CookbookTab("CheesePress");
        t.buttons.add(new ClickTab(6, 6, new ItemStack(BlockLoader.CHEESE_PRESS), "cheesepress"));
        t.buttons.add(new ClickTab(9, 3, ItemLoader.CHEESE_WHEEL, "cheesewheel", "cheesepress"));
        t.buttons.add(new ClickTab(3, 2, ItemLoader.BUTTER, "butter", "butterMilk"));
        t.buttons.add(new ClickTab(4, 5, ItemLoader.BUTTER_MILK, "butterMilk"));
        t.buttons.add(new ClickTab(6, 4, ItemLoader.YOGURT,"yogurt"));
        t.display = new ItemStack(BlockLoader.CHEESE_PRESS);
        this.buttons.add(t);

        t = new CookbookTab("autocutter");
        t.buttons.add(new ClickTab(5, 5, new ItemStack(BlockLoader.AUTO_CUTTER), "autocutter"));
        t.buttons.add(new ClickTab(2, 5, ItemLoader.SAUSAGE, "sausage", "autocutter"));
        t.buttons.add(new ClickTab(3, 3, ItemLoader.SLICED_BREAD, "Bread", "autocutter"));
        t.buttons.add(new ClickTab(7, 3, ItemLoader.COOKED_HAMBURGER, "burger", "autocutter"));
        t.buttons.add(new ClickTab(9, 4, ItemLoader.MEATBALLS, "meatballs", "burger"));
        t.buttons.add(new ClickTab(3, 7, ItemLoader.CHEESE_SLICE, "cheeseslice", "autocutter"));
        t.buttons.add(new ClickTab(5, 2, ItemLoader.SANDWICH_HAMBURGER, "sandwichBurger", "burger", "Bread"));
        t.buttons.add(new ClickTab(7, 8, ItemLoader.FRENCH_FRIES, "fries", "autocutter"));
        t.buttons.add(new ClickTab(7, 5, ItemLoader.FISH_PIECES, "fishpieces", "autocutter"));
        t.display = new ItemStack(BlockLoader.AUTO_CUTTER);
        this.buttons.add(t);

        t = new CookbookTab("juiceBlender");
        t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 6, new ItemStack(BlockLoader.JUICE_BLENDER), "juiceblender", 1));
        t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 3, ItemLoader.BUCKET_STRAWBERRY, "StrawberryJuice", 1, "juiceblender"));
        t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 5, 8, ItemLoader.BUCKET_CARROT, "CarrotJuice", 1, "juiceblender"));
        t.buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 10, 8, ItemLoader.BUCKET_BANANA, "BananaJuice", 1, "juiceblender"));
        if(ConfigHandler.overrideWater){
            t.buttons.add(new ClickTab(2, 4, ItemLoader.BUCKET_SEA_WATER, "SeaWater"));
            t.buttons.add(new ClickTab(2, 8, ItemLoader.BUCKET_PURIFIED_WATER, "purifiedWater", "SeaWater"));}
        t.display = new ItemStack(BlockLoader.JUICE_BLENDER);
        this.buttons.add(t);

        t = new CookbookTab("oven");
        t.buttons.add(new ClickTab(6, 6, new ItemStack(BlockLoader.OVEN), "oven"));
        t.buttons.add(new ClickTab(4, 6, new ItemStack(ItemLoader.DOUGH), "dough"));
        t.buttons.add(new ClickTab(7, 3, NBTFoodRegistry.getPizzaDisplay(), "pizza", "dough"));
        t.buttons.add(new ClickTab(4, 8, NBTFoodRegistry.getMuffinDisplay(), "muffin", "dough"));
        t.display = new ItemStack(BlockLoader.OVEN);
        this.buttons.add(t);

        //TODO on add book page, add multi buttons
        //this.truth.put("knife", true);
        if(ConfigHandler.overrideWater){
            this.truth.put("SeaWater", true);
            this.multiNum.put("SeaWater", 1);
        }
        this.truth.put("cheeseslice", true);
        this.multiNum.put("cheeseslice", 2);
        this.truth.put("bacon", true);
        this.multiNum.put("bacon", 2);
        this.truth.put("cheesepress", true);
        this.multiNum.put("cheesepress", 2);
        AddPage("Bread", 2);
        AddPage("sandwiches", 15);
        AddPage("spread", 6);
        AddPage("worldGen", 3);
        AddPage("butter", 2);
        AddPage("yogurt", 2);
        AddPage("burger", 3);
        AddPage("sandwichBurger", 3);
        AddPage("autocutter", 2);
        AddPage("juiceblender", 2);
        AddPage("NeoIC", 2);
        AddPage("pasta", 5);
        AddPage("plants", 2);
        AddPage("oven", 2);
        AddPage("muffin", 6);
        AddPage("pizza", 2);

    }

    public void AddPage(String s, int pages){
        this.truth.put(s, true);
        this.multiNum.put(s, pages);
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