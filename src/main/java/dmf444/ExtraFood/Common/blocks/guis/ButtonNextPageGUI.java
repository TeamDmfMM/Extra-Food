package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Core.lib.GuiLib;

public class ButtonNextPageGUI extends GuiButton
{
    /**
     * True for pointing right (next page), false for pointing left (previous page).
     */
    private final boolean nextPage;


    public ButtonNextPageGUI(int par1, int par2, int par3, boolean par4)
    {
        super(par1, par2, par3, 23, 13, "");
        this.nextPage = par4;
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.visible)
        {
            boolean flag = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            GL11.glPushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            par1Minecraft.getTextureManager().bindTexture(GuiLib.arrowsGUI);
            int k = 0;
            int l = 192;

            if (flag)
            {
                k += 23;
            }

            if (!this.nextPage)
            {
                l += 13;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}

