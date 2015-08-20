package com.thexfactor117.ce.items;

import java.util.List;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CEItems;
import com.thexfactor117.ce.init.CETabs;
import com.thexfactor117.ce.enums.CompoundEnum;
import com.thexfactor117.ce.enums.ElementEnum;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemGasCapsule extends Item 
{
	public static final String[] GASES = { "hydrogen", "lithium", "nitrogen", "oxygen", "sodium", "phosphorus", "sulfur", "iodine", "mercury", "radon", "water" };
	protected IIcon[] icons = new IIcon[ItemGasCapsule.GASES.length];
	protected ElementEnum element;
	protected CompoundEnum compound;
	
	//You can maybe use the ElementEnum to register icons
	public ItemGasCapsule(String name){
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setContainerItem(CEItems.capsule);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
		this.setCreativeTab(CETabs.tabCECapsules);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
		int i = 0;

        for (final String name : ItemGasCapsule.GASES)
        {
            this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
        }
    }
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return this.getUnlocalizedName() + "." + ItemGasCapsule.GASES[itemStack.getItemDamage()];
    }

    @Override
    public IIcon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ItemGasCapsule.GASES.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }
    
    /**
     * 
     * @author Hlaaftana
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld){
    	for (int i = 0; i < ItemGasCapsule.GASES.length; i++)
        {
    		switch (stack.getItemDamage()){
    			case 0:
    				element = ElementEnum.HYDROGEN;
    				break;
    			case 1:
    				element = ElementEnum.LITHIUM;
    				break;
    			case 2: 
    				element = ElementEnum.NITROGEN;
    				break;
    			case 3:
    				element = ElementEnum.OXYGEN;
    				break;
    			case 4:
    				element = ElementEnum.SODIUM;
    				break;
    			case 5:
    				element = ElementEnum.PHOSPHORUS;
    				break;
    			case 6:
    				element = ElementEnum.SULFUR;
    				break;
    			case 7:
    				element = ElementEnum.IODINE;
    				break;
    			case 8:
    				element = ElementEnum.MERCURY;
    				break;
    			case 9:
    				element = ElementEnum.RADON;
    				break;
    			case 10:
    				compound = CompoundEnum.WATER;
    				break;
    			default:
    				element = ElementEnum.EMPTY;
    				break;
        	}
        }
    	if (!(stack.getItemDamage() == 10)){
    		list.add(EnumChatFormatting.GRAY + element.name + ", " + element.formula + ", " + element.atomicNumber);
		}else{
			list.add(EnumChatFormatting.GRAY + compound.name + ", " + compound.formula);
		}
    }
}
