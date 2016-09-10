package com.test.testmod.entity;

import com.test.testmod.ModTest;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityLoader
{
	public EntityLoader()
	{
		registerEntity( EntityFollower.class, "Follower", 80, 3, true);
	}
	
	public static void registerEntity(Class<? extends Entity> etyCls, String nam, int tkgRg, int upFqc, boolean sdVelUp)
	{
		int etyID = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID( etyCls, nam, etyID);
		EntityRegistry.registerModEntity( etyCls, nam, etyID, ModTest.instance, tkgRg, upFqc, sdVelUp);
	}
}
