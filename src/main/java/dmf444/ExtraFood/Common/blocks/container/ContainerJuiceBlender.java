package dmf444.ExtraFood.Common.blocks.container;


import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;


public class ContainerJuiceBlender extends Container{


	TileEntityJuiceBlender tileEntity;
	EntityPlayerMP player;
	private static TileEntity TTEE;
	
	
	public static int INPUT_1 = 0, INPUT_2 = 1, OUTPUT_1 = 2;


	public ContainerJuiceBlender(InventoryPlayer inventoryPlayer, TileEntityJuiceBlender te){
		this.addSlotToContainer(new Slot(te, INPUT_1, 80, 20));
		this.addSlotToContainer(new Slot(te, INPUT_2, 126, 12));
		this.addSlotToContainer(new Slot(te, OUTPUT_1, 126, 34));
		this.tileEntity = te;
		this.TTEE = te;

		this.bindPlayerInventory(inventoryPlayer);

	}
	public static TileEntity getTE(){
		return TTEE;
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


	@Override
	public boolean canInteractWith(EntityPlayer theplayer) {
		return true;
	}
	
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();		
		//EFLog.fatal("MONONINOMA");
		for (int i = 0; i < this.crafters.size(); ++i){
			if (crafters.get(i) instanceof EntityPlayerMP){
				if (tileEntity.tank.getFluid() != null){
					//ExtraFood.JBTanknet.sendToAllAround(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid().getID(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord), new TargetPoint(tileEntity.getWorldObj().provider.dimensionId, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, 10));
					ExtraFood.JBTanknet.sendTo(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid().getID(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()), (EntityPlayerMP) crafters.get(i));
				}
		}
	}
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotty){
		 ItemStack stack = null;
         Slot slot = (Slot)this.inventorySlots.get(slotty);

         if (slot != null && slot.getHasStack())
         	{
         	ItemStack itemstackR = slot.getStack();
         	stack = itemstackR.copy();

         // If itemstack is in Output stack
         		if (slotty == OUTPUT_1)
         			{
         // try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
         // so the last slot in the inventory won't get checked if you don't add 1
         				if (!this.mergeItemStack(itemstackR, OUTPUT_1 +1, OUTPUT_1 +36+1, true))
         				{
         					return null;
         				}	

         			slot.onSlotChange(itemstackR, stack);
         			}
      // itemstack is in player inventory, try to place in appropriate furnace slot
         		else if (slotty != INPUT_1 && slotty != INPUT_2)
         		{
         // if it can be smelted, place in the input slots			
         // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
         				if (!this.mergeItemStack(itemstackR, INPUT_1, INPUT_1+1, false))
         				{
         					return null;
         				}
         				if(!this.mergeItemStack(itemstackR, INPUT_2, INPUT_2+1, false)){
         					return null;
         				}
         		}

         // item in player's inventory, but not in action bar
         		else if (slotty >= OUTPUT_1 +1 && slotty < OUTPUT_1 +28)
         			{
         // place in action bar
         				if (!this.mergeItemStack(itemstackR, OUTPUT_1 +28, OUTPUT_1 +37, false))
         				{
         				return null;
         				}
         			}   
      // item in action bar - place in player inventory
         		else if (slotty >= OUTPUT_1+28 && slotty < OUTPUT_1+37 && !this.mergeItemStack(itemstackR, OUTPUT_1+1, OUTPUT_1+28, false))
         		{
         				{
         				return null;
         				}
         		}
         // In one of the infuser slots; try to place in player inventory / action bar
         		else if (!this.mergeItemStack(itemstackR, OUTPUT_1+1, OUTPUT_1+37, false))
         				{
         				return null;
         				}

         				if (itemstackR.stackSize == 0)
         				{
         					slot.putStack((ItemStack)null);
         				}
         				else
         				{
         					slot.onSlotChanged();
         				}

         				if (itemstackR.stackSize == stack.stackSize)
         				{
         					return null;
         				}

         		slot.onPickupFromSlot(player, itemstackR);
         		}
      return stack;
	}
}

