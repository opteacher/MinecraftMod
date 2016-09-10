package com.test.testmod.GUI;

import java.util.ArrayList;
import java.util.List;

import com.test.testmod.ModTest;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiDlgInGm extends GuiScreen
{
	public static GuiDlgInGm instance = null;
	public static final ResourceLocation rlBackUp = 
			new ResourceLocation(ModTest.MODID + ":textures/gui/back_up.png");
	public static final int margin = 2;
	public static final int paddingLR = 5;
	public static final int paddingTB = 5;
	public static final int paddingCtl = 2;
	public static final int dlgWidth = 200;
	
	@SuppressWarnings("rawtypes")
	private List ctlList = null;
	private int dlgHeight = 10;
	
	@Override
	public void initGui()
	{
		super.initGui();
		dlgHeight = 10;
		ctlList = new ArrayList<GuiCtrl>();
	}
	
	@SuppressWarnings("unchecked")
	public void addCtrl(GuiCtrl ctl)
	{
		dlgHeight += ctl.getHeight();
		if(buttonList.size() > 1)
		{
			dlgHeight += paddingCtl;
		}
		for(Object o : ctlList)
		{
			GuiCtrl c = (GuiCtrl)o;
			c.reLocate( -1, (int)(c.getPositionY() - (paddingCtl + ctl.getHeight())*0.5));
		}
		ctl.reLocate( 
				(int)((width - dlgWidth)*0.5) + paddingLR, 
				(int)((height + dlgHeight)*0.5) - paddingTB - ctl.getHeight());
		ctl.reSize( dlgWidth - 2*paddingLR, -1);
		ctlList.add(ctl);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawDlgBckgrd( dlgWidth, dlgHeight);
		
		for(Object o : ctlList)
		{
			((GuiCtrl)o).draw( this.mc, mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	protected void drawDlgBckgrd( int wid, int hgt)
	{
		int xLT = (int)((width - wid)*0.5);
		int yLT = (int)((height - hgt)*0.5);
		int xRB = (int)((width + wid)*0.5);
		int yRB = (int)((height + hgt)*0.5);
		int xLTol = xLT - margin;
		int yLTol = yLT - margin;
		int xRBol = xRB + margin - 1;
		int yRBol = yRB + margin - 1;
		drawHorizontalLine( xLTol, xRBol, yLTol, 0x80FFFFFF);
		drawHorizontalLine( xLTol, xRBol, yRBol, 0x80FFFFFF);
		drawVerticalLine( xLTol, yLTol, yRBol, 0x80FFFFFF);
		drawVerticalLine( xRBol, yLTol, yRBol, 0x80FFFFFF);
		drawRect( xLT, yLT, xRB, yRB, 0x80FFFFFF);
		
		//drawScaledCustomSizeModalRectFmCenter( rlBackUp, 
		//		(int)((width + wid) * 0.5), (int)((height - hgt) * 0.5), 64, 64, 0.4f, 0.4f);
	}
	
	public void drawScaledCustomSizeModalRectFmCenter( ResourceLocation rl, int x, int y, 
			int widOfImg, int hgtOfImg, float widScl, float hgtScl)
	{
		mc.renderEngine.bindTexture(rl);
		int widOnScn = (int)(widOfImg*widScl);
		int hgtOnScn = (int)(hgtOfImg*hgtScl);
		drawScaledCustomSizeModalRect(
				x - (int)(widOnScn*0.5), y - (int)(hgtOnScn*0.5), 
				0, 0, 
				widOfImg, hgtOfImg, 
				widOnScn, hgtOnScn, 
				widOfImg, hgtOfImg);
	}
}
