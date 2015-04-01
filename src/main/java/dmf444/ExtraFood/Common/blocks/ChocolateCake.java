package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.EFTabs;
import net.minecraft.block.BlockCake;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ChocolateCake extends BlockCake{    

@SideOnly(Side.CLIENT)
private IIcon oneSide;
@SideOnly(Side.CLIENT)
private IIcon twoSide;
@SideOnly(Side.CLIENT)
private IIcon inside;
	protected ChocolateCake()
    {
		super();
       
    }
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ItemLoader.ChocolateCake;
    }
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        switch(side){
        	case 1:
        		return this.oneSide;
        	case 0:
        		return this.twoSide;
        	case 4:
        		if(meta > 0){
        			return this.inside;
        		} else{
        			return this.blockIcon;
        		}
        	};
        return this.blockIcon;
     }
    
		//return p_149691_1_ == 1 ? this.oneSide : (p_149691_1_ == 0 ? this.twoSide : (p_149691_2_ > 0 && p_149691_1_ == 4 ? this.inside : this.blockIcon));
   

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("extrafood:Cho_side");
        this.inside = p_149651_1_.registerIcon("extrafood:cake_inner");
        this.oneSide = p_149651_1_.registerIcon("extrafood:caketop");
        this.twoSide = p_149651_1_.registerIcon("minecraft:cake_bottom");
    }
}
