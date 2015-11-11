package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by dmf444 on 10/18/2015.
 */
public class OliveLeaf extends BananaLeaf{

    private IIcon[] iconArray = new IIcon[3];
    public OliveLeaf(){

    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if(rand.nextInt((10-1)+1) == 4 && world.getBlockMetadata(x, y, z) < 4){
            world.setBlockMetadataWithNotify(x, y ,z, world.getBlockMetadata(x, y, z)+1, 2);
        }

        super.updateTick(world, x, y, z, rand);
    }
    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockLoader.oliveBush);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if(meta < 4){
            return false;
        } else{
            if(!world.isRemote) {
                EntityItem olives = new EntityItem(world, x, y, z, new ItemStack(ItemLoader.olive));
                world.spawnEntityInWorld(olives);

            }
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1)
    {
        iconArray[0] = par1.registerIcon("extrafood:Plants/olivebush_stage0");
        iconArray[1] = par1.registerIcon("extrafood:Plants/olivebush_stage1");
        iconArray[2] = par1.registerIcon("extrafood:Plants/olivebush_stage2");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        switch(meta){
            case 0:
                return iconArray[0];
            case 1:
                return iconArray[0];
            case 2:
                return iconArray[1];
            case 3:
                return iconArray[1];
            case 4:
                return iconArray[2];
            default:
                return iconArray[0];
        }
    }

}
