package dmf444.ExtraFood.Common.blocks.tileentity;


import com.google.common.collect.Lists;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;


public class AutoCutterTileEntity extends TileEntity implements ISidedInventory , IUpdatePlayerListBox {


    private ItemStack[] inv;
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
    private int numOfPlayers;

    public float knifeAngle;
    private int totalTime;


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
        return worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ())) == this &&
                player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()+ 0.5) < 64;
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
       return slot == 2 ? false : (slot == 1 ? itemstack == new ItemStack(ItemLoader.cheeseWheel, 1) : true);
	}
		
	
	public boolean ok(){

		/*
		 * With seven checks, this function returns true if the autocutter is in an ok state to continue/start cutting!
		 */


		if (this.inv[0] != null){//1
			//System.out.println("1-out");					
			if (this.inv[2] != null){//2
				if(this.inv[2].getItem() == ItemLoader.knife){//3
					//System.out.println("2.5-out");		
					if (ExtraFood.registryCutter.getItemOutput(this.inv[0]) != null){//4
						//System.out.println("2-out");		
						ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
						if (this.inv[1] != null){//5
							//System.out.println("3-in");
							if (this.inv[1].getItem() == l.getItem()){//6
								//System.out.println("4-donein");


								return true;//6}
							}
								else {
									return false;
								}
						}
						//System.out.println("3-doneout");
						return true;//3
					}
					//System.out.println("Why am I tracking4");
					return false;//2
				}
				//System.out.println("3");
				return false;//1
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	public void update(){
        //EFLog.error(this.knifeAngle);
	    if (this.ok()){
            this.ttime += 1;

             if(this.complete >= 0) {
               /* if(this.ttime <= 9){
                    this.knifeAngle += 0.25F;
                } else if(this.ttime >= 10){
                    this.knifeAngle += 0.25F;
                }*/
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
					
					this.do_();
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


	private void do_() {
		ItemStack l = ExtraFood.registryCutter.getItemOutput(this.inv[0]);
		if (this.inv[1] == null){
			//System.out.println("followin' 1");
			this.inv[1] = l.copy();
		}
		else if(this.inv[1].getItem() == l.getItem()) {
			//System.out.println("followin' 2");
			this.inv[1].stackSize += l.stackSize;
			//this.inv[1].stackSize += l.stackSize;
		}
		--this.inv[0].stackSize;
		//this.decrStackSize(0, 1);
		 if (this.inv[0].stackSize <= 0)
         {
             this.inv[0] = null;
         }
        this.markDirty();
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
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing direction)
    {
        return this.isItemValidForSlot(slot, item);
    }
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing direction)
    {
        return direction != EnumFacing.DOWN || slot != 2 || item.getItem() == Items.bucket;
    }
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }


	@Override
	public void openInventory(EntityPlayer e) {
        if (this.numOfPlayers < 0){
            this.numOfPlayers = 0;
        }
        ++this.numOfPlayers;
    }


	@Override
	public void closeInventory(EntityPlayer p) {
        --this.numOfPlayers;
    }

    @Override
    public boolean receiveClientEvent(int eventNum, int arg)
    {
        if (eventNum == 1)
        {
            this.numOfPlayers = arg;
            return true;
        }
        else
        {
            return super.receiveClientEvent(eventNum, arg);
        }
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
    public IChatComponent getDisplayName() {
        return null;
    }
}
