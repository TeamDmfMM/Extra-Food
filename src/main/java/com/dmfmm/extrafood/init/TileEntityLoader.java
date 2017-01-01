package com.dmfmm.extrafood.init;

import com.dmfmm.extrafood.library.BlockLib;
import com.dmfmm.extrafood.tileentities.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by TeamDMFMM on 1/1/2017. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class TileEntityLoader {


    public static void initTileEntity() {
        GameRegistry.registerTileEntity(CheesePressTileEntity.class, BlockLib.CHEESE_PRESS);
        GameRegistry.registerTileEntity(AutoCutterTileEntity.class, BlockLib.AUTO_CUTTER);
        GameRegistry.registerTileEntity(JuiceBlenderTileEntity.class, BlockLib.JUICE_BLENDER);
        GameRegistry.registerTileEntity(OvenTileEntity.class, BlockLib.OVEN);
        GameRegistry.registerTileEntity(JuiceMixerTileEntity.class, BlockLib.JUICE_MIXER);
    }
}
