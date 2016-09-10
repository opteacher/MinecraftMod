package com.test.testmod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemResLoader
{
	public ItemResLoader()
	{
		loadItemMdl(Items.followerEgg);
	}
	
	@SideOnly(Side.CLIENT)
	private void loadItemMdl(Item itm)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register( itm, 0, 
				new ModelResourceLocation(GameRegistry.findUniqueIdentifierFor(itm).toString(), "inventory"));
	}
}
