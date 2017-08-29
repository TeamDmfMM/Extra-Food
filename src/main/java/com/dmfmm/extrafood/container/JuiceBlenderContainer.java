package com.dmfmm.extrafood.container;


import com.dmfmm.extrafood.container.Slot.SlotFilter;
import com.dmfmm.extrafood.crafting.JuiceRegistry;
import com.dmfmm.extrafood.network.ChannelHandler;
import com.dmfmm.extrafood.network.packets.PacketJBTank;
import com.dmfmm.extrafood.tileentities.JuiceBlenderTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class JuiceBlenderContainer extends Container{


    JuiceBlenderTileEntity tileEntity;
    EntityPlayerMP player;


    public static int INPUT_1 = 0, INPUT_2 = 1, OUTPUT_1 = 2;


    public JuiceBlenderContainer(InventoryPlayer inventoryPlayer, JuiceBlenderTileEntity te){
        this.addSlotToContainer(new SlotFilter(te, INPUT_1, 80, 20, JuiceRegistry.instance.getValidItems()));
        this.addSlotToContainer(new Slot(te, INPUT_2, 126, 12));
        this.addSlotToContainer(new Slot(te, OUTPUT_1, 126, 34));
        this.tileEntity = te;


        this.bindPlayerInventory(inventoryPlayer);

    }
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }


    @Override
    public boolean canInteractWith(EntityPlayer theplayer) {
        return true;
    }


    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        //EFLog.fatal("MONONINOMA");
        for (int i = 0; i < this.listeners.size(); ++i){
            if (listeners.get(i) instanceof EntityPlayerMP){
                if (tileEntity.tank.getFluid() != null){
                    ChannelHandler.EFchannel.sendToAllAround(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()), new NetworkRegistry.TargetPoint(tileEntity.getWorld().provider.getDimension(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), 10));
                    //ExtraFood.JBTanknet.sendTo(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()), (EntityPlayerMP) crafters.get(i));
                }
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotty){
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotty);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstackR = slot.getStack();
            stack = itemstackR.copy();

            // If itemstack is in Output stack
            if (slotty == OUTPUT_1){
                // try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
                // so the last slot in the inventory won't get checked if you don't add 1
                if (!this.mergeItemStack(itemstackR, OUTPUT_1 +1, OUTPUT_1 +36+1, true)) {
                    return null;
                }
                slot.onSlotChange(itemstackR, stack);

            } else if (slotty != INPUT_1 && slotty != INPUT_2) {
                // itemstack is in player inventory, try to place in appropriate furnace slot
                // if it can be smelted, place in the input slots
                // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
                if (!this.mergeItemStack(itemstackR, INPUT_1, INPUT_2+1, true)) {
                    return null;
                }
         				/*if(!this.mergeItemStack(itemstackR, INPUT_2, INPUT_2+1, false)){
         					return null;
         				}*/
            } else if (slotty >= OUTPUT_1 +1 && slotty < OUTPUT_1 +28) {
                // item in player's inventory, but not in action bar
                // place in action bar
                if (!this.mergeItemStack(itemstackR, OUTPUT_1 +28, OUTPUT_1 +37, false)) {
                    return null;
                }
            } else if (slotty >= OUTPUT_1+28 && slotty < OUTPUT_1+37 && !this.mergeItemStack(itemstackR, OUTPUT_1+1, OUTPUT_1+28, false)){
                // item in action bar - place in player inventory
                return null;
            } else if (!this.mergeItemStack(itemstackR, OUTPUT_1+1, OUTPUT_1+37, false)){
                // In one of the infuser slots; try to place in player inventory / action bar
                return null;
            }


            if (itemstackR.getCount() == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstackR.getCount() == stack.getCount()) {
                return null;
            }
            slot.onTake(player, itemstackR);
        }
        return stack;
    }
}
