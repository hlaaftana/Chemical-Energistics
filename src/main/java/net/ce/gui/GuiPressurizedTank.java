package net.ce.gui;

import net.ce.Reference;
import net.ce.gui.containers.ContainerPressurizedTank;
import net.ce.machines.tiles.TileEntityPressurizedTank;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiPressurizedTank extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/machines/pressurizedTank.png");
	 
    private InventoryPlayer inventory;
    private TileEntityPressurizedTank pressurizedTank;
    
    public GuiPressurizedTank(EntityPlayer player, TileEntityPressurizedTank pressurizedTankTE)
    {
    	super(new ContainerPressurizedTank(player, pressurizedTankTE));
    	inventory = player.inventory;
    	this.pressurizedTank = pressurizedTankTE;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
 
    	xSize = 184;
    	ySize = 238; //202
    	
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
 
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRendererObj.drawString(I18n.format(pressurizedTank.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(pressurizedTank.getInventoryName())) / 2), 6, 4210752, false);
        fontRendererObj.drawString(I18n.format(inventory.getInventoryName()), 8, 128, 4210752);
    }
}
