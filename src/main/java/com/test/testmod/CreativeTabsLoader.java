package com.test.testmod;

import com.test.testmod.item.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsLoader
{
	public static CreativeTabs tabTestMod;
	
	public CreativeTabsLoader()
	{
		tabTestMod = new CreativeTabs("tabTestMod")
				{
					@Override
					public Item getTabIconItem()
					{
						return Items.followerEgg;
					}
				};
	}
}
