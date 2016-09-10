package com.test.testmod.entity.render;

import com.test.testmod.ModTest;
import com.test.testmod.entity.EntityFollower;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFollower extends RenderLiving
{
	private static final ResourceLocation FOLLOWER_TEXTURE = 
			new ResourceLocation(ModTest.MODID + ":textures/entity/follower.png");
	
	public RenderFollower( RenderManager rdMgr)
	{
		super( rdMgr, new ModelPlayer( 0f, false), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return FOLLOWER_TEXTURE;
	}

	@Override
	public void doRender( EntityLiving ety, double x, double y, double z, float etyYaw, float ptlTicks)
	{
		super.doRender( ety, x, y, z, etyYaw, ptlTicks);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase ety, float ptlTickTm)
	{
		this.preRenderCallbackFollower( (EntityFollower)ety, ptlTickTm);
	}

	protected void preRenderCallbackFollower( EntityFollower ety, float ptlTickTm)
	{
		
	}
}
