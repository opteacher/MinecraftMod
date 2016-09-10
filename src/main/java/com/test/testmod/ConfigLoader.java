package com.test.testmod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	private static Configuration cfg;
	
	public static int dmdBurnTm;
	
	public ConfigLoader(FMLPreInitializationEvent eve)
	{
		cfg = new Configuration(eve.getSuggestedConfigurationFile());
		cfg.load();
		
		regCfg();
		
		cfg.save();
	}
	
	private static void regCfg()
	{
		dmdBurnTm = cfg.get( Configuration.CATEGORY_GENERAL, "diamondBurnTime", 640).getInt();
	}
}
