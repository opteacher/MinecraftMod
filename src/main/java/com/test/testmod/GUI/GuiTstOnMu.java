package com.test.testmod.GUI;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiTstOnMu extends GuiScreen
{
	private GuiScreen parentScn;
	private GuiButton btnCLose;
	private GuiTextField tfInput;
	
	public GuiTstOnMu(GuiScreen scn)
	{
		parentScn = scn;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		drawCenteredString( fontRendererObj, "Your §f§nPROUD§r first screen",
				(int)(width*0.5), (int)(height*0.3), 0xFFFF00);
		drawString( fontRendererObj, String.format( "You are pointing to: (§o%d§r,§o%d§r)", mouseX, mouseY), 
				(int)(width*0.05), (int)(height*0.9), 0xFFFFFF);
		drawRect( (int)(width*0.1), (int)(height*0.1), (int)(width*0.9), (int)(height*0.7), 0x80FFFFFF);
		
		tfInput.drawTextBox();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		btnCLose = new GuiButton( 0, (int)(width*0.75), (int)(height*0.85), 80, 20, "关闭");
		buttonList.add(btnCLose);
		tfInput = new GuiTextField( 1, fontRendererObj, (int)(width*0.5) - 150, (int)(height*0.3) + 20, 50, 50);
		tfInput.setMaxStringLength(64);
		tfInput.setFocused(false);
		tfInput.setCanLoseFocus(true);
		tfInput.setText("abcdefg\nawewesafdsfsdfdsfsdfsdascdwedscfsdfsfefewsdfsdfdsfdsf");
		tfInput.setEnabled(false);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if(button == btnCLose)
		{
			mc.displayGuiScreen(parentScn);
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		if(tfInput.textboxKeyTyped( typedChar, keyCode))
		{
			return;
		}
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		tfInput.mouseClicked( mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
