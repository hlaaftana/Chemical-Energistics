package com.thexfactor117.ce.handlers;

import com.thexfactor117.ce.gui.client.GuiCatalyticReactor;
import com.thexfactor117.ce.gui.client.GuiChemicalReactor;
import com.thexfactor117.ce.gui.client.GuiElementDiffuser;
import com.thexfactor117.ce.gui.client.GuiElementExtractor;
import com.thexfactor117.ce.gui.containers.ContainerCatalyticReactor;
import com.thexfactor117.ce.gui.containers.ContainerChemicalReactor;
import com.thexfactor117.ce.gui.containers.ContainerElementDiffuser;
import com.thexfactor117.ce.gui.containers.ContainerElementExtractor;
import com.thexfactor117.ce.tiles.machines.TileCatalyticReactor;
import com.thexfactor117.ce.tiles.machines.TileChemicalReactor;
import com.thexfactor117.ce.tiles.machines.TileElementDiffuser;
import com.thexfactor117.ce.tiles.machines.TileElementExtractor;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author TheXFactor117
 */
public class GuiHandler implements IGuiHandler {
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
			return new ContainerChemicalReactor(player, chemicalReactor);
		case 1:
			TileElementDiffuser elementDiffuser = (TileElementDiffuser) world.getTileEntity(x, y, z);
			return new ContainerElementDiffuser(player, elementDiffuser);
		case 2:
			TileElementExtractor elementExtractor = (TileElementExtractor) world.getTileEntity(x, y, z);
			return new ContainerElementExtractor(player, elementExtractor);
		case 3:
			TileCatalyticReactor elementExtractor = (TileCatalyticReactor) world.getTileEntity(x, y, z);
			return new ContainerCatalyticReactor(player, elementExtractor);
		default:
			return null;
		}
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
				return new GuiChemicalReactor(player, chemicalReactor);
			case 1:
				TileElementDiffuser elementDiffuser = (TileElementDiffuser) world.getTileEntity(x, y, z);
				return new GuiElementDiffuser(player, elementDiffuser);
			case 2:
				TileElementExtractor elementExtractor = (TileElementExtractor) world.getTileEntity(x, y, z);
				return new GuiElementExtractor(player, elementExtractor);
			case 3:
				TileCatalyticReactor elementExtractor = (TileCatalyticReactor) world.getTileEntity(x, y, z);
				return new GuiCatalyticReactor(player, elementExtractor);
			default:
				return null;
		}
	}
}
