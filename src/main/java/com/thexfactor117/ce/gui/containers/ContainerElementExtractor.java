package com.thexfactor117.ce.gui.containers;

import com.thexfactor117.ce.tiles.machines.TileElementExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * @author TheXFactor117
 */
public class ContainerElementExtractor extends ContainerMachine<TileElementExtractor> {
	public ContainerElementExtractor(EntityPlayer player, TileElementExtractor te) {
		super(player, te);

		this.addSlotToContainer(new Slot(machine, 0, 62, 34));
		this.addSlotToContainer(new Slot(machine, 1, 98, 34));

		super.addSlots();
	}
}
