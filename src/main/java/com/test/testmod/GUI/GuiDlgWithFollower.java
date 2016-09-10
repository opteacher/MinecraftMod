package com.test.testmod.GUI;

public class GuiDlgWithFollower extends GuiDlgInGm
{
	public static GuiDlgWithFollower instance = null;
		
	private GuiCtrl btnTest1 = new GuiButtonEx( 0, 0, 0, "TEST-1");
	private GuiCtrl btnTest2 = new GuiButtonEx( 1, 0, 0, "TEST-2");
	private GuiCtrl txtDisc = new GuiTextView( "\tMay you have enough happiness to make you sweet,enough trials to make you strong,enough sorrow to keep you human,enough hope to make you happy?", 0, 0, 0, 50);

	@Override
	public void initGui()
	{
		super.initGui();
		
		super.addCtrl(txtDisc);
		super.addCtrl(btnTest1);
		super.addCtrl(btnTest2);
		
	}
}
