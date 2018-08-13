package com.thexfactor117.ce.init;

import com.thexfactor117.ce.fluids.*;
import com.thexfactor117.ce.helpers.RegisterHelper;
import net.minecraftforge.fluids.Fluid;

public class CEFluids {
	public static Fluid mercury = new FluidMercury();

	public static void registerFluids() {
		RegisterHelper.registerFluid(mercury);
	}
}
