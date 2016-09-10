package com.test.testmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModTest.MODID, name = ModTest.NAME, version = ModTest.VERSION)
public class ModTest
{
	public static final String MODID = "testmod";
	public static final String NAME = "ModTest";
	public static final String VERSION = "1.0";
	
	@Instance(ModTest.MODID)
	public static ModTest instance;
	
	@SidedProxy( clientSide = "com.test.testmod.ClientProxy",
			serverSide = "com.test.testmod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent eve)
	{
		proxy.preInit(eve);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent eve)
	{
		proxy.init(eve);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent eve)
	{
		proxy.postInit(eve);
	}
}
