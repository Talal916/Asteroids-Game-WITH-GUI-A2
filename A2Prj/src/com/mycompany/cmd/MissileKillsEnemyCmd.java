package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class MissileKillsEnemyCmd extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to kill enemy ship with player missile
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public MissileKillsEnemyCmd(GameWorld gw)
	{
		super("Missile kills enemy");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.eliminate();
		System.out.println("Missile kills enemy");
	}
}
