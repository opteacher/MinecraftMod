package com.test.testmod.server;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class CommonMgr
{
	static Hashtable<Integer, ArrayList<EntityLiving>> playerWithFollowers = 
			new Hashtable<Integer, ArrayList<EntityLiving>>();
	
	public static void boundingPlayerWithFollower( EntityPlayer p, EntityLiving f)
	{
		ArrayList<EntityLiving> lsFol = null;
		if(playerWithFollowers.containsKey(p.getEntityId()))
		{
			lsFol = playerWithFollowers.get(p.getEntityId());
		}
		else
		{
			lsFol = new ArrayList<EntityLiving>();
		}
		lsFol.add(f);
		playerWithFollowers.put( p.getEntityId(), lsFol);
	}
	
	public static void updateFollowersLocTask(EntityPlayer p)
	{
		if(playerWithFollowers.containsKey(p.getEntityId()))
		{
			for( EntityLiving ety : playerWithFollowers.get(p.getEntityId()))
			{
				ety.getNavigator().tryMoveToEntityLiving( p, 0.5);
			}
		}
	}
}
