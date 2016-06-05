/******************************************************************************* 
2  * Copyright (c) 2011-2014 SirSengir. 
3  * All rights reserved. This program and the accompanying materials 
4  * are made available under the terms of the GNU Lesser Public License v3 
5  * which accompanies this distribution, and is available at 
6  * http://www.gnu.org/licenses/lgpl-3.0.txt 
7  *  
8  * Various Contributors including, but not limited to: 
9  * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges 
						MODIFIED, SI YOU OWN IT, I'll REMOVE ON REQUEST------
10  ******************************************************************************/ 

package dmf444.ExtraFood.Core.Crossmod.Forestry;

import forestry.api.circuits.ChipsetManager;
import forestry.api.circuits.ICircuit;
import forestry.api.farming.FarmDirection;
import forestry.api.farming.IFarmHousing;
import forestry.api.farming.IFarmLogic;
import net.minecraft.util.text.translation.I18n;

import java.util.List;

public class Circuit implements ICircuit{

	String uid; //managedBush
	int limit = 1;
	private IFarmLogic logic;

	public Circuit(String uid, IFarmLogic logicClass) {
		this.uid = uid;
		this.logic = logicClass;
		setLimit(4);


		ChipsetManager.circuitRegistry.registerCircuit(this);
	}

	protected void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String getUID() {
		return "EF." + this.uid;
	}

	@Override
	public int getLimit() {
		return this.limit;
	}

	@Override
	public boolean requiresDiscovery() {
		return false;
	}

	@Override
	public String getUnlocalizedName() {
		return "circuit." + this.uid;
	}

	@Override
	public void addTooltip(List<String> list) {
		list.add(I18n.translateToLocal(getUnlocalizedName()));

		int i = 1;
		while (true) {
			String unlocalizedDescription = getUnlocalizedName() + ".description." + i;
			String description = I18n.translateToLocal(unlocalizedDescription);
			if (description.endsWith(unlocalizedDescription))
				break;
			list.add(" - " + description);
			i++;
		}
	}

	public static ICircuit farmBushManaged;

	@Override
	public boolean isCircuitable(Object tile) {
		return tile instanceof IFarmHousing;
	}
	IFarmHousing getCircuitable(Object tile) {
		 		if (!isCircuitable(tile)) 
					return null; 
		 		return (IFarmHousing)tile; 
	} 


	@Override
	@SuppressWarnings("rawtypes")
	public void onInsertion(int slot, Object tile) {
		IFarmHousing housing = getCircuitable(tile);
		if (housing == null)
			return;

		logic.setManual(false);
		housing.setFarmLogic(FarmDirection.values()[slot], logic);
	}


	@Override
	public void onLoad(int slot, Object tile) {
		onInsertion(slot, tile);
		
	}

	@Override
	public void onRemoval(int slot, Object tile) {
		if (!isCircuitable(tile))
			return;
		
		((IFarmHousing) tile).resetFarmLogic(FarmDirection.values()[slot]);
		
	}

	@Override
	public void onTick(int slot, Object tile) {
	}

}
