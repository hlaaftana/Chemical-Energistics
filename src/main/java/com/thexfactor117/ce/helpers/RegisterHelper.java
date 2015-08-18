package com.thexfactor117.ce.helpers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.hlaaftana.mods.OlivicBlocks.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper 
{
	/**
	 * Registers the specified block.
	 * @param block - block to be registered.
	 */
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the specified item.
	 * @param item - item to be registered.
	 */
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void register2Blocks(Block block1, Block block2){
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
	}
	
	public static void register3Blocks(Block block1, Block block2, Block block3){
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block3, block3.getUnlocalizedName().substring(5));
	}
	
	public static void register4Blocks(Block block1, Block block2, Block block3, Block block4){
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block3, block3.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block4, block4.getUnlocalizedName().substring(5));
	}
	
	public static void register2Items(Item item1, Item item2){
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
	}
	
	public static void register3Items(Item item1, Item item2, Item item3){
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item3, item3.getUnlocalizedName().substring(5));
	}
	
	public static void register4Items(Item item1, Item item2, Item item3, Item item4){
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item3, item3.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item4, item4.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluid(Fluid fluid){
		FluidRegistry.registerFluid(fluid);
	}
	
	public static void registerFluidBucket(Fluid fluid, Item bucket){
		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(bucket), new ItemStack(Items.bucket));
	}
	
	public static void registerFluidBottle(Fluid fluid, Item bottle){
		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(bottle), new ItemStack(Items.glass_bottle));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerNormalFish(ItemStack item, int weight){
		try{
			Field field = EntityFishHook.class.getDeclaredField("field_146036_f");
        	List list = new ArrayList(getStaticFinalList(field));
        	list.add(new WeightedRandomFishable(item, weight));
        	setStaticFinalList(EntityFishHook.class.getDeclaredField("field_146036_f"), list);
		}
		catch (Exception e){
        e.printStackTrace();
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerLootFish(ItemStack loot, int weight){
		try{
			Field field = EntityFishHook.class.getDeclaredField("field_146039_d");
        	List list = new ArrayList(getStaticFinalList(field));
        	list.add(new WeightedRandomFishable(loot, weight));
        	setStaticFinalList(EntityFishHook.class.getDeclaredField("field_146039_d"), list);
		}
		catch (Exception e){
			e.printStackTrace();
		}
    }
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerRareFish(ItemStack rare, int weight)
    {
		try{
			Field field = EntityFishHook.class.getDeclaredField("field_146041_e");
			List list = new ArrayList(getStaticFinalList(field));
			list.add(new WeightedRandomFishable(rare, weight));
			setStaticFinalList(EntityFishHook.class.getDeclaredField("field_146041_e"), list);
		}
		catch (Exception e){
			e.printStackTrace();
		}
    }
    
  
  
    @SuppressWarnings("rawtypes")
	private static List getStaticFinalList(Field field) throws Exception{
    	field.setAccessible(true);
    	Field modifiers = Field.class.getDeclaredField("modifiers");
    	modifiers.setAccessible(true);
    	modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
    	return (List)field.get(field);
    }
    
  
  
    private static void setStaticFinalList(Field field, Object object) throws Exception{
    	field.setAccessible(true);
    	Field modifiers = Field.class.getDeclaredField("modifiers");
    	modifiers.setAccessible(true);
    	modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
    	field.set(null, object);
    }
}
