package com.thexfactor117.ce.items;

import com.thexfactor117.ce.Reference;
import com.thexfactor117.ce.init.CEBlocks;
import com.thexfactor117.ce.init.CEItems;
import com.thexfactor117.ce.init.CETabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * 
 * @author Hlaaftana
 * I added this class for a specific reason. Check #onItemRightClick.
 */
public class ItemCapsule extends Item
{
	public ItemCapsule(String name)
	{
		super();
		this.setCreativeTab(CETabs.tabCECapsules);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
	}
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, true);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
                {
                    return p_77659_1_;
                }

                if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                {
                    return p_77659_1_;
                }

                if (p_77659_2_.getBlock(i, j, k) == CEBlocks.mercury)
                {
                    --p_77659_1_.stackSize;
                    p_77659_2_.setBlock(i, j, k, Blocks.air);
                    if (p_77659_1_.stackSize <= 0)
                    {
                        return new ItemStack(CEItems.liquidCapsule, 1, 12);
                    }
                }
            }

            return p_77659_1_;
        }
    }
}
