package net.ce.items;

import net.ce.Reference;
import net.ce.init.CETabs;
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
