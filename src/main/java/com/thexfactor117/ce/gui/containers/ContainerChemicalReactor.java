package com.thexfactor117.ce.gui.containers;

import com.thexfactor117.ce.tiles.machines.TileChemicalReactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * @author TheXFactor117
 */
public class ContainerChemicalReactor extends ContainerMachine<TileChemicalReactor> {
	public ContainerChemicalReactor(EntityPlayer player, TileChemicalReactor te) {
		super(player, te);

		this.addSlotToContainer(new Slot(machine, 0, 81, 34));

		super.addSlots();
	}
}
