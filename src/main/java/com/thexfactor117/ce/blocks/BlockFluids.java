package com.thexfactor117.ce.blocks;

import com.thexfactor117.ce.init.CEFluids;

import net.minecraft.block.material.MapColor;
import net.minecraftforge.fluids.Fluid;

/**
 *
 * @author Hlaaftana
 *
 */
public class BlockFluids {
	public class BlockFluidExample extends BlockCEBaseFluid{
		public BlockFluidExample() {
			super(CEFluids.fluidExample, MapColor.yellowColor);
		}
	}
}
