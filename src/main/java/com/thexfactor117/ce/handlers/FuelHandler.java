package com.thexfactor117.ce.handlers;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		/*Item fuelItem = fuel.getItem();
		if(fuelItem == exampleItem){
			return 3200;
		}else{*/
		return 0;
		//}
	}
}
