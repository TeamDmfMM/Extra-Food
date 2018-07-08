package com.dmfmm.extrafood.client.gui.buttons;

import com.dmfmm.extrafood.library.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Created by dmf444 on 3/14/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class MixerSquareButton extends GuiButton{

    private String text;
    private boolean isRed;

    public MixerSquareButton(int buttonId, int x, int y, String buttonText, boolean red) {
        super(buttonId, x, y, 27, 7, "");
        text = buttonText;
        isRed = red;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float d){
        //GlStateManager.pushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(GuiLib.JMgui);
        if(mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height){
            //EFLog.fatal("HELLO THERE!");
            if(isRed){
                GlStateManager.color(0.8f, 0f, 0f);
                this.drawTexturedModalRect(x, y, 28, 173, 27, 7);
            }else{
                GlStateManager.color(0f, 0.8f, 0.8f);
                this.drawTexturedModalRect(x, y, 28, 173, 27, 7);
            }
        } else{
            if(isRed){
                GlStateManager.color(0.8f, 0f, 0f);
                this.drawTexturedModalRect(x, y, 0, 173, 27, 7);
            }else {
                GlStateManager.color(0f, 0.8f, 0.8f);
                this.drawTexturedModalRect(x, y, 0, 173, 27, 7);
            }
        }
        //GlStateManager.popMatrix();
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        fontRenderer.setUnicodeFlag(true);
        fontRenderer.drawString(text, (x + width/2) - (fontRenderer.getStringWidth(text)/2) + 1, y-1, 0);
        fontRenderer.setUnicodeFlag(false);

    }

    @Override
    public void playPressSound(SoundHandler soundHandlerIn)
    {
        //soundHandlerIn.playSound(PositionedSoundRecord.create(new ResourceLocation("starvationahoy:pageFlip"), 1.0F));
    }
}