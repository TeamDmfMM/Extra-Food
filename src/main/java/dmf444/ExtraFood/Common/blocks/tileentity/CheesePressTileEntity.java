package dmf444.ExtraFood.Common.blocks.tileentity;

import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CheesePressTileEntity extends TileEntity implements ISidedInventory, ITickable {

    private static final int[] slots_top = new int[]{0, 1, 2};
    private static final int[] slots_bottom = new int[]{0, 1, 2, 3};
    private static final int[] slots_sides = new int[]{0, 1, 2};
    public int complete = -1;
    public int ttime;
    public float AnimationAngle;
    private ItemStack[] inv;
    private int totalTime;

    public CheesePressTileEntity() {
        inv = new ItemStack[4];
    }

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return inv[slot];
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {

        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(this.pos) == this && player.getDistanceSq(new BlockPos(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5)) < 64;
    }


    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
            ItemStack stack = inv[i];
            if (stack != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        tagCompound.setTag("Inventory", itemList);
    }

    @Override
    public String getName() {
        return "extrafood.CheesePressTileEntity";
    }


    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        if (i == 3){ return false;}
        return itemstack.getItem() == Items.milk_bucket;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    public boolean areItemsCorrect() {
        for (int i = 0; i < 3; i++) {
            if (this.getStackInSlot(i) != null) {
                if (this.getStackInSlot(i).getItem() != Items.milk_bucket) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (this.getStackInSlot(3) != null) {
            if (this.getStackInSlot(3).stackSize == 64 || this.getStackInSlot(3).getItem() != ItemLoader.cheeseWheel) {
                return false;
            }
        }
        return true;
    }

    public void makeCheese() {
        //if (!this.worldObj.isRemote){
        //this.decrStackSize(0, 1);
        //this.decrStackSize(1, 1);
        //this.decrStackSize(2, 1);
        this.inv[0] = null;
        this.inv[1] = null;
        this.inv[2] = null;
        if (inv[0] == null && inv[1] == null && inv[2] == null) {
            ItemStack ist = new ItemStack(Items.bucket, 1);
            for (int i = 0; i < 3; i++) {
                this.inv[i] = ist.copy();
            }
        }
        if (this.inv[3] != null) {
            this.inv[3].stackSize += 1;
        } else {
            ItemStack is = new ItemStack(ItemLoader.cheeseWheel, 1);
            this.inv[3] = is.copy();
        }
        //}
    }

    @Override
    public void update() {
        if (this.areItemsCorrect() == true) {
            int ticks = this.complete * 10 + this.ttime;
            if (ticks % 2 == 0) {
                int degrees = (int) (ticks * 1.5);
                float trans = (float) ((float) Math.sin(degrees) * 0.25);
                if (trans < 0) {
                    trans = -trans;
                }
                this.AnimationAngle = trans;
            }

            this.ttime += 1;
            if (this.ttime == 10) {
                this.ttime = 0;
                this.complete += 1;
                this.totalTime += 1;
                if (this.complete == 24) {
                    makeCheese();
                    this.totalTime = 0;
                    if (this.AnimationAngle != 0.0F) {
                        this.AnimationAngle = 0.0F;
                    }
                }
            }
        } else {
            this.complete = -1;
        }
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    @SideOnly(Side.CLIENT)
    public void ResetTiming(int newTime) {
        this.totalTime = newTime;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Override
    public void openInventory(EntityPlayer p) {
    }

    @Override
    public void closeInventory(EntityPlayer p) {
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing direction) {
        return this.isItemValidForSlot(slot, item);

    }

    @Override
    public boolean canExtractItem(int index, ItemStack item, EnumFacing direction) {
        return item.getItem() == ItemLoader.cheeseWheel || item.getItem() == Items.bucket;
    }

}