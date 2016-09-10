package com.test.testmod;

import com.test.testmod.block.BlockLoader;
import com.test.testmod.entity.EntityLoader;
import com.test.testmod.item.ItemLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent eve)
	{
		new ConfigLoader(eve);
		new CreativeTabsLoader();
		new ItemLoader();
		new BlockLoader();
		new EntityLoader();
	}
	
	public void init(FMLInitializationEvent eve)
	{
		new EventLoader();
	}
	
	public void postInit(FMLPostInitializationEvent eve)
	{
		
	}
}
