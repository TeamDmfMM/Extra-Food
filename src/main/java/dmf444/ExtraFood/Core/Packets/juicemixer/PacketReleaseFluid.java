package dmf444.ExtraFood.Core.Packets.juicemixer;

import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by dmf444 on 3/14/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class PacketReleaseFluid implements IMessage{

    JuiceMixerTileEntity.SelectedTank selected;
    BlockPos pos;


    public PacketReleaseFluid(){

    }

    public PacketReleaseFluid(JuiceMixerTileEntity.SelectedTank newSelected, BlockPos pos){
        this.selected = newSelected;
        this.pos = pos;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound c = ByteBufUtils.readTag(buf);
        selected = JuiceMixerTileEntity.SelectedTank.values()[c.getInteger("select")];
        pos = BlockPos.fromLong(c.getLong("poz"));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        //buf.writeInt(selected.toInt());
        NBTTagCompound tag = new NBTTagCompound();
        tag.setLong("poz", pos.toLong());
        tag.setInteger("select", selected.toInt());
        ByteBufUtils.writeTag(buf, tag);
    }

    public static class Handler implements IMessageHandler<PacketReleaseFluid, IMessage> {

        @Override
        public IMessage onMessage(PacketReleaseFluid message, MessageContext ctx) {
            World world = ctx.getServerHandler().playerEntity.worldObj;

            TileEntity tile = world.getTileEntity(message.pos);
            if(tile instanceof JuiceMixerTileEntity){
                ((JuiceMixerTileEntity)tile).handleClickingRelease(message.selected.toInt());
            }
            return null;
        }
    }



}
