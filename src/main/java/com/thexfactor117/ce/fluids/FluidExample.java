package com.thexfactor117.ce.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidExample extends Fluid{
	public FluidExample() {
		super("fluidExample");
		setDensity(5000);
		setViscosity(3000);
	}
}
