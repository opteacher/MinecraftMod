package com.test.testmod.item;

import com.test.testmod.CreativeTabsLoader;
import com.test.testmod.entity.EntityFollower;
import com.test.testmod.server.CommonMgr;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFollowerEgg extends Item
{
	public ItemFollowerEgg()
	{
		super();
		setUnlocalizedName("followerEgg");
		setCreativeTab(CreativeTabsLoader.tabTestMod);
	}

	@Override
	public ItemStack onItemRightClick( ItemStack itmStk, World w, EntityPlayer p)
	{
		if(!w.isRemote)
		{
			EntityLiving ety = new EntityFollower(w);
			ety.setPositionAndUpdate( p.posX + 0.5, p.posY + 0.5, p.posZ + 0.5);
			w.spawnEntityInWorld(ety);
			CommonMgr.boundingPlayerWithFollower( p, ety);
			--itmStk.stackSize;
		}
		return itmStk;
	}
}
