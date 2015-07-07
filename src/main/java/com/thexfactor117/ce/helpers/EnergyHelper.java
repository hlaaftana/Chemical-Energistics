package com.thexfactor117.ce.helpers;

import com.thexfactor117.ce.init.CEItems;

import net.minecraft.item.ItemStack;

public class EnergyHelper 
{
	// base energy
	public static int crBaseEnergy = 25;
		
	// multipliers
	public static int hydrogenGas = 25 * 2;
	public static int lithiumGas = 25 * 6;
	public static int nitrogenGas = 25 * 3;
	public static int oxygenGas = 25 * 2;
	public static int sodiumGas = 25 * 4;
	public static int phosphorusGas = 25 * 6;
	public static int sulfurGas = 25 * 8;
	public static int iodineGas = 25 * 8;
	public static int mercuryGas = 25 * 10;
	public static int radonGas = 25 * 4;
		
	public static int lithiumLiquid = 25 * 3;
	public static int sodiumLiquid = 25 * 2;
	public static int aluminumLiquid = 25 * 3;
	public static int siliconLiquid = 25 * 2;
	public static int phosphorusLiquid = 25 * 3;
	public static int sulfurLiquid = 25 * 4;
	public static int ironLiquid = 25 * 2;
	public static int copperLiquid = 25 * 2;
	public static int silverLiquid = 25 * 3;
	public static int tinLiquid = 25 * 2;
	public static int iodineLiquid = 25 * 4;
	public static int goldLiquid = 25 * 3;
	public static int mercuryLiquid = 25 * 5;
	public static int leadLiquid = 25 * 3;
	public static int uraniumLiquid = 25 * 7;
	
	/**
	 * Instance checks for energy gen.
	 */
	public static int capsuleEnergyGen(ItemStack stack)
	{				
		LogHelper.info("checkCapsuleMultiplier...");
		
		if (stack != null)
		{
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 0)
			{
				return 25 * EnergyHelper.hydrogenGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 1)
			{
				return 25 * EnergyHelper.lithiumGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 2)
			{
				return 25 * EnergyHelper.nitrogenGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 3)
			{
				return 25 * EnergyHelper.oxygenGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 4)
			{
				return 25 * EnergyHelper.sodiumGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 5)
			{
				return 25 * EnergyHelper.phosphorusGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 6)
			{
				return 25 * EnergyHelper.sulfurGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 7)
			{
				return 25 * EnergyHelper.iodineGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 8)
			{
				return 25 * EnergyHelper.mercuryGas;
			}
			
			if (stack.getItem() == CEItems.gasCapsule && stack.getItemDamage() == 9)
			{
				return 25 * EnergyHelper.radonGas;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 0)
			{
				return 25 * EnergyHelper.lithiumLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 1)
			{
				return 25 * EnergyHelper.sodiumLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 2)
			{
				return 25 * EnergyHelper.aluminumLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 3)
			{
				return 25 * EnergyHelper.siliconLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 4)
			{
				return 25 * EnergyHelper.phosphorusLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 5)
			{
				return 25 * EnergyHelper.sulfurLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 6)
			{
				return 25 * EnergyHelper.ironLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 7)
			{
				return 25 * EnergyHelper.copperLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 8)
			{
				return 25 * EnergyHelper.silverLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 9)
			{
				return 25 * EnergyHelper.tinLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 10)
			{
				return 25 * EnergyHelper.iodineLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 11)
			{
				return 25 * EnergyHelper.goldLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 12)
			{
				return 25 * EnergyHelper.mercuryLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 13)
			{
				return 25 * EnergyHelper.leadLiquid;
			}
			
			if (stack.getItem() == CEItems.liquidCapsule && stack.getItemDamage() == 14)
			{
				return 25 * EnergyHelper.uraniumLiquid;
			}
		}
		
		return 0;
	}
}
