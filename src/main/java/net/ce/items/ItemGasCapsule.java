package net.ce.items;

import java.util.List;

import net.ce.init.CETabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGasCapsule extends Item 
{
	public static final String[] GASES = { "hydrogen", "lithium", "nitrogen", "oxygen", "sodium", "phosphorus", "sulfur", "iodine", "mercury", "radon" };
	protected IIcon[] icons = new IIcon[ItemGasCapsule.GASES.length];
	
	public ItemGasCapsule(String name)
	{
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CETabs.tabCE);
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
}
