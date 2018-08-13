package com.thexfactor117.ce.items;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CETabs;
import net.minecraft.item.Item;

/**
 * @author TheXFactor117
 */
public class ItemIronHammer extends Item {
	public ItemIronHammer(String name) {
		super();
		this.setCreativeTab(CETabs.tabCE);
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
