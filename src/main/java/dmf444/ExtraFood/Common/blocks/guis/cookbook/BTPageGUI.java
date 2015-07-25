package dmf444.ExtraFood.Common.blocks.guis.cookbook;



import dmf444.ExtraFood.Common.RecipeHandler.CookbookButtonLoader;
import dmf444.ExtraFood.Common.blocks.guis.ButtonBackGUI;
import dmf444.ExtraFood.Common.blocks.guis.ButtonNextPageGUI;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTPageGUI extends GuiScreen {


String pageTextLeft;
String pageTextRight;
private ItemStack[] items;
RenderItem irender;
GuiButton next;
int page = 0;
String pagen;
GuiButton backpage;
GuiButton backGUI;
boolean Morethanone;
int pagesAllowed;

ArrayList<CBElement> ris;
int p3 = 9999;
ArrayList<ArrayList<Object>> p3r = new ArrayList<ArrayList<Object>>();



 public BTPageGUI(String pagename, Boolean multipg, int multiplePG) {

	 //This will be used to call the name of the page from the .lang file
	pageTextLeft = StatCollector.translateToLocal("cookbookL." + pagename);
	pageTextRight = StatCollector.translateToLocal("cookbookR." + pagename);
	this.items = ExtraFood.crafterPage.getArray(pagename);
	this.irender = Minecraft.getMinecraft().getRenderItem();
	pagen = pagename;
	
	ris = (ArrayList<CBElement>) this.digestString(StatCollector.translateToLocal("cookbook." + pagename));
	this.pagesAllowed = CookbookButtonLoader.bookButton.NumOfPages(pagename);
	this.Morethanone = (CookbookButtonLoader.bookButton.NumOfPages(pagename) > 1 ? true : false);
	
}

 public void drawScreen(int par1, int par2, float par3) {
	this.drawDefaultBackground();
	this.drawBookBackground();
	this.draw();
    super.drawScreen(par1, par2, par3);
 }


 public void initGui(){
     int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     GL11.glPushMatrix();
     if (StatCollector.translateToLocal("cookbook." + pagen + "2") != "cookbook." + pagen + "2"){
    	 if(Morethanone){
     this.buttonList.add(this.next = new ButtonNextPageGUI(0, i + 221, j + 160, true));
	 this.buttonList.add(this.backpage = new ButtonNextPageGUI(1, i + 13, j + 160, false));
    	}
	 this.buttonList.add(this.backGUI = new ButtonBackGUI(2, i + 6, j + 2, false));
     }
     GL11.glPopMatrix();
 }

protected void drawBookBackground() {
	//I decided to use the achivement size, because it kinda just worked!
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	GL11.glPushMatrix();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_BLEND);
    //GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(GuiLib.CBopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight + 50);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_BLEND);
    GL11.glPopMatrix();
    
 }

