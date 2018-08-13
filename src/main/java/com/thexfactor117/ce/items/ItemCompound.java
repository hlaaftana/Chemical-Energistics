package com.thexfactor117.ce.items;

import com.thexfactor117.ce.enums.CompoundEnum;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemCompound extends ItemCE {
	private CompoundEnum compound;

	public ItemCompound(CompoundEnum compound) {
		super(compound.name.toLowerCase());
		this.compound = compound;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
		list.add(EnumChatFormatting.GRAY + compound.name + ", " + compound.formula);
		list.add(EnumChatFormatting.GRAY + compound.stateAtRoomTemperature);
		list.add(EnumChatFormatting.GRAY + "Components: " + compound.components[0] + ", " + compound.components[1]);
	}
}
