package com.thexfactor117.ce.tabs;

import com.thexfactor117.ce.init.CEItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author TheXFactor117
 */
public class TabCE extends CreativeTabs {
	public String name;

	public TabCE(int i, String name) {
		super(i, name);
		this.name = name;
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		if (this.name.equals("tabCE")) {
			return CEItems.ingotUranium;
		}

		return null;
	}
}
