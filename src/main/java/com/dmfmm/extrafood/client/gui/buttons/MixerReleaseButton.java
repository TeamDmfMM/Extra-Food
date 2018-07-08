package com.dmfmm.extrafood.client.gui.buttons;


import com.dmfmm.extrafood.library.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;


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
        if(mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height){
            //EFLog.fatal("HELLO THERE!");
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.JMgui);
            GlStateManager.color(1f, 1f, 1.0f);
            this.drawTexturedModalRect(x, y, 6, 166, 6, 6);
            GlStateManager.popMatrix();
        } else{
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.JMgui);
            GlStateManager.color(1f, 1f, 1.0f);
            this.drawTexturedModalRect(x, y, 0, 166, 6, 6);
            GlStateManager.popMatrix();
        }

    }

    public void playPressSound(SoundHandler soundHandlerIn)
    {
        //soundHandlerIn.playSound(PositionedSoundRecord.create(new ResourceLocation("starvationahoy:pageFlip"), 1.0F));
    }

}