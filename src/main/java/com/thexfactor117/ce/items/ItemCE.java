package com.thexfactor117.ce.items;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CETabs;

import net.minecraft.item.Item;

public class ItemCE extends Item
{
	public ItemCE(String name)
	{
		super();
		this.setCreativeTab(CETabs.tabCE);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
	}
}
