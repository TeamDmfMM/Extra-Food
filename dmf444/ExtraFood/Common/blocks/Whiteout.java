package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Whiteout extends Block {

	public Whiteout(int id) {
		super(id, Material.clay);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setTextureName("extrafood:The whiteout");
	}

	
}
