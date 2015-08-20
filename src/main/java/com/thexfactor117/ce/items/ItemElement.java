package com.thexfactor117.ce.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.thexfactor117.ce.enums.ElementEnum;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Hlaaftana
 * THIS IS JUST A TEST FOR THE ELEMENT ENUM
 */
public class ItemElement extends ItemCE{
	private ElementEnum element;
	public ItemElement(ElementEnum element) {
		super(element.name.toLowerCase());
		this.element = element;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld){
		list.add(EnumChatFormatting.GRAY + element.name + ", " + element.formula + ", " + element.atomicNumber);
		list.add(EnumChatFormatting.GRAY + element.stateAtRoomTemperature);
	}
}
