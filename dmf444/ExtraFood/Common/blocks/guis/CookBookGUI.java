package dmf444.ExtraFood.Common.blocks.guis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.AchievementPage;
import dmf444.ExtraFood.Common.RecipeHandler.CookbookButtonLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class CookBookGUI extends GuiScreen {
	   private static int minDisplayColumn;
	    private static int minDisplayRow;
	    private static int maxDisplayColumn;
	    private static int maxDisplayRow;
	   
	    //mincrmatt12 movin' vars
	    private int px;
	    private int py;
	    private int x;
	    
	    private int y;

	    private int iox;
	    private int yox;
	    
	    //mincrmatt12 button vars
	    private ArrayList<ClickTab> buttons;
	    
    /** The top x coordinate of the achievement map */
    private static final int guiMapTop = minDisplayColumn * 24 - 112;

    /** The left y coordinate of the achievement map */
    private static final int guiMapLeft = minDisplayRow * 24 - 112;

    /** The bottom x coordinate of the achievement map */
    private static final int guiMapBottom = maxDisplayColumn * 24 - 77;

    /** The right y coordinate of the achievement map */
    private static final int guiMapRight = maxDisplayRow * 24 - 77;
    ResourceLocation r = new ResourceLocation("extrafood", "textures/gui/cookbookgui.png");
    ResourceLocation back = new ResourceLocation("extrafood", "textures/gui/cookbook_background1.png");
    protected static int achievementsPaneWidth = 256;
    protected static int achievementsPaneHeight = 202;
    
    private int isMouseButtonDown;
    /** The x position of the achievement map */
    protected double guiMapX;

    /** The y position of the achievement map */
    protected double guiMapY;
    protected double field_74124_q;
    protected double field_74123_r;
    
    /** The current mouse x coordinate */
    protected int mouseX;

    /** The current mouse y coordinate */
    protected int mouseY;
    protected double field_74117_m;
    protected double field_74115_n;
    
    public static final int GUI_ID = 10;
    
   public static CookBookGUI currentOpenBook = new CookBookGUI();
   //public static CookbookButtonLoader bookButton = new CookbookButtonLoader();

   public CookBookGUI() {
	  // System.out.println("HERE");
	   this.buttons = CookbookButtonLoader.bookButton.buttons;


   }

	

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	{
            if (Mouse.isButtonDown(0))
            {
    			iox += -Mouse.getDX();
    			yox += Mouse.getDY();
    			if (iox < 0){
    				iox = 0;
    			}
    			if (yox < 0){
    				yox = 0;
    			}
    			if (iox > 150){
    				iox = 150; //350
    			}
    			if (yox > 550){
    				yox = 550;
    			}
    	

    			//System.out.println(iox + " " + yox);

            }
            else
            {
                this.isMouseButtonDown = 0;
            }
            
            this.drawDefaultBackground();
            this.genDasBookBackground(par1, par2, par3);            
            this.drawTitle();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
    	}


    }
    protected void drawTitle()
    {
		String mainGUI = StatCollector.translateToLocal("cookbook.Title");
        int i = (this.width - this.achievementsPaneWidth) / 2;
        int j = (this.height - this.achievementsPaneHeight) / 2;
        GL11.glDisable(GL11.GL_LIGHTING);
        this.fontRenderer.drawString(mainGUI, i + 6, j + 5, 0xFFFFFFFF); //i + 15 original
        GL11.glEnable(GL11.GL_LIGHTING);
    }
    
    
    protected void genDasBookBackground(int par1, int par2, float par3)
    {
        int k = MathHelper.floor_double(this.field_74117_m + (this.guiMapX - this.field_74117_m) * (double)par3);
        int l = MathHelper.floor_double(this.field_74115_n + (this.guiMapY - this.field_74115_n) * (double)par3);

        if (k < guiMapTop)
        {
            k = guiMapTop;
        }

        if (l < guiMapLeft)
        {
            l = guiMapLeft;
        }

        if (k >= guiMapBottom)
        {
            k = guiMapBottom - 1;
        }

        if (l >= guiMapRight)
        {
            l = guiMapRight - 1;
        }

        int i1 = (this.width - this.achievementsPaneWidth) / 2;
        int j1 = (this.height - this.achievementsPaneHeight) / 2;
        int k1 = i1 + 16;
        int l1 = j1 + 17;
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_GEQUAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        int i2 = k + 288 >> 4;
        int j2 = l + 288 >> 4;
        int k2 = (k + 288) % 16;
        int l2 = (l + 288) % 16;
        Random random = new Random();
        int i3 = 0;
        int j3;
        int k3 = 0;


        float f1 = 0.6F - (float)(j2 + i3) / 25.0F * 0.3F;
        GL11.glColor4f(f1, f1, f1, 1.0F);


        this.mc.getTextureManager().bindTexture(back);
        this.drawTexturedModalRect(i1 + 2, j1 + 2, iox, yox, this.achievementsPaneWidth - 2, this.achievementsPaneHeight - 4);
       // GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
      
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(r);
        this.drawTexturedModalRect(i1, j1, 0, 0, this.achievementsPaneWidth, this.achievementsPaneHeight);
        GL11.glPopMatrix();
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        for (ClickTab tab : buttons){
        	if (tab.x * 22 > iox && tab.x * 22 < this.achievementsPaneWidth - 2 + iox){
        		if (tab.y * 22 > yox && tab.y * 22 < this.achievementsPaneHeight - 2 + yox){
        			tab.xPosition = i1 + 2 + (tab.x * 22) + -iox;
        			tab.yPosition = j1 + 2 + (tab.y * 22) + -yox;
        			tab.drawButton(mc, 0, 0);
        		}
        	}
        }
        super.drawScreen(par1, par2, par3);
    }

    
    public boolean doesGuiPauseGame()
    {
        return false;
    }    
    protected void mouseMovedOrUp(int par1, int par2, int par3){
    	super.mouseMovedOrUp(par1, par2, par3);
    	if (par3 == -1){
    		if (Mouse.isButtonDown(0)){
    			int dx = par1 - x;
    			int dy = par2 - y;
    			px = x;
    			py = y;
    			x = par1;
    			y = par2;
    			iox += dx;
    			yox += dy;
    			if (iox < 0){
    				iox = 0;
    			}
    			if (yox < 0){
    				yox = 0;
    			}
    			//System.out.println(iox + " " + yox);	
    		}
    	}
    }
    protected void mouseClicked(int par1, int par2, int par3){
    	for (ClickTab tab : buttons){
        	if (tab.x * 22 > iox && tab.x * 22 < this.achievementsPaneWidth - 2 + iox){
        		if (tab.y * 22 > yox && tab.y * 22 < this.achievementsPaneHeight - 2 + yox){
        			if (tab.mousePressed(mc, par1, par2)){
        				this.mc.displayGuiScreen(new CRPageGUI(tab.pagename));
        			}
        		}
        	}	
    	}
    }
    
    private void plotCurve(double startX, double startY, int bezierX, int bezierY, double endX, double endY){
    	for(double t=0.0;t<=1;t+=0.01)  
    	{  
    	    int x = (int) (  (1-t)*(1-t)*startX + 2*(1-t)*t*bezierX+t*t*endX);  
    	    int y = (int) (  (1-t)*(1-t)*startY + 2*(1-t)*t*bezierY+t*t*endY);  
    	  
    	    //plot something @  x,y coordinate here...  
    	    this.drawRect(x, y, x + 1, y + 1, 0xFFFFFFF);
    	}
    }
        
    private int cosineint(int x, int y, int z){
    	double w = (1-Math.cos(z*Math.PI))/2;
    	return (int) (x*(1-w)+y*w);
    	
    }
    


}
