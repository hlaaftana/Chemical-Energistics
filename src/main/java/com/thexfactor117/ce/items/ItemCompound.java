package com.thexfactor117.ce.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.thexfactor117.ce.enums.CompoundEnum;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Hlaaftana
 * THIS IS JUST A TEST FOR THE COMPOUND ENUM
 */
public class ItemCompound extends ItemCE{
	private CompoundEnum compound;
	public ItemCompound(CompoundEnum compound) {
		super(compound.name.toLowerCase());
		this.compound = compound;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld){
		list.add(EnumChatFormatting.GRAY + compound.name + ", " + compound.formula);
		list.add(EnumChatFormatting.GRAY + compound.stateAtRoomTemperature);
		list.add(EnumChatFormatting.GRAY + "Components: " + compound.components[0] + ", " + compound.components[1]);
	}
}
