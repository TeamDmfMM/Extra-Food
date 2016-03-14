package dmf444.ExtraFood.Common.blocks.guis.Buttons;

import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by dmf444 on 3/13/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class MixerReleaseButton extends GuiButton{


    public MixerReleaseButton(int buttonId, int x, int y) {
        super(buttonId, x, y, 6, 6, "");
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY){
        if(mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height){
            //EFLog.fatal("HELLO THERE!");
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.JMgui);
            GlStateManager.color(1f, 1f, 1.0f);
            this.drawTexturedModalRect(xPosition, yPosition, 6, 166, 6, 6);
            GlStateManager.popMatrix();
        } else{
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.JMgui);
            GlStateManager.color(1f, 1f, 1.0f);
            this.drawTexturedModalRect(xPosition, yPosition, 0, 166, 6, 6);
            GlStateManager.popMatrix();
        }

    }

    public void playPressSound(SoundHandler soundHandlerIn)
    {
        //soundHandlerIn.playSound(PositionedSoundRecord.create(new ResourceLocation("starvationahoy:pageFlip"), 1.0F));
    }

}
