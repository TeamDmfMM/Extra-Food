package dmf444.ExtraFood.Common.blocks.tileentity;


import dmf444.ExtraFood.Core.ExtraFood;
import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;


public class AutoCutterTileEntity extends TileEntity implements IInventory {


    private ItemStack[] inv;


    public AutoCutterTileEntity(){
            inv = new ItemStack[3];
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
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }


    @Override
    public void openChest() {}


    @Override
    public void closeChest() {}
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
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
            public String getInvName() {
                    return "extrafood.autocutter";
            }
	public boolean work;
	//TODO constructors
	public int complete;
	public int ttime;


	@Override
	public boolean isInvNameLocalized() {
		return false;
	}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	public boolean ok(){


		if (this.inv[0] != null){
			System.out.println("1");			
			if (ExtraFood.registryCutter.getItemOutput(this.inv[0]) != null){
				System.out.println("2");	
				if (this.inv[2] != null){
				if(this.inv[2].itemID == ItemLib.idKnife){
				System.out.println("2.5");	
				ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
				if (this.inv[1] != null){
					if (this.inv[1].itemID != l.itemID){
						return false;
					}
					if (this.inv[1].stackSize >= 64 - l.stackSize + 1){
						return false;
					}
					return false;
				}
				}
				}
				System.out.println("3");
				return true;




			}
			else {
				return false;
			}
		}
		else {
			return false;


		}
	}	
	public void updateEntity(){
		if (this.ok()){
			this.ttime += 1;
			if (this.ttime == 20){
				this.ttime = 0;
				this.complete += 1;
				if (this.complete == 5){
					System.out.println("ko");
					this.do_();
					this.complete = 0;
					this.ttime = 0;
				}
			}
		}
	}


	private void do_() {
		ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
		if (this.inv[1] == null){
			this.inv[1] = l;
		}
		else {
			this.inv[1].stackSize += l.stackSize;
		}
		this.decrStackSize(0, 1);



	}
	}
