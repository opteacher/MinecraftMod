package com.test.testmod.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonEx extends GuiButton implements GuiCtrl
{

	public GuiButtonEx(int buttonId, int x, int y, String buttonText)
	{
		super(buttonId, x, y, buttonText);
	}

	@Override
	public void reLocate(int x, int y)
	{
		if(x >= 0) { xPosition = x; }
		if(y >= 0) { yPosition = y; }
	}

	@Override
	public void reSize(int wid, int hgt)
	{
		if(wid > 0) { width = wid; }
		if(hgt > 0) { height = hgt; }
	}

	@Override
	public int getPositionX()
	{
		return xPosition;
	}

	@Override
	public int getPositionY()
	{
		return yPosition;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public void draw(Minecraft mc, int x, int y)
	{
		super.drawButton( mc, x, y);
	}

}
