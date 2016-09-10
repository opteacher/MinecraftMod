package com.test.testmod;

import com.test.testmod.server.CommonMgr;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventLoader
{	
	public EventLoader()
	{
		FMLCommonHandler.instance().bus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
		EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerItemPickup(PlayerEvent.ItemPickupEvent eve)
	{
		if(eve.player.isServerWorld())
		{	
			eve.player.addChatComponentMessage(new ChatComponentText(eve.pickedUp.toString()));
		}
	}
	
	@SubscribeEvent
	public void onPlayerMove(LivingEvent.LivingUpdateEvent eve)
	{
		if(eve.entityLiving.isServerWorld())
		{
			EntityLivingBase ety = eve.entityLiving;
			if(ety.getClass() == EntityPlayer.class || ety.getClass() == EntityPlayerMP.class)
			{
				CommonMgr.updateFollowersLocTask((EntityPlayer)ety);
			}
		}
	}
	
	@Cancelable
	public static class EventPlayerClickGrassBlock extends PlayerInteractEvent
	{
		public EventPlayerClickGrassBlock( EntityPlayer p, BlockPos pos, World w)
		{
			super( p, PlayerInteractEvent.Action.LEFT_CLICK_BLOCK, pos, null, w);
		}
	}
	
	public static final EventBus EVENT_BUS = new EventBus();
	
	public static void triggerPlayerClickGrassBlockEvent( EntityPlayer p, BlockPos pos, World w)
	{
		EVENT_BUS.post(new EventPlayerClickGrassBlock( p, pos, w));
	}
	
	@SubscribeEvent
	public void onPlayerClickGrassBlock(EventPlayerClickGrassBlock eve)
	{
		if(!eve.world.isRemote && eve.entityPlayer.getHeldItem() == null)
		{
			eve.world.spawnEntityInWorld(
					new EntityTNTPrimed(
							eve.world,
							eve.pos.getX() + 0.5,
							eve.pos.getY() + 0.5,
							eve.pos.getZ() + 0.5, null));
		}
	}
}
