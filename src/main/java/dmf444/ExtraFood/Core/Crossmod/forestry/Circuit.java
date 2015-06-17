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

package dmf444.ExtraFood.Core.Crossmod.forestry;

import forestry.api.circuits.ChipsetManager;
import forestry.api.circuits.ICircuit;
import forestry.api.farming.IFarmHousing;
import forestry.api.farming.IFarmLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;

import java.util.List;

public class Circuit implements ICircuit{

	String uid; //managedBush
	int limit = 1;
	private Class<? extends IFarmLogic> logicClass;

	public Circuit(String uid, Class<? extends IFarmLogic> logicClass) {
		this.uid = uid;
		this.logicClass = logicClass;
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
	public String getName() {
		return "circuit." + this.uid;
	}

	@Override
	public void addTooltip(List<String> list) {
		list.add(StatCollector.translateToLocal(getName()));

		int i = 1;
		while (true) {
			String unlocalizedDescription = getName() + ".description." + i;
			String description = StatCollector.translateToLocal(unlocalizedDescription);
			if (description.endsWith(unlocalizedDescription))
				break;
			list.add(" - " + description);
			i++;
		}
	}

	public static ICircuit farmBushManaged;

	@Override
	public boolean isCircuitable(TileEntity tile) {
		return tile instanceof IFarmHousing;
	}
	IFarmHousing getCircuitable(TileEntity tile) { 
		 		if (!isCircuitable(tile)) 
					return null; 
		 		return (IFarmHousing)tile; 
	} 


	@Override
	@SuppressWarnings("rawtypes")
	public void onInsertion(int slot, TileEntity tile) {
		IFarmHousing housing = getCircuitable(tile);
		if (housing == null)
			return;

		IFarmLogic logic;
		try {
			logic = logicClass.getConstructor(new Class[] { IFarmHousing.class }).newInstance(housing);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to instantiate logic of class " + logicClass.getName() + ": " + ex.getMessage());
		}

		try {
			logic.setManual(false);
		} catch (Exception e) {
			// uses older version of the API that doesn't implement setManual
		}
		housing.setFarmLogic(EnumFacing.values()[slot + 2], logic);
	}


	@Override
	public void onLoad(int slot, TileEntity tile) {
		onInsertion(slot, tile);
		
	}

	@Override
	public void onRemoval(int slot, TileEntity tile) {
		if (!isCircuitable(tile))
			return;
		
		((IFarmHousing) tile).resetFarmLogic(EnumFacing.values()[slot + 2]);
		
	}

	@Override
	public void onTick(int slot, TileEntity tile) {
	}

}
