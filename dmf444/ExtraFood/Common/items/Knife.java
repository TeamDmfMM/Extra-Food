package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import dmf444.ExtraFood.Core.EFTabs;

public class Knife extends StanItem {

	
	public Knife(int id)
	{
        super(id);
        this.maxStackSize = 1;
        this.setMaxDamage(10);
        this.setTextureName("extrafood:knife");
    }
	
	public boolean isRepariable() {
		return false;
	}
	
	@Override
	public ItemStack getContainerItemStack(ItemStack itemstack) {
		 ItemStack copiedStack = itemstack.copy();

	        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
	        copiedStack.stackSize = 1;
	        return copiedStack;
	}

    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) 
    {
    	return false;
    }
    
    public boolean getShareTag()
    {
        return true;
    }
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
}

