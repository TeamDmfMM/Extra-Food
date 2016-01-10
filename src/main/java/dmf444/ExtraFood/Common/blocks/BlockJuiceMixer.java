package dmf444.ExtraFood.Common.blocks;


import com.google.common.collect.Lists;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJuiceMixer extends BlockContainer {

    protected BlockJuiceMixer() {
        super(Material.iron);
        this.setCreativeTab(EFTabs.INSTANCE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        // TODO Auto-generated method stub
        return new JuiceMixerTileEntity();
    }
   /* public int getRenderType() {
        return -1;
    }*/

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

}