package com.dmfmm.extrafood.tileentities;
import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.init.ItemLoader;
import com.google.common.collect.Lists;
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

import java.util.ArrayList;


public class AutoCutterTileEntity extends TileEntity implements ISidedInventory , ITickable {


    private ItemStack[] inv;
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};

    public float knifeAngle;
    private int totalTime;


    public AutoCutterTileEntity(){
        inv = new ItemStack[3];
    }


    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public boolean isEmpty() {
        return inv[0].isEmpty();
    }


    public ItemStack getStackInSlot(int slot) {
        return inv[slot] == null ? ItemStack.EMPTY : inv[slot];
    }


    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
    }



    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.getCount() <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.getCount() == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }


    public ItemStack removeStackFromSlot(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }


    public int getInventoryStackLimit() {
        return 64;
    }



    public boolean isUsableByPlayer(EntityPlayer player) {
        return world.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ())) == this && player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()+ 0.5) < 64;
    }


    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length) {
                inv[slot] = new ItemStack(tag);
            }
        }
    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
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
        return tagCompound;
    }



    public String getName() {
        return "extrafood.autocutter";
    }




    public boolean work;
    //TODO constructors
    public int complete;
    public int ttime;



    public boolean hasCustomName() {
        return false;
    }



    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		/*if (this.inv[slot] != null){
			if (ExtraFood.registryCutter.getItemOutput(this.inv[slot]) != null){
				return true;
			}
			return true;
		}
		return false;
		*/
        return true; // Why was that there?
    }


    public boolean validState(){

		/*
		 * With seven checks, this function returns true if the autocutter is in an ok state to continue/start cutting!
		 */


        if (this.inv[0] != null) {
            if (this.inv[2] != null) {
                if (this.inv[2].getItem() == ItemLoader.KNIFE) {
                    if (ExtraFood.registryCutter.getItemOutput(this.inv[0]) != null) {
                        ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
                        if (this.inv[1] != null) {//5
                            if (this.inv[1].getItem() == l.getItem()) {
                                return this.inv[1].getCount() < 64 - l.getCount();
                            }
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public void update(){
        //EFLog.error(this.knifeAngle);
        if (this.validState()){
            this.ttime += 1;

            if(this.complete >= 0) {
                ArrayList<Float> bob = Lists.newArrayList(5.0F, 5.1F, 5.2F, 5.3F, 5.4F, 5.5F, 5.6F, 5.7F, 5.8F, 5.9F, 18.5F, 6.0F, 6.1F, 6.2F, 0.0F, 6.2F, 6.0F, 18.4F, 5.8F, 5.6F);
                this.knifeAngle = bob.get(this.ttime - 1);

            }

            if (this.ttime == 20){
                this.ttime = 0;
                this.complete += 1;
                this.totalTime += 1;
                if(this.totalTime == 0 && this.complete >= 1){
                    this.ttime = 0;
                    this.complete = 0;
                }
                if (this.complete == 5){
                    //System.out.println("ko");

                    this.complete_recipe();
                    this.complete = 0;
                    this.ttime = 0;
                    this.totalTime = 0;
                    if(this.knifeAngle != 0.0F){
                        this.knifeAngle = 0.0F;
                    }

                }
            }
        }
    }
    public int getTotalTime(){
        return this.totalTime;
    }

    @SideOnly(Side.CLIENT)
    public void ResetTiming(int newTime)
    {
        this.totalTime = newTime;
    }


    private void complete_recipe() {
        ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
        if (this.inv[1] == null){
            this.inv[1] = l.copy();
        }
        else if(this.inv[1].getItem() == l.getItem()) {
            this.inv[1].grow(l.getCount());
        }
        this.inv[0].shrink(1);
        if (this.inv[0].getCount() <= 0)
        {
            this.inv[0] = null;
        }
        this.markDirty();
    }


    public boolean canInsertItem(int slot, ItemStack item, EnumFacing direction)
    {
        return this.isItemValidForSlot(slot, item);
    }
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing direction)
    {
        return direction != EnumFacing.DOWN || slot != 2 || item.getItem() == Items.BUCKET;
    }
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }


    @Override
    public void openInventory(EntityPlayer e) {

    }


    @Override
    public void closeInventory(EntityPlayer p) {

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
    public void clear() {}

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }
}