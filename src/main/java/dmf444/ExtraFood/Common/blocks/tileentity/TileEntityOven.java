package dmf444.ExtraFood.Common.blocks.tileentity;

import dmf444.ExtraFood.Common.RecipeHandler.OvenRegistry;
import dmf444.ExtraFood.Common.RecipeHandler.OvenRegistryRecipe;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodRegistry;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodSpecs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ITickable;

public class TileEntityOven extends TileEntity implements ISidedInventory, ITickable {
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
		return 6;
	}
	
	@Override
	public void update() {
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
			if (ok){
				continue;
			}

			NBTFoodSpecs sepcky = NBTFoodRegistry.food.getSpecs(recipet.food);

			int value = 0;
			while (sepcky.addtypes.elements().hasMoreElements()) {
				ItemStack itemStack = sepcky.addtypes.elements().nextElement();
				if (itemStack.getItem().equals(items[i].getItem())) {
					value =  itemStack.stackSize;
					break;
				}
			}

			if (items[i].stackSize == value){
				items[i] = null;
			}
			else {
				items[i].stackSize -= value;
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
		return items[slot];
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
		return items[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		items[slot] = stack;
		
	}

	@Override
	public String getName() {
		return "Oven";
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
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return worldObj.getTileEntity(pos) == this && player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()+ 0.5) < 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {

		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
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
	    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
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
			return tagCompound;
	    }

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slots_bottom : new int[] {};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing direction) {
        return slot == 5;
    }
}

