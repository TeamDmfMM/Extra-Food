package dmf444.ExtraFood.Common.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;

public class CheesePressContainer extends Container {

    protected CheesePressTileEntity tileEntity;
    public static int INPUT_1 = 0, INPUT_2 = 1, INPUT_3 = 2, OUTPUT = 3;

    public CheesePressContainer (InventoryPlayer inventoryPlayer, CheesePressTileEntity te){
            tileEntity = te;

            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen
            this.addSlotToContainer(new SlotFilter(te, INPUT_1, 54, 20, Items.milk_bucket));
            this.addSlotToContainer(new SlotFilter(te, INPUT_2, 78, 20, Items.milk_bucket));
            this.addSlotToContainer(new SlotFilter(te, INPUT_3, 102, 20, Items.milk_bucket));
            this.addSlotToContainer(new SlotCheesePressOutput(te, OUTPUT, 78, 54));

            //commonly used vanilla code that adds the player's inventory
            bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
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

            				if (itemstackR.stackSize == 0)
            				{
            					slot.putStack((ItemStack)null);
            				}
            				else
            				{
            					slot.onSlotChanged();
            				}

            				if (itemstackR.stackSize == stack.stackSize)
            				{
            					return null;
            				}

            		slot.onPickupFromSlot(player, itemstackR);
            		}
         return stack;
    }
}