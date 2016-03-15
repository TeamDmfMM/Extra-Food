package dmf444.ExtraFood.Common.blocks.guis;

import dmf444.ExtraFood.Common.blocks.container.JuiceMixerContainer;
import dmf444.ExtraFood.Common.blocks.guis.Buttons.MixerReleaseButton;
import dmf444.ExtraFood.Common.blocks.guis.Buttons.MixerSquareButton;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.Packets.ChannelHandler;
import dmf444.ExtraFood.Core.Packets.juicemixer.PacketMakeDestroy;
import dmf444.ExtraFood.Core.Packets.juicemixer.PacketReleaseFluid;
import dmf444.ExtraFood.Core.Packets.juicemixer.PacketSelector;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class GuiJuiceMixer extends GuiContainer {

    JuiceMixerTileEntity te;

    public GuiJuiceMixer(InventoryPlayer inventoryPlayer, JuiceMixerTileEntity tileEntity) {
        super(new JuiceMixerContainer(inventoryPlayer, tileEntity));

        this.te = tileEntity;

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        switch (button.id) {
            case 0:
            case 1:
            case 2:
                JuiceMixerTileEntity.SelectedTank selectedTank = JuiceMixerTileEntity.SelectedTank.fromInt(button.id);
                ChannelHandler.EFchannel.sendToServer(new PacketReleaseFluid(selectedTank, te.getPos()));
                te.handleClickingRelease(button.id);
                break;
            case 3:
            case 4:
                ChannelHandler.EFchannel.sendToServer(new PacketMakeDestroy(button.id - 3, te.getPos()));
                te.handleMakeDestroy(button.id - 3);
                break;
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButtons();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.drawBkgd();

        this.drawFluids();
        this.drawFluidOverlay();
        this.drawSelector();

        for (int i = 0; i < this.buttonList.size(); ++i)
        {
            ((GuiButton)this.buttonList.get(i)).drawButton(this.mc, mouseX, mouseY);
        }

        this.handleTooltips(mouseX, mouseY);
    }

    private void drawSelector() {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        int lx = 0;
        switch (te.selected){
            case LEFT:
                lx = 6;//6
                break;
            case MIDDLE:
                lx = 31;
                break;
            case RIGHT:
                lx = 56;
                break;
            default:
                lx = 6;
        }
        this.mc.renderEngine.bindTexture(GuiLib.JMgui);
        this.drawTexturedModalRect(x+lx, y+5, 177, 0, 20, 64);
    }

    private void drawFluidOverlay() {
        this.mc.renderEngine.bindTexture(GuiLib.JMgui);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x+8, y+12, 217, 0, 16, 49);
        this.drawTexturedModalRect(x+33, y+12, 217, 0, 16, 49);
        this.drawTexturedModalRect(x+58, y+12, 217, 0, 16, 49);
        this.drawTexturedModalRect(x+101, y+41, 199, 0, 16, 22);
    }

    private void handleTooltips(int mouseX, int mouseY) {
        if (isPointInRegion(7, 6, 18, 62, mouseX, mouseY)) {
            FluidTank theFluidTank = te.input1;
            if (theFluidTank.getFluid() == null) {
                drawHoveringText(Arrays.asList(EnumChatFormatting.GREEN + "Empty"), mouseX, mouseY);
            }
            else {
                drawHoveringText(Arrays.asList("Contents:", EnumChatFormatting.GREEN +theFluidTank.getFluid().getFluid().getLocalizedName(theFluidTank.getFluid()) + ": " + EnumChatFormatting.RED + theFluidTank.getFluidAmount() + EnumChatFormatting.WHITE + "mB"), mouseX, mouseY);
            }
        }
        else if (isPointInRegion(32, 6, 18, 62, mouseX, mouseY)) {
            FluidTank theFluidTank = te.input2;
            if (theFluidTank.getFluid() == null) {
                drawHoveringText(Arrays.asList(EnumChatFormatting.GREEN + "Empty"), mouseX, mouseY);
            }
            else {
                drawHoveringText(Arrays.asList("Contents:", EnumChatFormatting.GREEN +theFluidTank.getFluid().getFluid().getLocalizedName(theFluidTank.getFluid()) + ": " + EnumChatFormatting.RED + theFluidTank.getFluidAmount() + EnumChatFormatting.WHITE + "mB"), mouseX, mouseY);
            }
        }
        else if (isPointInRegion(57, 6, 18, 62, mouseX, mouseY)) {
            FluidTank theFluidTank = te.input3;
            if (theFluidTank.getFluid() == null) {
                drawHoveringText(Arrays.asList(EnumChatFormatting.GREEN + "Empty"), mouseX, mouseY);
            }
            else {
                drawHoveringText(Arrays.asList("Contents:", EnumChatFormatting.GREEN +theFluidTank.getFluid().getFluid().getLocalizedName(theFluidTank.getFluid()) + ": " + EnumChatFormatting.RED + theFluidTank.getFluidAmount() + EnumChatFormatting.WHITE + "mB"), mouseX, mouseY);
            }
        }
        else if (isPointInRegion(101, 37, 16, 30, mouseX, mouseY)){
            if (te.outputState.size() == 0) {
                drawHoveringText(Arrays.asList(EnumChatFormatting.GREEN + "Empty"), mouseX, mouseY);
            }
            else {
                ArrayList<String> strings = new ArrayList<>(Arrays.asList("Contents:"));
                for (FluidStack fluidStack : te.outputState) {
                    strings.add(EnumChatFormatting.GREEN + fluidStack.getFluid().getLocalizedName(fluidStack) + ": " + EnumChatFormatting.RED + fluidStack.amount + EnumChatFormatting.WHITE + "mB");
                }
                drawHoveringText(strings, mouseX, mouseY);
            }
        }
    }

    private void drawFluids () {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawFluid(te.input1, x + 8, y + 7, 16, 60);
        drawFluid(te.input2, x + 8 + 25, y + 7, 16, 60);
        drawFluid(te.input3, x + 8 + 50, y + 7, 16, 60);
        // 16, 30 wh: 101 37 xy
        int offset = 0;
        for (FluidStack fluidStack : te.outputState) {
            offset += drawFluid(fluidStack, 6000, x + 101, y + 37, 16, 30, offset);

        }
    }
    private int drawFluid(FluidTank fluidTank, int x, int y, int w, int h) {
        if (fluidTank.getFluid() == null) {
            return -1;
        }
        TextureAtlasSprite tas = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluidTank.getFluid().getFluid().getStill().toString());
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        int height = (int)(((float)h / fluidTank.getCapacity()) * fluidTank.getFluid().amount);
        int full = height / 16;
        int semi = height % 16;
        y += h;
        for (int i = 0; i < full; i++) {
            y -= 16;
            drawTexturedModalRect(x, y, tas, w, 16);
        }
        y -= semi;
        drawTexturedModalRect(x, y, tas, w, semi);
        return (16 * full) + semi;
    }

    private int drawFluid(FluidStack fluidTank, int cap, int x, int y, int w, int h, int yOffset) {
        if (fluidTank == null) {
            return -1;
        }
        TextureAtlasSprite tas = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluidTank.getFluid().getStill().toString());
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        int height = (int)(((float)h / cap) * fluidTank.amount);
        int full = height / 16;
        int semi = height % 16;
        y += (h - yOffset);
        for (int i = 0; i < full; i++) {
            y -= 16;
            drawTexturedModalRect(x, y, tas, w, 16);
        }
        y -= semi;
        drawTexturedModalRect(x, y, tas, w, semi);
        return (16 * full) + semi;
    }

    private void addButtons() {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.buttonList.add(new MixerReleaseButton(0, x + 13, y + 71));
        this.buttonList.add(new MixerReleaseButton(1, x + 13 + 25, y + 71));
        this.buttonList.add(new MixerReleaseButton(2, x + 13 + 50, y + 71));
        this.buttonList.add(new MixerSquareButton(3, x+121, y+58, "MAKE", false));
        this.buttonList.add(new MixerSquareButton(4, x+121, y+68, "DELETE", true));
    }

    private void drawBkgd() {
        this.mc.renderEngine.bindTexture(GuiLib.JMgui);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

    }

    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        if(isPointInRegion(7, 6, 18, 62, mouseX, mouseY)){
            //Tank 1
            EFLog.error("Clicked on tank 1");
            ChannelHandler.EFchannel.sendToServer(new PacketSelector(JuiceMixerTileEntity.SelectedTank.LEFT, te.getPos()));
            te.changeSelected(JuiceMixerTileEntity.SelectedTank.LEFT);
        }else if(isPointInRegion(32, 6, 18, 62, mouseX, mouseY)){
            //Tank 2
            EFLog.error("Clicked on tank 2");
            ChannelHandler.EFchannel.sendToServer(new PacketSelector(JuiceMixerTileEntity.SelectedTank.MIDDLE, te.getPos()));
            te.changeSelected(JuiceMixerTileEntity.SelectedTank.MIDDLE);
        }else if(isPointInRegion(57, 6, 18, 62, mouseX, mouseY)){
            //Tank 3
            EFLog.fatal("Clicked on tank 3");
            ChannelHandler.EFchannel.sendToServer(new PacketSelector(JuiceMixerTileEntity.SelectedTank.RIGHT, te.getPos()));
            te.changeSelected(JuiceMixerTileEntity.SelectedTank.RIGHT);
        }
        super.mouseReleased(mouseX, mouseY, state);
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        fontRendererObj.drawString(StatCollector.translateToLocal("gui.JM"), 135, 6, 4210752);
    }
}
