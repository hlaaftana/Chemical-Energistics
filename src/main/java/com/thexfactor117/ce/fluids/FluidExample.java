package com.thexfactor117.ce.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.Fluid;

import com.thexfactor117.ce.init.CEFluids;
import com.thexfactor117.ce.tabs.CETabs;

public class FluidExample extends Fluid{
	public FluidExample() {
		super("fluidExample");
		setDensity(5000);
		setViscosity(3000);
	}
}
