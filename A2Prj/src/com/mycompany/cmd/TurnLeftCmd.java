package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnLeftCmd extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to turn the player to the left.
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public TurnLeftCmd(GameWorld gw)
	{
		super("Turn left");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.turnPS('l');
		System.out.println("Turn left");
	}
}
