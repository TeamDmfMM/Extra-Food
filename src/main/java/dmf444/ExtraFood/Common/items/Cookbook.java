package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Cookbook extends StanItem {

	public Cookbook() {
		super();
		//this.setTextureName("extrafood:Cookbook");
		// TODO Auto-generated constructor stub
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {

				// open the inventory:
				player.openGui(ExtraFood.instance, CookBookGUI.GUI_ID, world, 0, 0, 0);
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
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




