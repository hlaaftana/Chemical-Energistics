package com.thexfactor117.ce.items;

import java.util.List;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.enums.ElementEnum;
import com.thexfactor117.ce.init.CEItems;
import com.thexfactor117.ce.init.CETabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class ItemLiquidCapsule extends Item 
{
	public static final String[] LIQUIDS = { "lithium", "sodium", "aluminum", "silicon", "phosphorus", "sulfur", "iron", "copper", "silver", "tin", "iodine", "gold", "mercury", "lead", "uranium" };
	protected IIcon[] icons = new IIcon[ItemLiquidCapsule.LIQUIDS.length];
	private ElementEnum element;
	
	public ItemLiquidCapsule(String name)
	{
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setContainerItem(CEItems.capsule);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
		this.setCreativeTab(CETabs.tabCE);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        int i = 0;

        for (final String name : ItemLiquidCapsule.LIQUIDS)
        {
            this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
        }
    }
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return this.getUnlocalizedName() + "." + ItemLiquidCapsule.LIQUIDS[itemStack.getItemDamage()];
    }

    @Override
    public IIcon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ItemLiquidCapsule.LIQUIDS.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld){
    	for (int i = 0; i < ItemGasCapsule.GASES.length; i++)
        {
    		if (stack.getItemDamage() == 0)
    			element = ElementEnum.LITHIUM;
    		if (stack.getItemDamage() == 1)
    			element = ElementEnum.SODIUM;
    		if (stack.getItemDamage() == 2) 
    			element = ElementEnum.ALUMINUM;
    		if (stack.getItemDamage() == 3)
    			element = ElementEnum.SILICON;
    		if (stack.getItemDamage() == 4)
    			element = ElementEnum.PHOSPHORUS;
    		if (stack.getItemDamage() == 5)
    			element = ElementEnum.SULFUR;
    		if (stack.getItemDamage() == 6)
    			element = ElementEnum.IRON;
    		if (stack.getItemDamage() == 7)
    			element = ElementEnum.COPPER;
	    	if (stack.getItemDamage() == 8)
	    		element = ElementEnum.SILVER;
	    	if (stack.getItemDamage() == 9)
	    		element = ElementEnum.TIN;
	    	if (stack.getItemDamage() == 10)
	    		element = ElementEnum.IODINE;
	    	if (stack.getItemDamage() == 11)
	    		element = ElementEnum.GOLD;
	    	if (stack.getItemDamage() == 12)
	    		element = ElementEnum.MERCURY;
	    	if (stack.getItemDamage() == 13)
	    		element = ElementEnum.LEAD;
	    	if (stack.getItemDamage() == 14)
	    		element = ElementEnum.URANIUM;
        	}
		list.add(EnumChatFormatting.GRAY + element.name + ", " + element.formula + ", " + element.atomicNumber);
    }
}
