package com.test.testmod;

import com.test.testmod.GUI.GuiLoader;
import com.test.testmod.block.BlockResLoader;
import com.test.testmod.entity.EntityResLoader;
import com.test.testmod.item.ItemResLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent eve)
	{
		super.preInit(eve);
	}

	@Override
	public void init(FMLInitializationEvent eve)
	{
		super.init(eve);
		
		new ItemResLoader();
		new BlockResLoader();
		new EntityResLoader();
		new GuiLoader();
	}

	@Override
	public void postInit(FMLPostInitializationEvent eve)
	{
		super.postInit(eve);
	}

}
