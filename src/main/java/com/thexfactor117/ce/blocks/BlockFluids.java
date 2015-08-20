package com.thexfactor117.ce.blocks;

import com.thexfactor117.ce.init.CEFluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 *
 * @author Hlaaftana
 *
 */
public class BlockFluids {
	public class BlockFluidMercury extends BlockCEFluidBase{
	    public DamageSource toxicity = new DamageSource("toxicity");
		public BlockFluidMercury() {
			super(CEFluids.mercury, MapColor.grayColor);
			setBlockName(CEFluids.mercury.getUnlocalizedName().substring(6));
		}
		public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
	    {
	        p_149670_5_.attackEntityFrom(toxicity, 2.0F);
	    }
	}
}
