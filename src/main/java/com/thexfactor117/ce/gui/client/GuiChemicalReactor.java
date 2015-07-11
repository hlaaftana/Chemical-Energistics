package com.thexfactor117.ce.gui.client;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cofh.lib.util.helpers.MathHelper;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.gui.containers.ContainerChemicalReactor;
import com.thexfactor117.ce.tiles.TileEntityChemicalReactor;

public class GuiChemicalReactor extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/machines/chemicalReactor.png");
	private ResourceLocation energyBar = new ResourceLocation(Reference.MODID, "textures/gui/energy.png");
    private InventoryPlayer inventory;
	private TileEntityChemicalReactor tile;
    
    public GuiChemicalReactor(EntityPlayer player, TileEntityChemicalReactor tile)
    {
    	super(new ContainerChemicalReactor(player, tile));
    	this.inventory = player.inventory;
    	this.tile = tile;
    }
    
    @Override
    public void initGui()
    {
    	super.initGui();
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
 
    	xSize = 175;
    	ySize = 165;
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        int energy = getEnergy();
 
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize); // main background
        
        Minecraft.getMinecraft().renderEngine.bindTexture(energyBar);
        
        drawTexturedModalRect(x, y + 42 - energy, 16, 42 - energy, xSize, energy);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRendererObj.drawString(I18n.format(tile.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(tile.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, 128, 4210752);
    }
    
    public void addToolTip(List<String> list)
    {
    	list.add(tile.storage.getEnergyStored() + "/" + tile.storage.getMaxEnergyStored() + " RF");
    }
    
    public int getEnergy()
    {
    	if (tile.storage.getEnergyStored() <= 0)
    	{
    		return ySize;
    	}
    	
    	long fraction = (long)tile.storage.getEnergyStored() * ySize / tile.storage.getMaxEnergyStored();
    	
    	return tile.storage.getEnergyStored() > 0 ? Math.min(1, MathHelper.round(fraction)) : MathHelper.round(fraction);
    }
}
