package dmf444.ExtraFood.Common.blocks;


import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockJuiceMixer extends BlockContainer{

    protected BlockJuiceMixer() {
        super(Material.iron);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        // TODO Auto-generated method stub
        return new JuiceMixerTileEntity();
    }
    public int getRenderType() {
        return -1;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
        return false;
    }


}