package dmf444.ExtraFood.Core.Crossmod;

import java.util.ArrayList;
import java.util.List;

import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.PacketJBTank;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;

public class WailaProviderJuiceBlender implements IWailaDataProvider{
	
	

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntityJuiceBlender jb = (TileEntityJuiceBlender) accessor.getTileEntity();
		ContainerJuiceBlender container = new ContainerJuiceBlender(accessor.getPlayer().inventory, jb);
		
		int fluidAmount = jb.tank.getFluidAmount();
		int capacity = jb.tank.getCapacity();
		//EFLog.error(fluid + ", " + fluidAmount + "/" + capacity);
		if(jb.tank.getFluidAmount() == 0){
			currenttip.add("Fluid: None");
			currenttip.add("Amount: 0/" + String.valueOf(capacity) + " mB");			
		} else {
			String fluid = jb.tank.getFluid().getFluid().getLocalizedName(jb.tank.getFluid());
			currenttip.add("Fluid: "  + fluid);
			currenttip.add("Amount: " + String.valueOf(fluidAmount) + "/" + String.valueOf(capacity) + " mB");
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

}
