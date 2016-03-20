package dmf444.ExtraFood.Common.blocks.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by dmf444 on 3/14/2016. <-- PI DAY WOOT! Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class SlotBetter extends Slot {

    IInventory inv;
    int index;

    public SlotBetter(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.inv = inventoryIn;
        this.index = index;
    }

    public boolean isItemValid(ItemStack is){
        return inv.isItemValidForSlot(index, is);
    }
}