public int drawElementTextBlock(ArrayList<Object> args, int x, int y, int flag){
	//System.out.println(args.size());
	 this.fontRendererObj.setUnicodeFlag(true);
	//System.out.println("Magical Calling");
    GL11.glPushMatrix();
	GL11.glDisable(GL11.GL_LIGHTING);
    //GL11.glEnable(GL11.GL_BLEND);
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
	    int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
   // Check height of block
    int w = 93;
    int h = this.fontRendererObj.splitStringWidth((String) args.get(0), w);
    if (h + y > j + 155){
    	//System.out.println("render" + args.get(0));
    	// do splitting stuff
    	this.fontRendererObj.setUnicodeFlag(true);
    	String p1 = (String) args.get(0);
    	
    	StringBuilder p2 = new StringBuilder();
    	int ii = p1.length() - 2;
    	//EFLog.fatal(p1 + "test + " + p2);
    	while (h + y > j + 155){
    		
    		p2.insert(0, p1.charAt(ii));
    		p1 = p1.substring(0, p1.length() - 1
    				);
    		ii--;
    		h = this.fontRendererObj.splitStringWidth((String) p1, w);
    	}
    		h = this.fontRendererObj.splitStringWidth((String) p1, w);
    		
    		if (flag == 0){
    			this.fontRendererObj.drawSplitString(p1, x, y, 93, 0x0000000);
    			this.fontRendererObj.setUnicodeFlag(false);
    			//GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glPopMatrix();
    			return h;
    		}
    		else {
    			String p2r = p2.substring(1, p2.length());
    			this.fontRendererObj.drawSplitString(p2r, x, y, 93, 0x0000000);
    			this.fontRendererObj.setUnicodeFlag(false);
    			//GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glPopMatrix();
    			return -h;
    		}
    	}
    else {
    	//System.out.println("render" + args.get(0));
    	this.fontRendererObj.drawSplitString((String) args.get(0), x, y, 93, 0x0000000);
    	this.fontRendererObj.setUnicodeFlag(false);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    	return h;
    }

}
public int drawElementImage(ArrayList<Object> args, int x, int y, int flag){
	int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    GL11.glPushMatrix();
    //System.out.println(y + 0 + ":" + j);
	if (y + (int)args.get(2) < j  + 155){
		ResourceLocation image = (ResourceLocation) args.get(0);
		int w = (int) args.get(1);
		int h = (int) args.get(2);
		int xx = (int) args.get(3);
		int yy = (int) args.get(4);
		this.mc.renderEngine.bindTexture(image);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4f(1f, 1f, 1f, 1f);
		this.drawTexturedModalRect(x, y, xx, yy, w, h);
		GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
		return h;
	}
	else {
		int h = (int) args.get(2);
		return h;
	}
	
}
public int drawElementFurnace(ArrayList<Object> args, int x, int y, int flag){
	int j1 = (this.height - CookBookGUI.achievementsPaneHeight) /2;
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
	if (args.size() > 1){
		return 1;
	}
	int x1 = x +20;
	int y1 = y + 50;
	this.fontRendererObj.setUnicodeFlag(false);
	this.mc.getTextureManager().bindTexture(GuiLib.CBfurnace);
	GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glDisable(GL11.GL_LIGHTING);	
    this.drawTexturedModalRect(x1 + 7, y1 - 40, 0, 0,  CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
    GL11.glEnable(GL11.GL_LIGHTING);	
    ItemStack[] items = ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString());
    for (ItemStack i : ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString())){	
    	if (items != null){
    		/* Items 0 is in
    		 * items 1 is out
    		 */
			if (items[0] != null){				
			    GL11.glDisable(GL11.GL_LIGHTING);					
				this.irender.renderItemIntoGUI(items[0], x1 + 16, y1 + 9);
				GL11.glEnable(GL11.GL_LIGHTING);			
			}
			if (items[9] != null){
			GL11.glDisable(GL11.GL_LIGHTING);
				this.irender.renderItemIntoGUI(items[9], x1 + 16, y1 - 33);
				this.irender.renderItemOverlayIntoGUI(this.fontRendererObj, items[9], x1 + 16, y1 - 33, null);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			GL11.glDisable(GL11.GL_LIGHTING);
				this.irender.renderItemIntoGUI(new ItemStack(Items.coal), x1 + 16, y1 + 49);
			GL11.glEnable(GL11.GL_LIGHTING);
    	}
    }
    return -150;
}
    public int drawElementOven(ArrayList<Object> args, int x, int y, int flag) {
        int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
        int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
        if (args.size() > 1) {
            return 1;
        }
        int x1 = x + 20;
        int y1 = y + 50;
        this.fontRendererObj.setUnicodeFlag(false);
        this.mc.getTextureManager().bindTexture(GuiLib.CBoven);
        //GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.drawTexturedModalRect(x1 - 25, y1 - 52, 0, 0, CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        ItemStack[] items = ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString());//(String) args.get(0).toString()
        for (ItemStack i : ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString())) {
            if (i != null) {
                /*Item 9 is outputBase, 0 is base itemI, 1 is base itemII,
                 *2 is optional item(pan), 4-8 are additives
                 */
            	
            	//Base Item
            	this.renderItem(this.conversioncheck(items[0]), x1 - 6, y1 + 73);
            	//Base Item II
            	this.renderItem(this.conversioncheck(items[1]), x1 + 9, y1 + 73);
            	//Pan Item
            	this.renderItem(this.conversioncheck(items[2]), x1+ 37, y1 + 73);
            	//Top-Left Item
            	this.renderItem(this.conversioncheck(items[3]), x1 - 18, y1 - 24);
            	//Top-Right Item
            	this.renderItem(this.conversioncheck(items[4]), x1 + 51, y1 - 23);
            	//Center Item
            	this.renderItem(this.conversioncheck(items[5]), x1 + 16, y1 - 45);
            	//Bottom-Left
            	this.renderItem(this.conversioncheck(items[6]), x1 - 18, y1 + 9);
            	//Bottom-Right
            	this.renderItem(this.conversioncheck(items[7]), x1 + 51, y1 + 9);
            	//Bottom
            	this.renderItem(this.conversioncheck(items[8]), x1 + 16, y1 + 32);
            	//Output
            	this.renderItem(this.conversioncheck(items[9]), x1 + 16, y1 - 7);


                GL11.glEnable(GL11.GL_LIGHTING);


            }
        }
        return -150;
    }
    
    private void renderItem(ItemStack i, int x, int y){
        if(i != null){
        	GL11.glDisable(GL11.GL_LIGHTING);
        	this.irender.renderItemIntoGUI(i, x, y);
        	this.irender.renderItemOverlayIntoGUI(fontRendererObj, i, x, y, null);
        	GL11.glEnable(GL11.GL_LIGHTING);
        }
    }
    private ItemStack conversioncheck(ItemStack i){
    	//EFLog.fatal(i);
    		if(i.getItem() == Item.getItemFromBlock(Blocks.carrots)){
    			return null;
    		}
    	return i;
    }
    
    public int drawElementCrafting(ArrayList<Object> args, int x, int y, int flag){
	int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
	//EFLog.fatal("y : " + y + " j1 : " + j1 + " check : " +(j1 +19));
	if (args.size() > 1){
		return 1;
	}
	int x1 = x + 20;
    int y1 = y + 50;
    this.fontRendererObj.setUnicodeFlag(false);
    this.mc.getTextureManager().bindTexture(GuiLib.CBcraftgrid);
    //GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    this.drawTexturedModalRect(x1 - 14, y1 - 51, 0, 0,  CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
	ItemStack[] items = ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString());
	for (ItemStack i : ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString())){
		if (i != null){
			
				/* Items 0-2 Render in top row
				 * Items 3-5 Render in middle row
				 * Items 6-8 Render in final row
				*/
		
				
			if (items[0] != null){				
		    GL11.glDisable(GL11.GL_LIGHTING);					
			this.irender.renderItemIntoGUI(items[0], x1 - 3, y1 + 1);
			GL11.glEnable(GL11.GL_LIGHTING);			
			}	
			if (items[1] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[1], x1 + 18, y1 + 1);
				GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[2] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[2], x1 + 40, y1 + 1);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[3] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[3], x1 - 3, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[4] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[4], x1 + 18, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[5] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[5], x1 + 40, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[6] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[6], x1 - 3, y1 + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[7] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[7], x1 + 18, y1 + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[8] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(items[8], x1 + 40, y1 + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			   //Itemstack 9 is the output slot
			if (items[9] != null){
			GL11.glDisable(GL11.GL_LIGHTING);
				this.irender.renderItemIntoGUI(items[9], x1 + 19, y1 - 44);
				this.irender.renderItemOverlayIntoGUI(this.fontRendererObj, items[9], x1 + 19, y1 - 44, null);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}

			GL11.glEnable(GL11.GL_LIGHTING);
		}
		

	}
	return -150;
}

