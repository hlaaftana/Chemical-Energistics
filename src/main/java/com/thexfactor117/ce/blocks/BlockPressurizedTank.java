package com.thexfactor117.ce.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.thexfactor117.ce.ChemicalEnergistics;
import com.thexfactor117.ce.helpers.LogHelper;
import com.thexfactor117.ce.init.CETabs;
import com.thexfactor117.ce.tiles.TileEntityPressurizedTank;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPressurizedTank extends BlockContainer 
{
	private static final String NAME = "pressurizedTank";
	private final Random rand = new Random();
	
	public BlockPressurizedTank()
	{
		super(Material.iron);
		this.setBlockName(NAME);
		this.setCreativeTab(CETabs.tabCE);
	}
	
	/**
	 * Called upon block activation (right-click)
	 * 
	 * When right-clicked, open the specified GUI
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float lx, float ly, float lz)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity != null && tileEntity instanceof TileEntityPressurizedTank)
		{
			// number indicates which GUI to open
			player.openGui(ChemicalEnergistics.instance, 0, world, x, y, z);
			LogHelper.info("Is GUI open?");
			
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int par6)
	{
		if (world.isRemote)
		{
			return;
		}
		
		ArrayList tankContents = new ArrayList();
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity != null && tileEntity instanceof TileEntityPressurizedTank)
		{
			TileEntityPressurizedTank pressurizedTank = (TileEntityPressurizedTank) tileEntity;
			
			for (int i = 0; i < pressurizedTank.getSizeInventory(); i++)
			{
				ItemStack stack = pressurizedTank.getStackInSlot(i);
				
				if (stack != null)
				{
					tankContents.add(stack.copy());
				}
			}
			
			for (int i = 0; i < tankContents.size(); i++)
			{
				EntityItem item = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5);
				item.setVelocity((rand.nextDouble() - 0.5) * 0.25, rand.nextDouble() * 0.5 * 0.25, (rand.nextDouble() - 0.5) * 0.25);
				world.spawnEntityInWorld(item);
			}
		}
	}
	
	public TileEntity createNewTileEntity(World world, int par2)
	{
		return new TileEntityPressurizedTank();
	}
}
