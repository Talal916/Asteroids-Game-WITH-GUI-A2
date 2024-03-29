package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddAsteroidCmd extends Command
{
	private GameWorld gw;
	
	/**
	 * 
	 * @param gw
	 */
	public AddAsteroidCmd(GameWorld gw)
	{
		super("Add asteroid");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.addObj('a');
		System.out.println("Add asteroid");
	}
}
