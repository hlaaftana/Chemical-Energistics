package com.thexfactor117.ce.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.client.gui.containers.ContainerChemicalReactor;
import com.thexfactor117.ce.tiles.TileEntityChemicalReactor;

public class GuiChemicalReactor extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/machines/chemicalReactor.png");
	 
    private InventoryPlayer inventory;
	private TileEntityChemicalReactor chemicalReactor;
    
    public GuiChemicalReactor(EntityPlayer player, TileEntityChemicalReactor chemicalReactorTE)
    {
    	super(new ContainerChemicalReactor(player, chemicalReactorTE));
    	inventory = player.inventory;
    	this.chemicalReactor = chemicalReactorTE;
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
 
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRendererObj.drawString(I18n.format(chemicalReactor.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(chemicalReactor.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, 128, 4210752);
    }
}
