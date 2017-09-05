package com.dmfmm.extrafood.container;

import com.dmfmm.extrafood.container.Slot.SlotBetter;
import com.dmfmm.extrafood.tileentities.JuiceMixerTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class JuiceMixerContainer extends Container {


    private JuiceMixerTileEntity tile;
    public static int INPUT_1 = 0, INPUT_2 = 1, OUTPUT_1 = 2, OUTPUT_2 = 3;

    public JuiceMixerContainer(InventoryPlayer inventory, JuiceMixerTileEntity tileEntity) {
        this.tile = tileEntity;

        this.addSlotToContainer(new SlotBetter(tile, OUTPUT_1, 104, 7));
        this.addSlotToContainer(new SlotBetter(tile, INPUT_1, 81, 7));

        this.addSlotToContainer(new SlotBetter(tile, OUTPUT_2, 152, 60));
        this.addSlotToContainer(new SlotBetter(tile, INPUT_2, 152, 38));

        this.bindPlayerInventory(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUsableByPlayer(player);
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
}