public int drawElementHungerStats(ArrayList<Object> args, int x, int y, int flag){
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	if ((y > j1 + 19)){
		return 1;
	}
	else {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		this.mc.renderEngine.bindTexture(new ResourceLocation("extrafood:textures/gui/cookbookimages/BookIcons.png"));
		this.drawTexturedModalRect(x + 3, y + 30, 0, 0, 12, 24);
		this.drawTexturedModalRect(x + 3, y + 50, 12, 0, 12, 24);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();

        GL11.glDisable(GL11.GL_LIGHTING);
        FontRenderer fontr = this.fontRendererObj;
		fontr.setUnicodeFlag(true);
		fontr.drawStringWithShadow("Hunger Stats:", x + 19, y, 0x3333FF);
		if (args.size() > 2){
		fontr.setUnicodeFlag(false);
		fontr.drawString((String) args.get(2), x + 7, y + 15, 0x0000000);
		fontr.setUnicodeFlag(true);
		}
		fontr.drawString(String.valueOf(args.get(0)), x + 16 + 50, y + 32, 0x0000000);
		fontr.drawString(String.valueOf(args.get(1)), x + 16 + 50, y + 52, 0x0000000);
		fontr.setUnicodeFlag(false);
        GL11.glEnable(GL11.GL_LIGHTING);
		return -150;
	}
}

 public void actionPerformed(GuiButton button){
	if (button.id == 0){
		if(page < pagesAllowed){
		page+= 2;
		//if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page){
		this.pageTextLeft = StatCollector.translateToLocal(StatCollector.translateToLocal("cookbook." + pagen + page));
		}
		//else {
		//	page--;
		//}
	}
	if (button.id == 1){
		page-= 2;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page && page > 0){
		this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen + page);
		}
		else if (page <= 0){
			this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen);
			page = 0;
		}
	}	
	if (button.id == 2){
		this.fontRendererObj.setUnicodeFlag(false);
		this.mc.displayGuiScreen(new CookBookGUI());

	}

	}
 // Begin new render code
 // This will fuse both pages together by parsing strings and rendering stuff!
 // YAY!
 public List<CBElement> digestString(String in){
	 List<CBElement> instruct = new ArrayList<CBElement>();
	 boolean typetest = false;
	 String type = "";
	 
	 int argpos = 0;
	 
	 String currword = "";
	 
	 ArrayList<Object> typeargs = new ArrayList<Object>();
	 for (char star : in.toCharArray()){
		 //System.err.println(star);
		 if (star == '<'){
			 typetest = true;
			 //System.out.println("t" + currword);
			 continue;
		 }
		 if (star == '|' && typetest == true){
			 typetest = false;
			 //System.out.println("t" + currword);
			 if (this.types().contains(currword)){
				 //System.out.println(currword.trim());
				 type = currword;
				 currword = "";
			 }
			 
			 continue;
		 }
		 
		 else if (star == '|' && typetest == false){
			 //System.err.println("argpos (for dumudums): " + argpos);
			 switch (argpos){
			 case 0:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 1:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 2:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 3:
				 
				 if (type.equals( "TextBlock") || type.equals("Crafting") || type.equals("Furnace") || type.equals("Oven")){
					 typeargs.add(currword);
				 }
				 else if (type.equals("Image")){
					 typeargs.add(new ResourceLocation(currword));
				 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 case 4:
				 if (type.equals("Image")){
				 typeargs.add(Integer.parseInt(currword));
				 }
				 else {
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 
			 case 5:
				 if (type.equals("Image")){
					 typeargs.add(Integer.parseInt(currword));
					 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(currword);
				 } else if(type.equals("Oven")){
                     typeargs.add(currword);
                 }
				 break;
			 case 6:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 case 7:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 }
			 currword = "";
			 argpos += 1;
			 continue;
		 }
		 if (star == '>'){
			 
			 switch (argpos){
			 case 0:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 1:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 2:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 case 3:
				 
				 if (type.equals( "TextBlock") || type.equals("Crafting") || type.equals("Furnace") || type.equals("Oven")){
					 typeargs.add(currword);
				 }
				 else if (type.equals("Image")){
					 typeargs.add(new ResourceLocation(currword));
				 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 case 4:
				 if (type.equals("Image")){
				 typeargs.add(Integer.parseInt(currword));
				 }
				 else {
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 case 5:
				 if (type.equals("Image")){
					 typeargs.add(Integer.parseInt(currword));
					 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(currword);
				 }
				 break;
			 case 6:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 case 7:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 
			 }
			 currword = "";
			 argpos = 0;
			 instruct.add(this.packElement(type, typeargs));
			 typeargs = new ArrayList<Object>();
			 continue;
		 }
			 currword += star;
			 //System.out.println(currword);
			 continue;
		 
	
	 }
	 for (Object o : instruct){
		 //System.out.println(o);
	 }
	 return instruct;
 }
 public List<String> types(){
	 ArrayList<String> types = new ArrayList<String>();
	 // Put all valid thingies here
	 types.add("TextBlock");
	 types.add("Image");
	 types.add("Crafting");
	 types.add("HungerStats");
	 types.add("Furnace");
     types.add("Oven");
	 return types;
 }
 public Map<String, Integer> acount(){
	 HashMap<String, Integer> types = new HashMap<String, Integer>();
	 // Put all valid thingies here
	 types.put("TextBlock", 4);
	 types.put("Image", 8);
	 types.put("Crafting", 4);
	 types.put("HungerStats", 7);
	 types.put("Furnace", 4);
     types.put("Oven", 4);
	 return types;
 }
 
 public Method getFunctionForType(String type){
	 String mname = "drawElement" + type;
	 try {
		if (this.getClass().getMethod(mname, ArrayList.class, int.class, int.class, int.class) != null){
			 return this.getClass().getMethod(mname, ArrayList.class, int.class, int.class, int.class);
		 }
	} catch (NoSuchMethodException | SecurityException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	return null;
 }
 // The longest function we've made (Actually by me) Edition 3!
 public void drawold(){
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     //EFLog.fatal("fatality = " + j);
     // Attempt 2 :(
     // Define "cursor" position
     int renderpage = page;
     int xpos = i + 28;
     int ypos = j + 19;
     // Define current page we are rendering
     
     
     // Create pairs for everythin' (oh, and define the list of pairs)
     ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     ArrayList<ArrayList<Object>> page1 = new ArrayList<ArrayList<Object>>();
     if (this.page > p3){page1.addAll(p3r);p3r.clear();}
     ArrayList<ArrayList<Object>> page2 = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
  // Attempt to figure out what is NOT going to be rendered, and remove it from the list
     for (ArrayList<Object> pa : pairs){
    	 ArrayList<Object> pat = (ArrayList<Object>) ((ArrayList<Object>) pa.get(1)).clone();
    	 if (pat instanceof ArrayList){
    		 int page = (int) pat.get(2);
    		 if (page < this.page * 2){
    			 pairs.remove(pa);
    			 continue;
    		 }
    		 else if (page > (this.page + 1) * 2){
    			 pairs.remove(pa);
    			 continue; 
    		 }
    		 switch (page - (this.page * 2)){
    		 case 0:
    			 page1.add(pa);
    			 break;
    		 case 1:
    			 page2.add(pa);
    			 break;
    		 }
    	 }
     }
     for (ArrayList<Object> ptt : page1){
    	 ArrayList<Object> args = (ArrayList<Object>) ptt.get(1);
    	 int rval;
    	 String type = (String) ptt.get(0);
    	 try {
			rval = (int) this.getFunctionForType(type).invoke(this, args, xpos, ypos, (ptt.size() > 2 ? 1 : 0));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			rval = 0;
		}
    	 if (rval < 0){
    		 ypos += -rval;
    	 }
    	 else {
    		 ypos += rval;
    		 ArrayList<Object> ptata = (ArrayList<Object>) ptt.clone();
    		 ptata.add("f");
    		 page2.add(ptata);
    	 }
    	 if (ypos > j + 150){
    		 break;
    	 }
    	 
    	 
    	 
    	 
     }
     for (ArrayList<Object> ptta : page2){
    	 ArrayList<Object> args = (ArrayList<Object>) ptta.get(1);
    	 int rval;
    	 String type = (String) ptta.get(0);
    	 try {
			rval = (int) this.getFunctionForType(type).invoke(this, args, xpos, ypos, (ptta.size() > 2 ? 1 : 0));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			rval = 0;
		}
    	 if (rval < 0){
    		 ypos += -rval;
    	 }
    	 else {
    		 ypos += rval;
    		 p3 = this.page;
    		 p3r.add(ptta);
    	 }
    	 if (ypos > j + 150){
    		 break;
    	 }
     }
     
     
     
 }
 public void draw(){
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	 
	 
	 // Attempt to figure out what goes where, and map it out to a simple layout
	 ArrayList<CBElement> renderlist = new ArrayList<CBElement>();
	 for (CBElement prt : ris){
		 if (!this.checkPage(prt, page)){
			 continue;
		 }
		 renderlist.add(prt);
	 }
	 int page_1_x = i + 28;
	 int page_1_y = j + 19;
	 int page_2_x = i + 140;
	 int page_2_y = j + 19;
	 
	 
	 int render_at_x = 0;
	 
	 int render_at_y = 0;
	 boolean use_above = false;
	 
	 Method call_to_render;
	 
	 for (CBElement rendering : renderlist){
		 /* Step 1
		  * Figure out where to render
		  * the object by either using
		  * the provided co-ordinates
		  * or by using the variables
		  * set up top.
		  */
		 if (rendering.x == -1){
			 use_above = true;
		 }
		 else {
			 use_above = false;
		 }
		 
		 switch (rendering.page % 2){
		 case 0:
			 if (use_above == true){
				 render_at_x = page_1_x;
				 render_at_y = page_1_y;
			 }
			 else {
				 render_at_x = i + rendering.x;
				 render_at_y = j + rendering.y;
			 }
			 break;
		 case 1:
			 if (use_above == true){
				 render_at_x = page_2_x;
				 render_at_y = page_2_y;
			 }
			 else {
				 render_at_x = i + 140 + rendering.x;
				 render_at_y = j + rendering.y;
			 }
			 break;
		 }
		 /*
		  * Step 2
		  * Actually render the thing at given co-ords
		  * by calling the associated function. As dual-
		  * page stretching is now obsolete (due to many
		  * complications) flag is always 0.
		  */
		 call_to_render = this.getFunctionForType(rendering.type);
		 try {
			 int height_to_add = (int) call_to_render.invoke(this, rendering.args, render_at_x, render_at_y, 0);
			 if (height_to_add > 0){
				 switch (rendering.page % 2){
				 case 0:
					 page_1_y += height_to_add;
					 break;
				 case 1:
					 page_2_y += height_to_add;
				 }
				 
			 }
		 }
		 catch (Exception e){
			 
		 }
		 
	 }
	 
 }
 
 // All of these are helper functions,
 // dont use them.
 
 @SuppressWarnings("unchecked")
private CBElement packElement(String t, ArrayList<Object> argst){
	 CBElement ret = new CBElement();
	 ArrayList<Object> args = (ArrayList<Object>) argst.clone();
	 ret.type = t;
	 ret.x = (int) args.get(0);
	 ret.y = (int) args.get(1);
	 ret.page = (int) args.get(2);
	 args.remove(0);
	 args.remove(0);
	 args.remove(0);
	 ret.args = args;
	 return ret;
	 
 }
 
 private boolean checkPage(CBElement element, int page){
	 if (element.page == page || element.page == page+1){
		 return true;
	 }
	 else {
		 return false;
	 }
 }
 
 

 public void drawl(){
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     //EFLog.fatal("fatality = " + j);
     // Attempt 2 :(
     // Define "cursor" position
     int renderpage = page;
     int xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
     int ypos = j + 19;
     // Define current page we are rendering
     
     // Define function to be called
     Method drawFunc;
     // Define list of functions I need to call on next page
     ArrayList<Method> call = new ArrayList<Method>();
     // Arguments for those methods
     ArrayList<ArrayList<Object>> callargs = new ArrayList<ArrayList<Object>>();
     // Create pairs for everythin' (oh, and define the list of pairs)
     ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
     
     // Ok, now iterate over all of the pairs and render them based on stuff!
     for (ArrayList<Object> pair1 : pairs){
    	 // Get type
    	 //System.err.println("at pair thingie" + pair1);
    	 //EFLog.info("Here");
    	 String typename = (String) pair1.get(0);
    	 // Extract arguments
    	 ArrayList<Object> args = new ArrayList<Object>();
    	 args.addAll(((ArrayList<Object>) pair1.get(1)));
    	 drawFunc = this.getFunctionForType(typename);
    	 // Process the xpos and ypos, we might need to calculate them!
    	 if (!(((int)args.get(2) < ((this.page + 1) * 2)))){
    		 //System.out.println("breakin free!");
    		 continue;
    	 }
    	 
    	 int x = (int) args.get(0);
    	 
    	 
    	 int y = (int) args.get(1);
    	 int bx = x;
    	 int by = y;
    	 if (x == -1){
    		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 
    	 }
    	 else {
    		 x = xpos + x;
    	 }
    	 if (y == -1){
    		 y = ypos;
    	 }
    	 else {
    		 y = ypos + y;
    	 }
    	 // Remove the from the list of arguents (so I can pass them directly to the function)
    	 args.remove(0);
    	 args.remove(0);
    	 //EFLog.error("Here: xpos = " + x + "ypos = " + y);
    	 // Process pages
    	 if (((int)args.get(0) < renderpage || (int)args.get(0) > renderpage + 1)){
//    		 ArrayList<Object> ttargs = new ArrayList<Object>();
//    		 ttargs.add(bx);
//    		 ttargs.add(by);
//    		 ttargs.add(renderpage);
//    		 ttargs.add(args);
//    		 call.add(drawFunc);
//    		 callargs.add(ttargs);
    		 
    		 continue;
    		 
    	 }
    	 if ((int)args.get(0) != renderpage && (int)args.get(0) < this.page + 2){
    		 // Process page change
    		 renderpage++;
    		 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 //FMLLog.info("This is extrafood speaking, not fml. Anyways the data i eany is: " + xpos, xpos);
    	     ypos = j + 19;
    	     int i1 = 0;
    	     for (Method tocall : call){
    	    	 
    	    	 int tx;
    	    	 int ty;
    	    	 int pg;
    	    	 int rval;
    	    	 ArrayList<Object> unpack = callargs.get(i1);
    	    	 tx = (int) unpack.get(0);
    	    	 ty = (int) unpack.get(1);
    	    	 pg = (int) unpack.get(2);
    	    	 
    	    	 
    	    	 tx = xpos + tx;
    	    	 ty = ypos + ty;
    	    	 ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	    	// System.out.println("targ" + targs);
    	    	 try {
					rval = (int) tocall.invoke(this, targs, tx, ty, 1);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					rval = 0;
					
				}
    	    	 ypos += -rval;
    	    	 y += -rval;
    	    	 i1 += 1;
    	    	 
    	     }
    	     if (bx == -1){
        		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
        	 }
        	 else {
        		 x = xpos + x;
        	 }
        	 if (by == -1){
        		 y = ypos;
        	 }
        	 else {
        		 y = ypos + y;
        	 }
    		 
    	 }
    	 
    	 if (((int)args.get(0) < renderpage || (int)args.get(0) > renderpage + 1)){
//    		 ArrayList<Object> ttargs = new ArrayList<Object>();
//    		 ttargs.add(bx);
//    		 ttargs.add(by);
//    		 ttargs.add(renderpage);
//    		 ttargs.add(args);
//    		 call.add(drawFunc);
//    		 callargs.add(ttargs);
    		 
    		 continue;
    		 
    	 }
    	 args.remove(0);
    	 int rval;
    	 try {
    		//System.err.println("drawfunc is preparing to invoke STAND BY!!!");
			rval = (int) drawFunc.invoke(this, args, x, y, 0);
			//System.err.println("drawfunc has invoked sucessfully STAND BY!!!");
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			rval = 0;
		}
    	 if (rval > 0){
    		 ypos += rval;
    		 ArrayList<Object> ttargs = new ArrayList<Object>();
    		 ttargs.add(bx);
    		 ttargs.add(by);
    		 ttargs.add(renderpage);
    		 ttargs.add(args);
    		 call.add(drawFunc);
    		 callargs.add(ttargs);
    		 
    	 }
    	 else {
    		 ypos -= rval;
    	 }
    	 if (ypos > j + 155){
    		 ypos = j + 19;
    		 renderpage++;
    		 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 //FMLLog.info("This is extrafood speaking, not fml. Anyways the data i eany is: " + xpos, xpos);
    	     ypos = j + 19;
    	     int i1 = 0;
    	     for (Method tocall : call){
    	    	 
    	    	 int tx;
    	    	 int ty;
    	    	 int pg;

    	    	 ArrayList<Object> unpack = callargs.get(i1);
    	    	 tx = (int) unpack.get(0);
    	    	 ty = (int) unpack.get(1);
    	    	 pg = (int) unpack.get(2);
    	    	 tx = xpos + tx;
    	    	 ty = ypos + ty;
    	    	 ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	    	 //System.out.println("targ" + targs);
    	    	 try {
					rval = (int) tocall.invoke(this, targs, tx, ty, 1);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					rval = 0;
					
				}
    	    	 ypos += -rval;
    	    	 y += -rval;
    	    	 i1 += 1;
    	    	 
    	     }
    	     if (bx == -1){
        		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
        	 }
        	 else {
        		 x = xpos + x;
        	 }
        	 if (by == -1){
        		 y = ypos;
        	 }
        	 else {
        		 y = ypos + y;
        	 }
    		 
    	 }
    	
    	 }
    	 
     
     renderpage++;
	 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
     ypos = j + 19;
     int i1 = 0;
     if (renderpage - 1 % 2 == 0){
     for (Method tocall : call){
    	 
    	 int tx;
    	 int ty;
    	 int pg;
    	 int rval;
    	 ArrayList<Object> unpack = callargs.get(i1);
    	 tx = (int) unpack.get(0);
    	 ty = (int) unpack.get(1);
    	 pg = (int) unpack.get(2);
    	 tx = xpos + tx;
    	 ty = ypos + ty;
    	 ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	// System.out.println("targ" + targs);
    	 try {
			rval = (int) tocall.invoke(this, targs, tx, ty, 1);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			rval = 0;
			
		}
    	 ypos += -rval;
    	 i1 += 1;
     }}}
     
 
 public int moreThanOne(){
	 ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     int tp = 0;
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
     for (ArrayList<Object> apair : pairs){
    	 int page = (int) ((ArrayList<Object>)apair.get(1)).get(2);
    	 if (page > tp){
    		 tp = page;
    	 }
     }
     return tp;
 }
 @Override
 protected void keyTyped(char p_73869_1_, int p_73869_2_)
 {
     if (p_73869_2_ == 1)
     {
         this.fontRendererObj.setUnicodeFlag(false);
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
     }
 }
 @Override
 public boolean doesGuiPauseGame()
 {
     return false;
 }
}

