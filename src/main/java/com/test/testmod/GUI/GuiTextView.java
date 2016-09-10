package com.test.testmod.GUI;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GuiTextView extends Gui implements GuiCtrl
{
	public static final int BK_COLOR = 0x80000000;
	public static final int paddingTB = 5;
	public static final int paddingLR = 2;
	public static final int CTTS_COLOR = 0xFFEEEEEE;
	
	private int xPosition, yPosition;
	private int width, height;
	private int rowMaxChar;
	private String text;
	private List<String> txtForShow;
	
	public GuiTextView( String txt, int x, int y, int wid, int hgt)
	{
		text = txt;
		xPosition = x;
		yPosition = y;
		width = wid;
		height = hgt;
		txtForShow = new ArrayList<String>();
		reSize( width, height);
	}
	
	private static int locFmrWord( String s, int fmIdx)
	{
		if(s.length() <= fmIdx)
		{
			return -1;
		}
		for( int i = fmIdx; i >= 0; --i)
		{
			if(isSplitChar(s.charAt(i)))
			{
				return i;
			}
		}
		return 0;
	}
	
	private static boolean isSplitChar(char c)
	{
		return c == ' ' || c == ',' || c == '.' || c == '?' || c == '!';
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
		if(wid > 0)
		{
			width = wid;
			if(width > 2*paddingLR)
			{
				txtForShow.clear();
				rowMaxChar = (width - 2*paddingLR) / 
						Minecraft.getMinecraft().fontRendererObj.getCharWidth('O');
				for(String pg : text.split("\n"))
				{
					String t = pg.replace( "\t", "    ");
					while(t.length() / rowMaxChar != 0)
					{
						if(isSplitChar(t.charAt(rowMaxChar - 1)))
						{
							txtForShow.add(t.substring( 0, rowMaxChar));
							t = t.substring(rowMaxChar);
						}
						else if(isSplitChar(t.charAt(rowMaxChar)))
						{
							txtForShow.add(t.substring( 0, rowMaxChar + 1));
							t = t.substring(rowMaxChar + 1);
						}
						else
						{
							int idx = locFmrWord( t, rowMaxChar - 2) + 1;
							txtForShow.add(t.substring( 0, idx));
							t = t.substring(idx);
						}
					}
					txtForShow.add(t);
				}
			}
		}
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
		super.drawRect( xPosition, yPosition, xPosition + width, yPosition + height, BK_COLOR);
		int row = yPosition + paddingTB;
		for(String r : txtForShow)
		{
			super.drawString( mc.fontRendererObj, r, xPosition + paddingLR, row, CTTS_COLOR);
			row += mc.fontRendererObj.FONT_HEIGHT;
		}
	}
	
}
