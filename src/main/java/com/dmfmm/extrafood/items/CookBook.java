package com.dmfmm.extrafood.items;

import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.client.gui.cookbook.CookBookGUI;
import com.dmfmm.extrafood.library.ItemLib;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookBook extends GenericItem {

    public CookBook() {
        super(ItemLib.COOKBOOK);
        //this.setTextureName("extrafood:Cookbook");

        if(ExtraFood.side == Side.CLIENT){
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName().toString(), "inventory"));
        }
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        // open the inventory:
        player.openGui(ExtraFood.INSTANCE, CookBookGUI.GUI_ID, world, 0, 0, 0);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
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
