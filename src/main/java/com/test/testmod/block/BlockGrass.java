package com.test.testmod.block;

import com.test.testmod.EventLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockGrass extends Block
{

	protected BlockGrass()
	{
		super(Material.grass);
		setUnlocalizedName("grassBlock");
		setHardness(0.5f);
		setStepSound(soundTypeGrass);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void onBlockClicked(World w, BlockPos pos, EntityPlayer p)
	{
		EventLoader.triggerPlayerClickGrassBlockEvent( p, pos, w);
		if(!w.isRemote)
		{
			w.setBlockToAir(pos);
		}
	}
}
