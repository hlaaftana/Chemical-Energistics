package com.thexfactor117.ce.world;

import java.util.Random;

import com.thexfactor117.ce.handlers.ConfigHandler;
import com.thexfactor117.ce.init.CEBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CEWorldGeneration implements IWorldGenerator
{	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		{
    		case 0:
    			generateSurface(world, random, chunkX * 16, chunkZ * 16);
    		case -1:
    			generateNether(world, random, chunkX * 16, chunkZ * 16);
    		case 1:
    			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z)
	{
		if (ConfigHandler.generateAluminum)
		{
			addOreSpawn(CEBlocks.oreAluminum, world, random, x, z, 16, 16, 2 + random.nextInt(4), 8, 0, 64);
		}
		
		if (ConfigHandler.generateSulfur)
		{
			addOreSpawn(CEBlocks.oreSulfur, world, random, x, z, 16, 16, 1 + random.nextInt(3), 6, 0, 48);
		}
		
		if (ConfigHandler.generateTungsten)
		{
			addOreSpawn(CEBlocks.oreTungsten, world, random, x, z, 16, 16, 1 + random.nextInt(2), 5, 0, 32);
		}
		
		if (ConfigHandler.generateUranium)
		{
			addOreSpawn(CEBlocks.oreUranium, world, random, x, z, 16, 16, 1 + random.nextInt(1), 4, 0, 16);
		}
		
		if (ConfigHandler.generateIridium)
		{
			addOreSpawn(CEBlocks.oreIridium, world, random, x, z, 16, 16, 1, 2, 0, 64);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {}

	private void generateEnd(World world, Random random, int x, int z) {}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
	{
		for (int i = 0; i < chanceToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
		}
	}
}