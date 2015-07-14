package com.thexfactor117.ce.gui.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.gui.containers.ContainerElementExtractor;
import com.thexfactor117.ce.tiles.machines.TileElementExtractor;

public class GuiElementExtractor extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/machines/elementDiffuser.png");
    private InventoryPlayer inventory;
	private TileElementExtractor tile;
	
	public GuiElementExtractor(EntityPlayer player, TileElementExtractor tile)
    {
    	super(new ContainerElementExtractor(player, tile));
    	this.inventory = player.inventory;
    	this.tile = tile;
    }
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float gameTicks)
    {
    	super.drawScreen(mouseX, mouseY, gameTicks);
    	
    	drawToolTips(mouseX, mouseY);
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
 
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize); // main background
    }
	
	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	super.drawGuiContainerForegroundLayer(par1, par2);
    	
    	int x = 138; // energy background x-start
    	int y = 18; // energy background y-start
    	
    	fontRendererObj.drawString(I18n.format(tile.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(tile.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, 70, 4210752);
        
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawBar(x, y, tile.storage.getMaxEnergyStored(), tile.storage.getEnergyStored());
    }
	
	protected void drawToolTips(int mouseX, int mouseY)
    {
    	if (isPointInRegion(136, 17, 18, 49, mouseX, mouseY))
    	{
    		int energyStored = tile.storage.getEnergyStored();
    		int maxEnergyStored = tile.storage.getMaxEnergyStored();
    		this.drawBarTooltip("RF", energyStored, maxEnergyStored, mouseX, mouseY);
    	}
    }
    
    protected final void drawBar(int x, int y, int max, int current)
    {
    	int barWidth = 16;
    	int barHeight = 48;
    	int size = (int)(current * (long)barHeight / max);
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    	drawTexturedModalRect(x, y, 179, size, barWidth, barHeight);
    }
    
    protected void drawBarTooltip(String unit, int value, int max, int x, int y)
	{
		List<String> lines = new ArrayList<String>(2);
		String m = String.valueOf(max);
		String v = String.valueOf(value);
		
		lines.add(v + " / " + m + " " + unit);
		drawTooltip(lines, x, y);
	}
    
    protected boolean isPointInRegion(int x, int y, int w, int h, int a, int b) 
    {
		return func_146978_c(x, y, w, h, a, b);
	}
    
    protected void drawTooltip(List<String> lines, int x, int y)
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		int tooltipWidth = 0;
		int tempWidth;
		int xStart;
		int yStart;
		
		for(int i = 0; i < lines.size(); i++)
		{
			tempWidth = this.fontRendererObj.getStringWidth(lines.get(i));
			
			if(tempWidth > tooltipWidth)
			{
				tooltipWidth = tempWidth;
			}
		}
		
		xStart = x + 12;
		yStart = y - 12;
		int tooltipHeight = 8;
		
		if(lines.size() > 1)
		{
			tooltipHeight += 2 + (lines.size() - 1) * 10;
		}
		
		if(this.guiTop + yStart + tooltipHeight + 6 > this.height)
		{
			yStart = this.height - tooltipHeight - this.guiTop - 6;
		}
		
		this.zLevel = 300.0F;
		itemRender.zLevel = 300.0F;
		int color1 = -267386864;
		this.drawGradientRect(xStart - 3, yStart - 4, xStart + tooltipWidth + 3, yStart - 3, color1, color1);
		this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 4, color1, color1);
		this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color1, color1);
		this.drawGradientRect(xStart - 4, yStart - 3, xStart - 3, yStart + tooltipHeight + 3, color1, color1);
		this.drawGradientRect(xStart + tooltipWidth + 3, yStart - 3, xStart + tooltipWidth + 4, yStart + tooltipHeight + 3, color1, color1);
		int color2 = 1347420415;
		int color3 = (color2 & 16711422) >> 1 | color2 & -16777216;
		this.drawGradientRect(xStart - 3, yStart - 3 + 1, xStart - 3 + 1, yStart + tooltipHeight + 3 - 1, color2, color3);
		this.drawGradientRect(xStart + tooltipWidth + 2, yStart - 3 + 1, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3 - 1, color2, color3);
		this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart - 3 + 1, color2, color2);
		this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 2, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color3, color3);
		
		for(int stringIndex = 0; stringIndex < lines.size(); ++stringIndex)
		{
			String line = lines.get(stringIndex);
			
			if(stringIndex == 0)
			{
				line = "\u00a7" + Integer.toHexString(15) + line;
			}
			else
			{
				line = "\u00a77" + line;
			}
			
			this.fontRendererObj.drawStringWithShadow(line, xStart, yStart, -1);
			
			if(stringIndex == 0)
			{
				yStart += 2;
			}
			
			yStart += 10;
		}
		
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		
		this.zLevel = 0.0F;
		itemRender.zLevel = 0.0F;
	}
}
