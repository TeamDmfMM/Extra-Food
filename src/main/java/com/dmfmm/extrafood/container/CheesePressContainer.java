package com.dmfmm.extrafood.container;


import com.dmfmm.extrafood.container.Slot.SlotCheesePressOutput;
import com.dmfmm.extrafood.container.Slot.SlotFilter;
import com.dmfmm.extrafood.tileentities.CheesePressTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CheesePressContainer extends Container {

    protected CheesePressTileEntity tileEntity;
    private int localTime;
    public static int INPUT_1 = 0, INPUT_2 = 1, INPUT_3 = 2, OUTPUT = 3;

    public CheesePressContainer (InventoryPlayer inventoryPlayer, CheesePressTileEntity te){
        tileEntity = te;

        //the Slot constructor takes the IInventory and the slot number in that it binds to
        //and the x-y coordinates it resides on-screen
        this.addSlotToContainer(new SlotFilter(te, INPUT_1, 54, 20, Items.MILK_BUCKET));
        this.addSlotToContainer(new SlotFilter(te, INPUT_2, 78, 20, Items.MILK_BUCKET));
        this.addSlotToContainer(new SlotFilter(te, INPUT_3, 102, 20, Items.MILK_BUCKET));
        this.addSlotToContainer(new SlotCheesePressOutput(te, OUTPUT, 78, 54));

        //commonly used vanilla code that adds the player's inventory
        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendProgressBarUpdate(this, 0, this.tileEntity.complete);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icrafting = (IContainerListener) this.listeners.get(i);

            if (this.localTime != this.tileEntity.getTotalTime())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.getTotalTime());
            }
        }

        this.localTime = this.tileEntity.getTotalTime();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int arg1, int arg2)
    {
        if (arg1 == 0)
        {
            this.tileEntity.ResetTiming(arg2);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUsableByPlayer(player);
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
    public ItemStack transferStackInSlot(EntityPlayer player, int slotty) {
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotty);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstackR = slot.getStack();
            stack = itemstackR.copy();

            // If itemstack is in Output stack
            if (slotty == OUTPUT)
            {
                // try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
                // so the last slot in the inventory won't get checked if you don't add 1
                if (!this.mergeItemStack(itemstackR, OUTPUT+1, OUTPUT+36+1, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstackR, stack);
            }
            // itemstack is in player inventory, try to place in appropriate furnace slot
            else if (slotty != INPUT_3 && slotty != INPUT_1 && slotty != INPUT_2)
            {
                // if it can be smelted, place in the input slots

                // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
                if (!this.mergeItemStack(itemstackR, INPUT_1, INPUT_3+1, false))
                {
                    return null;
                }
            }

            // item in player's inventory, but not in action bar
            else if (slotty >= OUTPUT+1 && slotty < OUTPUT+28)
            {
                // place in action bar
                if (!this.mergeItemStack(itemstackR, OUTPUT+28, OUTPUT+37, false))
                {
                    return null;
                }
            }
            // item in action bar - place in player inventory
            else if (slotty >= OUTPUT+28 && slotty < OUTPUT+37 && !this.mergeItemStack(itemstackR, OUTPUT+1, OUTPUT+28, false))
            {
                {
                    return null;
                }
            }
            // In one of the infuser slots; try to place in player inventory / action bar
            else if (!this.mergeItemStack(itemstackR, OUTPUT+1, OUTPUT+37, false))
            {
                return null;
            }

            if (itemstackR == ItemStack.EMPTY)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstackR.getCount() == stack.getCount())
            {
                return null;
            }

            slot.onTake(player, itemstackR);
        }
        return stack;
    }
}