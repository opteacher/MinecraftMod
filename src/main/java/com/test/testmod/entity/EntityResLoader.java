package com.test.testmod.entity;

import com.test.testmod.entity.render.RenderFollower;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityResLoader
{
	@SideOnly(Side.CLIENT)
	public EntityResLoader()
	{
		RenderingRegistry.registerEntityRenderingHandler( EntityFollower.class, 
				new RenderFollower(Minecraft.getMinecraft().getRenderManager()));
	}
}
