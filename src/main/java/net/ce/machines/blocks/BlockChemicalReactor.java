package net.ce.machines.blocks;

import net.ce.Reference;
import net.ce.helpers.EnergyStorage;
import net.ce.init.CETabs;
import net.ce.machines.tiles.TileEntityChemicalReactor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockChemicalReactor extends BlockContainer implements ITileEntityProvider
{
	protected final int[] maxEnergyGeneration;
	protected final int[] maxEnergyTransfer;
	protected final int[] capacity;
	private static final String NAME = "chemicalReactor";
	
	public BlockChemicalReactor(int[] maxEnergyGeneration, int[] capacity)
	{
		super(Material.iron);
		this.setHardness(3.5F);
		this.setStepSound(soundTypeMetal);
		this.maxEnergyGeneration = maxEnergyGeneration;
		/**
		 * Make a duplicate of the energy generation array and multiply the values by
		 * the transfer multiplier, since an assignment doesn't duplicate the array in Java
		 */
		this.maxEnergyTransfer = new int[maxEnergyGeneration.length];
		System.arraycopy(maxEnergyGeneration, 0, maxEnergyTransfer, 0, maxEnergyGeneration.length);
		
		for (int i = 0; i < maxEnergyGeneration.length; i++)
		{
			this.maxEnergyTransfer[i] *= 40;
		}
		
		this.capacity = capacity;
		this.setBlockName(Reference.MODID + ":" + NAME);
		this.setCreativeTab(CETabs.tabCE);
	}
	
	/*@Override
    public void registerBlockIcons(IIconRegister pIconRegister) 
	{
        for(int i = 0; i < maxMeta; ++i) {
            icons[i] = pIconRegister.registerIcon(Constants.MODID + ":" + name + (i+1) + "Side");
        }
    }*/
	
	/*@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int pSide, int pMeta) 
	{
        return icons[pMeta];
    }*/

    @Override
    public TileEntity createNewTileEntity(World world, int meta) 
    {
        return new TileEntityChemicalReactor(maxEnergyGeneration[meta], maxEnergyTransfer[meta], capacity[meta]);
    }
    
    @Override
    public boolean hasTileEntity(int metadata) 
    {
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) 
    {
        // If the ItemBlock version has energy stored in it then give the newly
        // created tile entity that energy
        if(stack.stackTagCompound != null) 
        {
        	TileEntityChemicalReactor tileEntity = (TileEntityChemicalReactor)world.getTileEntity(x, y, z);
            tileEntity.setEnergyStored(stack.stackTagCompound.getInteger(EnergyStorage.NBT_ENERGY));
        }
        
        super.onBlockPlacedBy(world, x, y, z, entity, stack);
    }
}
