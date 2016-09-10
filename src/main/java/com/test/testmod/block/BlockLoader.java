package com.test.testmod.block;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockLoader
{
	public BlockLoader()
	{
		GameRegistry.registerBlock( Blocks.grass, "grass_block");
	}
}
