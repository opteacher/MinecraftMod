package com.test.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockResLoader
{
	public BlockResLoader()
	{
		loadBlkTex(Blocks.grass);
	}
	
	@SideOnly(Side.CLIENT)
	private void loadBlkTex(Block blk)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register( Item.getItemFromBlock(blk), 0, 
				new ModelResourceLocation(GameRegistry.findUniqueIdentifierFor(blk).toString(), "inventory"));
	}
}
