package com.thexfactor117.ce.gui.containers;

import com.thexfactor117.ce.tiles.machines.TileElementDiffuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * @author TheXFactor117
 */
public class ContainerElementDiffuser extends ContainerMachine<TileElementDiffuser> {
	public ContainerElementDiffuser(EntityPlayer player, TileElementDiffuser te) {
		super(player, te);

		this.addSlotToContainer(new Slot(machine, 0, 63, 34));
		this.addSlotToContainer(new Slot(machine, 1, 97, 34));

		super.addSlots();
	}
}
