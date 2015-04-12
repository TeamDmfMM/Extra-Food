package dmf444.ExtraFood.Core.Crossmod.Waila;

import java.util.List;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.util.EFLog;

public class WailaProviderJuiceBlender implements IWailaDataProvider{
	
	

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
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
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return null;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
        if (te != null){
        	TileEntityJuiceBlender tileEntity = (TileEntityJuiceBlender) te;
        	if(tileEntity.tank.getFluid() != null){
        		ExtraFood.JBTanknet.sendToAllAround(new PacketJBTank(tileEntity.tank.getFluidAmount(), tileEntity.tank.getFluid().tag, tileEntity.tank.getFluid().getFluid().getID(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord), new TargetPoint(tileEntity.getWorldObj().provider.dimensionId, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, 10));
        	}
        }
        return tag;
	}

}
