package com.mycompany.a2;

public class PlayerShip extends MoveableGameObject implements ISteerable{

	private int missileCount;
	private MissileLauncher launcher;
	
	public PlayerShip()
	{
		launcher = new MissileLauncher();
		missileCount = 10;
		setLocation(512.0,384.0);
		setSpeed(0);
		setDirection(0);
		setColor(255,255,255); //player ship is white
	}
	
	public MissileLauncher getMissileLauncher()
	{
		return launcher;
	}
	
	public int getMissileCount()
	{
		
		return missileCount;		
		
	}
	
	public int getLauncherDirection()
	{
		return launcher.getDirection();
	}
	
	public Missile fireMissile()
	{
		if(missileCount == 0)
			return null;
		missileCount--;
		Missile bogey = new Missile(getDirection(),getLocation(),true);
		System.out.println("A missile has been fired from the Player Ship!");
		
		return bogey;
	}
	
	public void reloadMissiles()
	{
		missileCount = 10;
	}

	public void resetPos()
	{
		setLocation(512,384);
	}
	
	public void changeSpeed(char c)
	{
		switch(c)
		{
		case 'i':
			//increase speed up to 15
			if(getSpeed() < 15)
				setSpeed(1);
			break;
		case 'd':
			//decrease speed down to min of 0
			if(getSpeed() > 0)
				setSpeed(-1);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void Move()
	{
		super.Move();
	}
	
	public void turnPS(char c)
	{
		switch(c)
		{
		case 'l':
			//turn ccw
			setDirection(getDirection()-1);
		//	launcher.turn(); could turn launcher with ps
			//if desired 
			//simply create overloaded turn method that takes 
			//degree of direction change of PS as param
			
			break;
		case 'r':
			//turn cw
			setDirection(getDirection()+1);
			break;
		}
	}
	
	

	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " missiles = " + missileCount;
		String retval = "Player Ship: "+parentDesc+myDesc+launcher.toString();
		
		return retval;
	}

	@Override
	public void turn(int amount) {
		// TODO Auto-generated method stub
		
	}




}
