package com.thexfactor117.ce.helpers;

import com.thexfactor117.ce.init.CEItems;
import net.minecraft.item.ItemStack;

/**
 * @author TheXFactor117
 */
public class EnergyHelper {
	// items
	public static ItemStack
		hydrogenGas = new ItemStack(CEItems.gasCapsule, 1, 0),
		lithiumGas = new ItemStack(CEItems.gasCapsule, 1, 1),
		nitrogenGas = new ItemStack(CEItems.gasCapsule, 1, 2),
		oxygenGas = new ItemStack(CEItems.gasCapsule, 1, 3),
		sodiumGas = new ItemStack(CEItems.gasCapsule, 1, 4),
		phosphorusGas = new ItemStack(CEItems.gasCapsule, 1, 5),
		sulfurGas = new ItemStack(CEItems.gasCapsule, 1, 6),
		iodineGas = new ItemStack(CEItems.gasCapsule, 1, 7),
		mercuryGas = new ItemStack(CEItems.gasCapsule, 1, 8),
		radonGas = new ItemStack(CEItems.gasCapsule, 1, 9);

	public static ItemStack
		lithiumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 0),
		sodiumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 1),
		aluminumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 2),
		siliconLiquid = new ItemStack(CEItems.liquidCapsule, 1, 3),
		phosphorusLiquid = new ItemStack(CEItems.liquidCapsule, 1, 4),
		sulfurLiquid = new ItemStack(CEItems.liquidCapsule, 1, 5),
		ironLiquid = new ItemStack(CEItems.liquidCapsule, 1, 6),
		copperLiquid = new ItemStack(CEItems.liquidCapsule, 1, 7),
		silverLiquid = new ItemStack(CEItems.liquidCapsule, 1, 8),
		tinLiquid = new ItemStack(CEItems.liquidCapsule, 1, 9),
		iodineLiquid = new ItemStack(CEItems.liquidCapsule, 1, 10),
		goldLiquid = new ItemStack(CEItems.liquidCapsule, 1, 11),
		mercuryLiquid = new ItemStack(CEItems.liquidCapsule, 1, 12),
		leadLiquid = new ItemStack(CEItems.liquidCapsule, 1, 13),
		uraniumLiquid = new ItemStack(CEItems.liquidCapsule, 1, 14);

	// base energy
	public static int crBaseEnergy = 10;

	/**
	 * Instance checks for energy gen.
	 */
	public static int getCapsuleEnergyGen(ItemStack stack) {
		if (stack == null) return 0;

		if (stack.isItemEqual(hydrogenGas)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(lithiumGas)) {
			return crBaseEnergy * 7;
		}

		if (stack.isItemEqual(nitrogenGas)) {
			return crBaseEnergy * 4;
		}

		if (stack.isItemEqual(oxygenGas)) {
			return crBaseEnergy * 1;
		}

		if (stack.isItemEqual(sodiumGas)) {
			return crBaseEnergy * 4;
		}

		if (stack.isItemEqual(phosphorusGas)) {
			return crBaseEnergy * 8;
		}

		if (stack.isItemEqual(sulfurGas)) {
			return crBaseEnergy * 7;
		}

		if (stack.isItemEqual(iodineGas)) {
			return crBaseEnergy * 9;
		}

		if (stack.isItemEqual(mercuryGas)) {
			return crBaseEnergy * 8;
		}

		if (stack.isItemEqual(radonGas)) {
			return crBaseEnergy * 10;
		}

		if (stack.isItemEqual(lithiumLiquid)) {
			return crBaseEnergy * 3;
		}

		if (stack.isItemEqual(sodiumLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(aluminumLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(siliconLiquid)) {
			return crBaseEnergy * 1;
		}

		if (stack.isItemEqual(phosphorusLiquid)) {
			return crBaseEnergy * 4;
		}

		if (stack.isItemEqual(sulfurLiquid)) {
			return crBaseEnergy * 4;
		}

		if (stack.isItemEqual(ironLiquid)) {
			return crBaseEnergy * 1;
		}

		if (stack.isItemEqual(copperLiquid)) {
			return crBaseEnergy * 1;
		}

		if (stack.isItemEqual(silverLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(tinLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(iodineLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(goldLiquid)) {
			return crBaseEnergy * 3;
		}

		if (stack.isItemEqual(mercuryLiquid)) {
			return crBaseEnergy * 5;
		}

		if (stack.isItemEqual(leadLiquid)) {
			return crBaseEnergy * 2;
		}

		if (stack.isItemEqual(uraniumLiquid)) {
			return crBaseEnergy * 9;
		}

		return 0;
	}
}
