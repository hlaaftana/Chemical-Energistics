package com.thexfactor117.ce.gui.containers;

import com.thexfactor117.ce.tiles.machines.TileCatalyticReactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * @author TheXFactor117
 */
public class ContainerCatalyticReactor extends ContainerMachine<TileCatalyticReactor> {
	public ContainerCatalyticReactor(EntityPlayer player, TileCatalyticReactor te) {
		super(player, te);

		this.addSlotToContainer(new Slot(machine, 1, 97, 34));
		this.addSlotToContainer(new Slot(machine, 0, 63, 34));

		super.addSlots();
	}
}
