package dmf444.ExtraFood.Common.blocks.tileentity;

import dmf444.ExtraFood.Common.RecipeHandler.OvenRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.OvenRegistryRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOven extends TileEntity implements ISidedInventory{
		//TODO Constructors
	
	public ItemStack[] items;
    private static final int[] slots_bottom = new int[] {5};
	
	private int time = 0; //Current place
	int maxtime = 12000; //Max recipe time
	
	boolean going = false; //if cooking

	private OvenRegistryRecipe recipet;
	
	public TileEntityOven(){
		items = new ItemStack[6];
	}
	
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	@Override
	public void updateEntity() {
		if (OvenRegistry.instance.ok(items) && items[5] == null){
			if (getTime() == 0 && going == false){
				startRecipe(OvenRegistry.instance.getRecipe(items));
				return;
			}
			else {
				setTime(getTime() + 1);
				if (getTime() == maxtime){
					endRecipe();
				}
			}
		}
		else {
			going = false;
			setTime(0);
			maxtime = 12000;
		}
	}
	
	private void endRecipe() {
		int i = -1;
		boolean ok;
		setInventorySlotContents(5, recipet.getRecipeOutput(OvenRegistry.instance.getArrayList(items)));
		for (ItemStack is : items) {
			i++;
			ok = false;
			if (i == 4){
				break;
			}
			if (is == null){
				continue;
			}
			if (items[i] == null){
				continue;
			}
			
			for (ItemStack itt : recipet.items){
				
				if (recipet.ok(is, itt)){
					
					
					
					items[i].stackSize -= itt.stackSize;
					if (items[i].stackSize <= 0){
						items[i] =null;
					}
					ok = true;
					break;
				}
				if (is.stackSize == 1 && (itt.getItem() == is.getItem()) && is.getItemDamage() == itt.getItemDamage()){
					items[i] = null;
					ok = true;
					break;
				}
				
			}
			if (ok == true){
				continue;
			}
			if (items[i].stackSize == 1){
				items[i] = null;
			}
			else {
				items[i].stackSize -= 1;
			}
			
		}
		setTime(0);
		going = false;
		maxtime = 12000;
	}

	private void startRecipe(OvenRegistryRecipe recipe) {
		
		setTime(0);
		maxtime = recipe.getTime(OvenRegistry.instance.getArrayList(items));
		going = true;
		recipet = recipe;
	}
	
	public int getTimeTicks(){
		if (recipet != null){
			return recipet.getTime(OvenRegistry.instance.getArrayList(items));
		}
		else {
			return 0;
		}
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return items[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return items[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		items[slot] = stack;
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Oven";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
	            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
	  @Override
	    public void readFromNBT(NBTTagCompound tagCompound) {
	            super.readFromNBT(tagCompound);
	            
	            NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
	           for (int i = 0; i < tagList.tagCount(); i++) {
	                    NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
	                    byte slot = tag.getByte("Slot");
	                    if (slot >= 0 && slot < items.length) {
	                           items[slot] = ItemStack.loadItemStackFromNBT(tag);
	                    }
	            }
	    }

	    @Override
	    public void writeToNBT(NBTTagCompound tagCompound) {
	            super.writeToNBT(tagCompound);
	                            
	            NBTTagList itemList = new NBTTagList();
	            for (int i = 0; i < items.length; i++) {
	                    ItemStack stack = items[i];
	                    if (stack != null) {
	                            NBTTagCompound tag = new NBTTagCompound();
	                            tag.setByte("Slot", (byte) i);
	                            stack.writeToNBT(tag);
	                            itemList.appendTag(tag);
	                    }
	            }
	            tagCompound.setTag("Inventory", itemList);
	    }

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 0 ? slots_bottom : null;
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, int side) {
        return slot == 5;
    }
}

