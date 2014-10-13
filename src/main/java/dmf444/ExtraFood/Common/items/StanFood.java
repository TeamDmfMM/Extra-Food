package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Core.EFTabs;
import dmf444.ExtraFood.util.EFLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class StanFood extends ItemFood {
	

	public StanFood(int foodBar, float saturation, boolean WolfFood){
		super(foodBar, saturation, WolfFood);
		this.setCreativeTab(EFTabs.INSTANCE);
	}
	public StanFood(int foodBar, float saturation){
		super(foodBar, saturation, false);
		this.setCreativeTab(EFTabs.INSTANCE);
	}


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("extrafood:" + this.getUnlocalizedName().substring(5)); 
    }
    



}
