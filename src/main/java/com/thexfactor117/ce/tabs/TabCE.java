package com.thexfactor117.ce.tabs;

import com.thexfactor117.ce.init.CEItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabCE extends CreativeTabs
{
	public String name;
	
	public TabCE(int i, String name)
	{
		super(i, name);
		this.name = name;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if (this.name == "tabCE")
		{
			return CEItems.ingotUranium;
		} 
			
		return null;
	}
}
