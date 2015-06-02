package net.ce.blocks;

import net.ce.Reference;
import net.ce.init.CETabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCE extends Block
{
	public BlockCE(String name, float hardness, float resistance, int harvestLevel, float lightLevel)
	{
		super(Material.rock);
		this.setBlockName(name);
		this.setBlockTextureName(Reference.MODID + ":" + name);
		this.setCreativeTab(CETabs.tabCE);
		this.setStepSound(soundTypeStone);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setLightLevel(lightLevel);
	}
}
