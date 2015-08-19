package com.thexfactor117.ce.init;

import com.thexfactor117.ce.fluids.*;

import net.minecraftforge.fluids.Fluid;

public class CEFluids{
	public static Fluid fluidExample = new FluidExample();
	public static void registerFluids(){
		RegisterHelper.registerFluid(fluidExample);
	}
}
