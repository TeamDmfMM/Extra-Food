package dmf444.ExtraFood.Common.blocks.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Client.renderer.AutoCutterModel;
import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class AutoCutterTileEntity extends TileEntity implements ISidedInventory {


    private ItemStack[] inv;
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};


    public AutoCutterTileEntity(){
            inv = new ItemStack[3];
    }
    

    public int getSizeInventory() {
            return inv.length;
    }



    public ItemStack getStackInSlot(int slot) {
            return inv[slot];
    }
    

    public void setInventorySlotContents(int slot, ItemStack stack) {
            inv[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }



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


    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    

    public int getInventoryStackLimit() {
            return 64;
    }



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
    


   public String getInventoryName() {
         return "extrafood.autocutter";
   }
   
            
            
            
	public boolean work;
	//TODO constructors
	public int complete;
	public int ttime;



	public boolean hasCustomInventoryName() {
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
       return slot == 2 ? false : (slot == 1 ? itemstack == new ItemStack(ItemLoader.cheeseWheel, 1) : true);
	}
		
	
	public boolean ok(){

		/*
		 * With seven checks, this function returns true if the autocutter is in an ok state to continue/start cutting!
		 */


		if (this.inv[0] != null){//1
			System.out.println("1-out");					
			if (this.inv[2] != null){//2
				if(this.inv[2].getItem() == ItemLoader.knife){//3
					System.out.println("2.5-out");		
					if (ExtraFood.registryCutter.getItemOutput(this.inv[0]) != null){//4
						System.out.println("2-out");		
						ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
						if (this.inv[1] != null){//5
							System.out.println("3-in");
							if (this.inv[1].getItem() == l.getItem()){//6
								System.out.println("4-donein");


								return true;//6}
							}
								else {
									return false;
								}
						}
						System.out.println("3-doneout");
						return true;//3
					}
					System.out.println("Why am I tracking4");
					return false;//2
				}
				System.out.println("3");
				return false;//1
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	public void updateEntity(){

	if (this.ok()){
		//if (!this.worldObj.isRemote){
			this.ttime += 1;
			if (this.ttime == 20){
				this.ttime = 0;
				this.complete += 1;
				if (this.complete == 5){
					System.out.println("ko");
					
					this.do_();
					this.complete = 0;
					this.ttime = 0;
					//markDirty();
					//updateContainingBlockInfo();
					
				}
			}
		}
	  //}
	}


	private void do_() {
		ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
		if (this.inv[1] == null){
			System.out.println("followin' 1");
			this.inv[1] = l.copy();
		}
		else if(this.inv[1].getItem() == l.getItem()) {
			System.out.println("followin' 2");
			this.inv[1].stackSize += l.stackSize;
			//this.inv[1].stackSize += l.stackSize;
		}
		--this.inv[0].stackSize;
		//this.decrStackSize(0, 1);
		 if (this.inv[0].stackSize <= 0)
         {
             this.inv[0] = null;
         }
	}
	
	/*
	public Packet getDescriptionPacket(){
		NBTTagCompound tags = new NBTTagCompound();
		this.writeToNBT(tags);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 0, tags);
	}


	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{

		this.readFromNBT(pkt.data);
	}
	*/
    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
        return this.isItemValidForSlot(slot, item);
    }
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return side != 0 || slot != 2 || item.getItem() == Items.bucket;
    }
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
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
