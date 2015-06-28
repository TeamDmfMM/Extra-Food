package dmf444.ExtraFood.Core;

import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.util.EFLog;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketJBTank implements IMessage{


	private int liquidamount;
	private NBTTagCompound tag;
	private int FluidID;


	private int x;
	private int y;
	private int z;




	public PacketJBTank(){ 
		//DO NOTHING.....
	}


	public PacketJBTank(int liquidA, NBTTagCompound nbt, int fluidid, int x, int y, int z){
		this.liquidamount = liquidA;
		this.tag = nbt;
		this.FluidID = fluidid;
		this.x = x;
		this.y = y;
		this.z = z;
	}


	@Override
	public void fromBytes(ByteBuf buf) {
		liquidamount = ByteBufUtils.readVarInt(buf, 5);
		tag = ByteBufUtils.readTag(buf);
		FluidID = ByteBufUtils.readVarInt(buf, 5);
		x = ByteBufUtils.readVarInt(buf, 5);
		y = ByteBufUtils.readVarInt(buf, 5);
		z = ByteBufUtils.readVarInt(buf, 5);


	}


	@Override
	public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeVarInt(buf, liquidamount, 5000);
    ByteBufUtils.writeTag(buf, tag);
    ByteBufUtils.writeVarInt(buf, FluidID, 127);
    ByteBufUtils.writeVarInt(buf, x, 5);
    ByteBufUtils.writeVarInt(buf, y, 5);
    ByteBufUtils.writeVarInt(buf, z, 5);
    


	}

	
	public static class Handler implements IMessageHandler<PacketJBTank, IMessage> {


		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketJBTank message, MessageContext ctx) {


		    World w = Minecraft.getMinecraft().theWorld;
		    if (w.isBlockLoaded(new BlockPos(message.x, message.y, message.z))){
				EFLog.trace(message.liquidamount + "  " + message.FluidID);
		    	TileEntityJuiceBlender b = (TileEntityJuiceBlender)w.getTileEntity(new BlockPos(message.x, message.y, message.z));
		    	if (b.tank.getFluid() != null){
                    b.tank.setFluid(new FluidStack(message.FluidID, message.liquidamount));
		    	//b.tank.getFluid().fluid = message.FluidID;
		    	//b.tank.getFluid().amount = message.liquidamount;
		    	}
		    	else {
		    		b.tank.setFluid(new FluidStack(message.FluidID, message.liquidamount));
		    	}


		    }
			return null;
		}
	}
}
