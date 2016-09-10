package com.test.testmod.GUI;

import net.minecraft.client.Minecraft;

public interface GuiCtrl
{
	public void reLocate( int x, int y);
	public void reSize( int wid, int hgt);
	public int getPositionX();
	public int getPositionY();
	public int getWidth();
	public int getHeight();
	
	public void draw( Minecraft mc, int x, int y);
}
