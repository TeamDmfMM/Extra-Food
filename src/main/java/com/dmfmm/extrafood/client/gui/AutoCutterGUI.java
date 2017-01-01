package com.dmfmm.extrafood.client.gui;

import com.dmfmm.extrafood.container.AutoCutterContainer;
import com.dmfmm.extrafood.library.GuiLib;
import com.dmfmm.extrafood.tileentities.AutoCutterTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.client.resources.I18n;

import org.lwjgl.opengl.GL11;




public class AutoCutterGUI extends GuiContainer {
    AutoCutterTileEntity te;
    public AutoCutterGUI (InventoryPlayer inventoryPlayer,
                          AutoCutterTileEntity tileEntity) {
        //the container is instanciated and passed to the superclass for handling
        super(new AutoCutterContainer(inventoryPlayer, tileEntity));
        te = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        //draw text and stuff here
        //the parameters for drawString are: string, x, y, color
        fontRendererObj.drawString(I18n.format("gui.AC"), 8, 6, 4210752);
        //draws "Inventory" or your regional equivalent
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        //draw your Gui here, only thing you need to change is the path
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(GuiLib.AUTO_CUTTER_GUI);
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
            this.drawTexturedModalRect(x + 116, y + 34, 176, 0, 10, (int) (this.te.complete * 5.6));
        }

    }

}