package dmf444.ExtraFood.Core.Packets;

import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by dmf444 on 3/14/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class ChannelHandler {

    public static SimpleNetworkWrapper EFchannel = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MId);


    public static void init(){
        EFchannel.registerMessage(PacketJBTank.Handler.class, PacketJBTank.class, 1,Side.CLIENT);

    }

}
