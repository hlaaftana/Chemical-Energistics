package com.thexfactor117.ce.items;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CETabs;
import net.minecraft.item.Item;

/**
 * @author TheXFactor117
 */
public class ItemAluminaCatalyst extends Item {
	public ItemAluminaCatalyst(String name) {
		super();
		this.setCreativeTab(CETabs.tabCE);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
		this.setMaxDamage(64);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
}
