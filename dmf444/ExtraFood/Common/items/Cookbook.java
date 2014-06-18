package dmf444.ExtraFood.Common.items;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Core.ExtraFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Cookbook extends StanItem {

	public Cookbook(int id) {
		super(id);
		this.setTextureName("extrafood:Cookbook");
		// TODO Auto-generated constructor stub
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

				// open the inventory:
				player.openGui(ExtraFood.instance, CookBookGUI.GUI_ID, world, 0, 0, 0);
		return stack;
		}
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return false;
    }
}




