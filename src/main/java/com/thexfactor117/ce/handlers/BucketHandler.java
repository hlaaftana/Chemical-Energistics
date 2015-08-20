package com.thexfactor117.ce.handlers;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;


public class BucketHandler extends FuelHandler{

	public static BucketHandler INSTANCE = new BucketHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();
	protected BucketHandler() {
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {

			ItemStack result = fillCustomBucket(event.world, event.target);

			if (result == null)
				return;

			event.result = result;
			event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		Item bucket = buckets.get(block);
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else
			return null;
	}
		
	/**
	 * Register a bucket for a fluid block.
	 * @param block The fluid's block.
	 * @param bucket The filled bucket.
	 */
	@SuppressWarnings("unused")
	private static void registerBucket(Block block, Item bucket){
		BucketHandler.INSTANCE.buckets.put(block, bucket);
	}
	public static void registerBuckets(){
		//registerBucket(exampleFluid, exampleBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
}