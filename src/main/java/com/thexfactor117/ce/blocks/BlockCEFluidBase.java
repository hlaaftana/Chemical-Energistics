package com.thexfactor117.ce.blocks;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CETabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 *
 * @author Hlaaftana
 *
 */
public class BlockCEFluidBase extends BlockFluidClassic{
	/**
	 * 
	 * @param fluid The fluid that the block is going to use.
	 * @param color A color of type MapColor. Example: "MapColor.yellowColor"
	 */
	public BlockCEFluidBase(Fluid fluid, MapColor color) {
		super(fluid, new MaterialLiquid(color));
		setCreativeTab(CETabs.tabCE);
	}
	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
   
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
   
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_still");
            flowingIcon = register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_flowing");
    }
   
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
   
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }

}
