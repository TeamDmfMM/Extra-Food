package dmf444.ExtraFood.Common.blocks.tileentity;


import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;




public class TileEntityJuiceBlender extends TileEntity implements ISidedInventory, IFluidHandler {


	public FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * 5);
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2};
    private static final int[] slots_sides = new int[] {1};


	public ItemStack[] items;
	public FluidStack juice;

	public int ttime;
	public int complete;
	
	public int amountin;
	public FluidStack myjuice;

    public TileEntityJuiceBlender(){
        items = new ItemStack[3]; 
    }



	@Override
	public int getSizeInventory() {
		return 3;
	}




	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {


		return items[p_70301_1_];


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
	public String getInventoryName() {


		return "Juice Blender";
	}




	@Override
	public boolean hasCustomInventoryName() {


		return false;
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
	public void openInventory() {}




	@Override
	public void closeInventory() {}




	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if (slot == 0 && itemstack.getItem() != Items.bucket){
			return true;
		} else if (slot == 1 && itemstack.getItem() == Items.bucket){
			return true;
		}
		return false;
	}


	  @Override
	    public void setInventorySlotContents(int slot, ItemStack stack) {




	            items[slot] = stack;
	            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
	                    stack.stackSize = getInventoryStackLimit();
	            }               
	    }
	  public boolean ok(){
		  if (JuiceRegistry.instance.getJuiceFromItemStack(this.items[0]) != null){
			  if (this.tank.getFluid() != null){
				  if (this.tank.getFluid().getFluid() == JuiceRegistry.instance.getJuiceFromItemStack(this.items[0])){
					  return true;
				  }
				  else {
					  return false;
				  }
			  }
			  else {
				  return true;
			  }
		  }
		  return false;
	  }

	  public void updateEntity(){


		 // EFLog.error(tank.getFluidAmount());


		  if (this.ok()){
			  this.ttime += 1;
			  if (this.ttime == 20){
				  this.ttime = 0;
				  this.complete += 1;
				  if (this.complete == 20){
					  this.do_thingy();
					  this.ttime = 0;
					  this.complete = 0;
				  }
			  }
		  }
		  if (this.items[1] != null){
			  // FILL THE BUCKET
			  if (this.items[1].getItem() == Items.bucket && this.tank.getFluid() != null && this.items[2] == null){
				  if (this.tank.getFluidAmount() >= 1000){
					  if (this.tank.getFluid().getFluidID() == FluidLoader.Fstrawberryjuice.getID()){
						  this.items[1].stackSize -= 1;
						  this.items[2] = new ItemStack(ItemLoader.bucketstrawberry, 1);
						  this.tank.drain(1000, true);




					  }
					  else if (this.tank.getFluid().getFluidID() == FluidLoader.Fbananajuice.getID()){
						  this.items[1].stackSize -= 1;
						  this.items[2] = new ItemStack(ItemLoader.bucketbanana, 1);
						  this.tank.drain(1000, true);




					  }
					  else if (this.tank.getFluid().getFluidID() == FluidLoader.Fcarrotjuice.getID()){
						  this.items[1].stackSize -= 1;
						  this.items[2] = new ItemStack(ItemLoader.bucketcarrot, 1);
						  this.tank.drain(1000, true);
					  }
					  if (items[1].stackSize == 0){
					        this.items[1] = null;
					  }
				  }
			  }
		  }
	  }







	private void do_thingy() {
		// TODO Auto-generated method stub
		if (this.tank.getFluid() == null){
			FluidStack juice = new FluidStack(JuiceRegistry.instance.getJuiceFromItemStack(this.items[0]), 100);
			this.tank.setFluid(juice);
		}
		else {
			this.tank.getFluid().amount += 100;
		}
		if (this.items[0].stackSize == 1){
			this.items[0] = null;
		}
		else {
			this.items[0].stackSize -= 1;
		}


	}

	 public void writeToNBT(NBTTagCompound tag){
		NBTTagList t = new NBTTagList();
		int s = 0;
		for (ItemStack i : items){
			if (i != null){
				NBTTagCompound item = new NBTTagCompound();
				i.writeToNBT(item);
				item.setInteger("Slot", s);
				t.appendTag(item);
			}
			s += 1;
		}
		tag.setTag("Items", t);
		
		if (tank.getFluid() != null){
		 this.tank.writeToNBT(tag);
		 //EFLog.fatal(tag);
		}
		super.writeToNBT(tag);


		/* if (this.tank != null)
	        {
			 this.tank.writeToNBT(tag);
	        }
	        else
	        {
	        	tag.setString("Fluid", "");
	        }
		 super.writeToNBT(tag);*/
		/*super.writeToNBT(tag);
			tag.setInteger("Tracker", outputint);
			tank.writeToNBT(tag);
		 	*/
	}
	
	public void readFromNBT(NBTTagCompound tag){
		int s = 0;
		NBTTagList itl = tag.getTagList("Items", 10);


		for (s = 0; s < itl.tagCount(); s ++){
			NBTTagCompound t = itl.getCompoundTagAt(s);
			if (t != null){
				items[t.getInteger("Slot")] = ItemStack.loadItemStackFromNBT(t);
			}
		}
        super.readFromNBT(tag);
        this.tank.readFromNBT(tag);
        //this.amountin = tank.getFluidAmount();
        //this.myjuice = tank.getFluid();
	    //EFLog.error(tank.getFluidAmount());
	}

	

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
        return tank.drain(resource.amount, doDrain);
	}



	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return tank.drain(maxDrain, doDrain);
	}



	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[] { tank.getInfo() };
	}



	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}



	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side){
		
		return this.isItemValidForSlot(slot, item);
	}



	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return side != 0 || slot != 1 || item.getItem() == ItemLoader.bucketcarrot ||item.getItem() == ItemLoader.bucketbanana || item.getItem() == ItemLoader.bucketstrawberry;
    }


}
