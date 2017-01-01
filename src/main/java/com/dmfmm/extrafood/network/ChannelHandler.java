package com.dmfmm.extrafood.network;


import com.dmfmm.extrafood.library.ModInfo;
import com.dmfmm.extrafood.network.packets.PacketJBTank;
import com.dmfmm.extrafood.network.packets.PacketMakeDestroy;
import com.dmfmm.extrafood.network.packets.PacketReleaseFluid;
import com.dmfmm.extrafood.network.packets.PacketSelector;
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

    public static SimpleNetworkWrapper EFchannel = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_ID);


    public static void init(){
        EFchannel.registerMessage(PacketJBTank.Handler.class, PacketJBTank.class, 1,Side.CLIENT);
        EFchannel.registerMessage(PacketSelector.Handler.class, PacketSelector.class, 2, Side.SERVER);
        EFchannel.registerMessage(PacketMakeDestroy.Handler.class, PacketMakeDestroy.class, 3, Side.SERVER);
        EFchannel.registerMessage(PacketReleaseFluid.Handler.class, PacketReleaseFluid.class, 4, Side.SERVER);
    }

}