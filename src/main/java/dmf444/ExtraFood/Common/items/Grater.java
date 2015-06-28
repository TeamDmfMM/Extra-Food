package dmf444.ExtraFood.Common.items;

import net.minecraft.item.ItemStack;

public class Grater extends StanItem {
	
	public Grater()
	{
        super();
        this.maxStackSize = 1;
        //this.setTextureName("extrafood:grater");
        this.setContainerItem(this);
    }
    
    public boolean hasContainerItem(ItemStack itemstack)
    {
    	return false;
    }
}
