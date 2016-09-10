package com.test.testmod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemLoader
{
	public ItemLoader()
	{
		GameRegistry.registerItem( Items.followerEgg, "follower_egg");
	}
}
