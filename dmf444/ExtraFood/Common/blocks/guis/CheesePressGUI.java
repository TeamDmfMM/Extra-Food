package dmf444.ExtraFood.Common.blocks.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import dmf444.ExtraFood.Common.blocks.container.CheesePressContainer;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;

public class CheesePressGUI extends GuiContainer {
CheesePressTileEntity te;
    public CheesePressGUI (InventoryPlayer inventoryPlayer,
                    CheesePressTileEntity tileEntity) {
            //the container is instanciated and passed to the superclass for handling
            super(new CheesePressContainer(inventoryPlayer, tileEntity));
            te = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRenderer.drawString("Cheese Press", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                    int par3) {
            //draw your Gui here, only thing you need to change is the path
    	ResourceLocation r = new ResourceLocation("extrafood", "textures/gui/cheese_press.png");
    	GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    		this.mc.renderEngine.bindTexture(r);            
    		int x = (width - xSize) / 2;
    		int y = (height - ySize) / 2;
    		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    		// This is where you can draw the arrow-thingy
    		// this.drawTexturedModalRect(renderx, rendery, positionx, positiony, sizetodraww, sizetodrawh)
    		/*
    		so:
    		renderx and y : where to draw
    		positionx and y : where in the image to start drawing
    		sizetodraww and h : how large to draw
    		*/
    		// Example: this.drawTexturedModalRect(100, 100, 256, 0, 50, 10, 50, this.tileentity.charge)
    		if (te.complete > 0){
    			this.drawTexturedModalRect(x + 133, y + 31, 176, 1, 3, this.te.complete);
    		}

    }
    
}
