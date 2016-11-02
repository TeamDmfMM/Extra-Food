package dmf444.ExtraFood.Common.blocks;


import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.BlockCake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChocolateCake extends BlockCake{    


	protected ChocolateCake()
    {
		super();
       
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ItemLoader.ChocolateCake, 1);
    }
    /*
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
    }*/
}
