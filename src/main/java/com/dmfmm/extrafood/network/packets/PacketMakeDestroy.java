package com.dmfmm.extrafood.network.packets;


import com.dmfmm.extrafood.tileentities.JuiceMixerTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class PacketMakeDestroy implements IMessage {

    public PacketMakeDestroy() {

    }

    int id;
    BlockPos pos;

    public PacketMakeDestroy(int id, BlockPos pos) {

        this.id = id;
        this.pos = pos;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound compound = ByteBufUtils.readTag(buf);
        pos = BlockPos.fromLong(compound.getLong("Pos"));
        id = compound.getInteger("ID");
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setLong("Pos", pos.toLong());
        compound.setInteger("ID", id);
        ByteBufUtils.writeTag(buf, compound);
    }

    public static class Handler implements IMessageHandler<PacketMakeDestroy, IMessage> {

        @Override
        public IMessage onMessage(PacketMakeDestroy message, MessageContext ctx) {
            World world = ctx.getServerHandler().playerEntity.getEntityWorld();

            TileEntity tile = world.getTileEntity(message.pos);
            if(tile instanceof JuiceMixerTileEntity){
                ((JuiceMixerTileEntity)tile).handleMakeDestroy(message.id);
            }
            return null;
        }
    }
}