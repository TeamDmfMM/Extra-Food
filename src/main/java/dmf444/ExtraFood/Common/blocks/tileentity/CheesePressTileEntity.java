package dmf444.ExtraFood.Common.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CheesePressTileEntity extends TileEntity implements IInventory {

    private ItemStack[] inv;
    public int complete = -1;
	public int ttime;
    
    public CheesePressTileEntity(){
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
    public ItemStack getStackInSlotOnClosing(int slot) {
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
            return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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
            public String getInventoryName() {
                    return "extrafood.CheesePressTileEntity";
            }


			@Override
			public boolean isItemValidForSlot(int i, ItemStack itemstack) {
				// TODO Auto-generated method stub
				return false;
			}
			public boolean areItemsCorrect(){
					for (int i = 0; i < 3; i++){
						if (this.getStackInSlot(i) != null){
						if (this.getStackInSlot(i).getItem() != Items.milk_bucket){
							return false;
						}
						}
						else {
							return false;
						}
					}
					if (this.getStackInSlot(3) != null){
					if (this.getStackInSlot(3).stackSize == 64 || this.getStackInSlot(3).getItem() != ItemLoader.cheeseWheel){
						return false;
					}}
					return true;
			}
			public void makeCheese(){
				if (!this.worldObj.isRemote){
				this.decrStackSize(0, 1);
				this.decrStackSize(1, 1);
				this.decrStackSize(2, 1);
				ItemStack ist = new ItemStack(Items.bucket, 1);
				for (int i = 0; i< 3; i++){
					this.setInventorySlotContents(i, ist);
				}
				if (this.getStackInSlot(3) != null){
					this.getStackInSlot(3).stackSize += 1;
				}
				else {
					ItemStack is = new ItemStack(ItemLoader.cheeseWheel, 1);
					this.setInventorySlotContents(3, is);
					}
				}
			}
			@Override
			public void updateEntity(){
				if (this.areItemsCorrect() == true){
					this.ttime += 1;
					if (this.ttime == 10){
						this.ttime = 0;
						this.complete += 1;
						if (this.complete == 24){
							makeCheese();
						}
					}
				}
				else {
					this.complete = -1;
				}
			}

		

			@Override
			public boolean hasCustomInventoryName() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void openInventory() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void closeInventory() {
				// TODO Auto-generated method stub
				
			}
			
}