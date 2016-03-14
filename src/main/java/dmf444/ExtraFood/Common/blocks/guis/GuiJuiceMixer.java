package dmf444.ExtraFood.Common.blocks.guis;

import dmf444.ExtraFood.Common.blocks.container.JuiceMixerContainer;
import dmf444.ExtraFood.Common.blocks.guis.Buttons.MixerReleaseButton;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.Packets.ChannelHandler;
import dmf444.ExtraFood.Core.Packets.PacketSelector;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

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

    private void drawFluids() {
    }

    private void addButtons() {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.buttonList.add(new MixerReleaseButton(0, x + 12, y + 71));
        this.buttonList.add(new MixerReleaseButton(1, x + 12 + 25, y + 71));
        this.buttonList.add(new MixerReleaseButton(2, x + 12 + 50, y + 71));
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
