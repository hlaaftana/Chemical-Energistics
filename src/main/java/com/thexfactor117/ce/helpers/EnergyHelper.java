package com.thexfactor117.ce.helpers;

import com.thexfactor117.ce.init.CEItems;

import net.minecraft.item.ItemStack;

public class EnergyHelper 
{
	// items
	public static ItemStack hydrogenGas = new ItemStack(CEItems.gasCapsule, 1, 0);
	public static ItemStack lithiumGas = new ItemStack(CEItems.gasCapsule, 1, 1);
	public static ItemStack nitrogenGas = new ItemStack(CEItems.gasCapsule, 1, 2);
	public static ItemStack oxygenGas = new ItemStack(CEItems.gasCapsule, 1, 3);
	public static ItemStack sodiumGas = new ItemStack(CEItems.gasCapsule, 1, 4);
	public static ItemStack phosphorusGas = new ItemStack(CEItems.gasCapsule, 1, 5);
	public static ItemStack sulfurGas = new ItemStack(CEItems.gasCapsule, 1, 6);
	public static ItemStack iodineGas = new ItemStack(CEItems.gasCapsule, 1, 7);
	public static ItemStack mercuryGas = new ItemStack(CEItems.gasCapsule, 1, 8);
	public static ItemStack radonGas = new ItemStack(CEItems.gasCapsule, 1, 9);
	
	public static ItemStack lithiumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 0);
	public static ItemStack sodiumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 1);
	public static ItemStack aluminumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 2);
	public static ItemStack siliconLiquid = new ItemStack(CEItems.liquidCapsule, 1, 3);
	public static ItemStack phosphorusLiquid = new ItemStack(CEItems.liquidCapsule, 1, 4);
	public static ItemStack sulfurLiquid = new ItemStack(CEItems.liquidCapsule, 1, 5);
	public static ItemStack ironLiquid = new ItemStack(CEItems.liquidCapsule, 1, 6);
	public static ItemStack copperLiquid = new ItemStack(CEItems.liquidCapsule, 1, 7);
	public static ItemStack silverLiquid = new ItemStack(CEItems.liquidCapsule, 1, 8);
	public static ItemStack tinLiquid = new ItemStack(CEItems.liquidCapsule, 1, 9);
	public static ItemStack iodineLiquid = new ItemStack(CEItems.liquidCapsule, 1, 10);
	public static ItemStack goldLiquid = new ItemStack(CEItems.liquidCapsule, 1, 11);
	public static ItemStack mercuryLiquid = new ItemStack(CEItems.liquidCapsule, 1, 12);
	public static ItemStack leadLiquid = new ItemStack(CEItems.liquidCapsule, 1, 13);
	public static ItemStack uraniumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 14);
	
	// base energy
	public static int crBaseEnergy = 10;
	
	/**
	 * Instance checks for energy gen.
	 */
	public static int capsuleEnergyGen(ItemStack stack)
	{				
		if (stack != null)
		{
			if (stack.isItemEqual(hydrogenGas))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(lithiumGas))
			{
				return crBaseEnergy * 6;
			}
			
			if (stack.isItemEqual(nitrogenGas))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(oxygenGas))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(sodiumGas))
			{
				return crBaseEnergy * 4;
			}
			
			if (stack.isItemEqual(phosphorusGas))
			{
				return crBaseEnergy * 6;
			}
			
			if (stack.isItemEqual(sulfurGas))
			{
				return crBaseEnergy * 8;
			}
			
			if (stack.isItemEqual(iodineGas))
			{
				return crBaseEnergy * 8;
			}
			
			if (stack.isItemEqual(mercuryGas))
			{
				return crBaseEnergy * 10;
			}
			
			if (stack.isItemEqual(radonGas))
			{
				return crBaseEnergy * 4;
			}
			
			if (stack.isItemEqual(lithiumLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(sodiumLiquid))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(aluminumLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(siliconLiquid))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(phosphorusLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(sulfurLiquid))
			{
				return crBaseEnergy * 4;
			}
			
			if (stack.isItemEqual(ironLiquid))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(copperLiquid))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(silverLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(tinLiquid))
			{
				return crBaseEnergy * 2;
			}
			
			if (stack.isItemEqual(iodineLiquid))
			{
				return crBaseEnergy * 4;
			}
			
			if (stack.isItemEqual(goldLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(mercuryLiquid))
			{
				return crBaseEnergy * 5;
			}
			
			if (stack.isItemEqual(leadLiquid))
			{
				return crBaseEnergy * 3;
			}
			
			if (stack.isItemEqual(uraniumLiquid))
			{
				return crBaseEnergy * 7;
			}
		}
		
		return 0;
	}
}
