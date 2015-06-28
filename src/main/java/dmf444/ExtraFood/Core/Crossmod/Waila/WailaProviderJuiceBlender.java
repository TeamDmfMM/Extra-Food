/*
package dmf444.ExtraFood.Core.Crossmod.Waila;

import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.ExtraFood;
import mcp.mobius.waila.api.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public class WailaProviderJuiceBlender implements IWailaDataProvider{
	
	

	@Override
	public ITaggedList.ITipList getWailaBody(ItemStack itemStack, ITaggedList.ITipList currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntityJuiceBlender jb = (TileEntityJuiceBlender) accessor.getTileEntity();
		//ContainerJuiceBlender container = new ContainerJuiceBlender(accessor.getPlayer().inventory, jb);
		int fluidAmount = jb.tank.getFluidAmount();
		int capacity = jb.tank.getCapacity();
		//EFLog.error(fluid + ", " + fluidAmount + "/" + capacity);
		if(jb.tank.getFluidAmount() != 0){
			String fluid = jb.tank.getFluid().getFluid().getLocalizedName(jb.tank.getFluid());
			currenttip.add("Fluid: "  + fluid);
			currenttip.add("Amount: " + String.valueOf(fluidAmount) + "/" + String.valueOf(capacity) + " mB");
		} else {
			currenttip.add("Fluid: None");
			currenttip.add("Amount: 0/" + String.valueOf(capacity) + " mB");	
		}
		return currenttip;
	}

	@Override
	public ITaggedList.ITipList getWailaHead(ItemStack itemStack, ITaggedList.ITipList currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return null;
	}

	@Override
	public ITaggedList.ITipList getWailaTail(ItemStack itemStack, ITaggedList.ITipList currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(TileEntity te, NBTTagCompound tag, IWailaDataAccessorServer accessor) {
        if (te != null){
        	TileEntityJuiceBlender tileEntity = (TileEntityJuiceBlender) te;
        	if(tileEntity.tank.getFluid() != null){
        		ExtraFood.JBTanknet.sendToAllAround(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid().getID(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()), new TargetPoint(tileEntity.getWorld().provider.getDimensionId(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), 10));
        	}
        }
        return tag;
	}

}
*/
