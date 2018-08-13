package com.thexfactor117.ce.fluids;

import com.thexfactor117.ce.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

public class FluidMercury extends Fluid {
	private IIcon stillIcon, flowingIcon;

	public FluidMercury() {
		super("mercury");
		setDensity(7000);
		setViscosity(5000);
		setIcons(stillIcon, flowingIcon);
	}

	public void registerIcons(IIconRegister register) {
		stillIcon = register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(6) + "_still");
		flowingIcon = register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(6) + "_still");
	}
}
