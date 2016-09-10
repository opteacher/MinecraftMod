package com.test.testmod.GUI;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class GuiLoader
{
	private GuiButton btnTest = new GuiButton( 223, 0, 0, "Test");
	
	public GuiLoader()
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		FMLCommonHandler.instance().bus().register(this);
		GuiDlgInGm.instance = new GuiDlgInGm();
		GuiDlgWithFollower.instance = new GuiDlgWithFollower();
	}
	
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onGuiShow(InitGuiEvent.Post eve)
	{
		if(eve.gui instanceof GuiMainMenu)
		{
			btnTest.xPosition = (int)(eve.gui.width * 0.5) + 100 + 2;
			btnTest.yPosition = (int)(eve.gui.height * 0.25) + 48 + 72 + 12;
			btnTest.width = 100;
			eve.buttonList.add(btnTest);
		}
	}
	
	@SubscribeEvent
	public void onGuiBtnClick(ActionPerformedEvent.Post eve)
	{
		if(eve.button == btnTest)
		{
			Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new GuiTstOnMu(mc.currentScreen));
		}
	}
	
	@SubscribeEvent
	public void onKeyClicked(KeyInputEvent eve)
	{
		if(Keyboard.getEventKey() == Keyboard.KEY_F)
		{
			Minecraft.getMinecraft().displayGuiScreen(GuiDlgWithFollower.instance);
		}
	}
}
