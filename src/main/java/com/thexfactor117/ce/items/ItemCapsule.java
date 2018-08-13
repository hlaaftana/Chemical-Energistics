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

public class ItemCapsule extends Item {
	public ItemCapsule(String name) {
		super();
		this.setCreativeTab(CETabs.tabCECapsules);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID + ":" + name);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

		if (movingobjectposition == null) {
			return stack;
		}

		if (movingobjectposition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
			return stack;
		}

		int i = movingobjectposition.blockX, j = movingobjectposition.blockY, k = movingobjectposition.blockZ;

		if (!world.canMineBlock(player, i, j, k)) {
			return stack;
		}

		if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) {
			return stack;
		}

		if (world.getBlock(i, j, k) == CEBlocks.mercury) {
			--stack.stackSize;
			world.setBlock(i, j, k, Blocks.air);
			if (stack.stackSize <= 0) {
				return new ItemStack(CEItems.liquidCapsule, 1, 12);
			}
		}

		if (world.getBlock(i, j, k) == Blocks.water) {
			--stack.stackSize;
			world.setBlock(i, j, k, Blocks.air);
			if (stack.stackSize <= 0) {
				return new ItemStack(CEItems.liquidCapsule, 1, 15);
			}
		}

		return stack;
	}
}
