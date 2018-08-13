package com.thexfactor117.ce.items;

import com.thexfactor117.ce.enums.ElementEnum;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemElement extends ItemCE {
	private ElementEnum element;

	public ItemElement(ElementEnum element) {
		super(element.name.toLowerCase());
		this.element = element;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
		list.add(EnumChatFormatting.GRAY + element.name + ", " + element.formula + ", " + element.atomicNumber);
		list.add(EnumChatFormatting.GRAY + element.stateAtRoomTemperature);
	}
}
