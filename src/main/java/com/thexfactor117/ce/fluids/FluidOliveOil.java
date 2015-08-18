package com.thexfactor117.ce.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.Fluid;

import com.thexfactor117.ce.init.ModFluids;
import com.thexfactor117.ce.tabs.ModTabs;

public class FluidExample extends Fluid{
	public static Block blockInstance = new BlockOliveOil();
	public FluidOliveOil() {
		super("fluidExample");
		setDensity(5000);
		setViscosity(3000);
	}
}
class BlockOliveOil extends OBBaseFluidBlock {
    public BlockOliveOil() {
            super(ModFluids.fluidExample, new MaterialLiquid(MapColor.yellowColor));
            setCreativeTab(ModTabs.tabCE);
    }
   
}
