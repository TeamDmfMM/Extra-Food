package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class ButtonBackGUI extends GuiButton
{
    /**
     * True for pointing right (next page), false for pointing left (previous page).
     */
    private final boolean nextPage;
    private static final ResourceLocation arrowsGUI = new ResourceLocation("extrafood", "textures/gui/ArrowsBF.png");

    public ButtonBackGUI(int par1, int par2, int par3, boolean par4)
    {
        super(par1, par2, par3, 23, 13, "");
        this.nextPage = par4;
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            boolean flag = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            par1Minecraft.getTextureManager().bindTexture(arrowsGUI);
            int k = 0;
            int l = 176;
            if (flag)
            {
                k += 23;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 16);
        }
    }
}
