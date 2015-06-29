/*
 *******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 *******************************************************************************
 */
package forestry.api.core;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public interface IErrorState {
	
	short getID();
	
	String getUniqueName();

	String getDescription();

	String getHelp();

	@SideOnly(Side.CLIENT)
	void registerIcons(Item register);

	@SideOnly(value = Side.CLIENT)
    Item getIcon();

}
