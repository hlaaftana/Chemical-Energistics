package com.thexfactor117.ce.handlers;

import com.thexfactor117.ce.init.CEItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.item.ItemStack;

/**
 * @author TheXFactor117
 */
public class CraftingHandler {
	@SubscribeEvent
	public void onHammerCrafting(ItemCraftedEvent event) {
		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			ItemStack ironHammer = event.craftMatrix.getStackInSlot(i);
			if (ironHammer != null && ironHammer.getItem() == CEItems.ironHammer) {
				ItemStack ironHammerModified = new ItemStack(CEItems.ironHammer, 2, ironHammer.getItemDamage() + 1);

				if (ironHammerModified.getItemDamage() >= ironHammerModified.getMaxDamage()) {
					ironHammerModified.stackSize--;
				}

				event.craftMatrix.setInventorySlotContents(i, ironHammerModified);
			}
		}
	}
}
