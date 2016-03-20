package dmf444.ExtraFood.Common.blocks.container;


import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerOven extends Container {

	
	TileEntityOven tileEntity;
	private int BarTimeLeft;
	public static int INPUT_1 = 0, INPUT_2 = 1, INPUT_3 = 2, INPUT_4 = 3, INPUT_5 = 4, OUTPUT = 5; 
	
	
	public ContainerOven(InventoryPlayer player, TileEntityOven te) {
		// TODO Auto-generated constructor stub
		this.addSlotToContainer(new Slot(te, INPUT_1, 7, 15));
		this.addSlotToContainer(new Slot(te, INPUT_2, 28, 15));
		this.addSlotToContainer(new Slot(te, INPUT_3, 49, 15));
		this.addSlotToContainer(new Slot(te, INPUT_4, 70, 15));
		this.addSlotToContainer(new Slot(te, INPUT_5, 116, 16));
		this.addSlotToContainer(new Slot(te, OUTPUT, 116, 63));
		
		tileEntity = te;
		
		bindPlayerInventory(player);
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
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return true;
	}
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
        		else if (slotty != INPUT_3 && slotty != INPUT_1 && slotty != INPUT_2 && slotty != INPUT_4 && slotty != INPUT_5)
        		{
        // if it can be smelted, place in the input slots
        			
        // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
        				if (!this.mergeItemStack(itemstackR, INPUT_1, INPUT_5+1, false))
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

	}}

