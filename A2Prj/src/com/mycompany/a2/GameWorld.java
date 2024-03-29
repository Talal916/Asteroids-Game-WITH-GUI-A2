package com.mycompany.a2;
import java.util.Vector;
import java.util.Observable;


public class GameWorld extends Observable implements IGameWorld {

	
	
	private Vector<GameObject> gameObjs = new Vector<GameObject>();
	
	private int score;
	private int elapsedTime;
	private int playerLives;
	private boolean endGame;
	private boolean soundSetting;
	
	
	private double GWWidth;
	private double GWHeight;

	private int numMissiles;

	public GameWorld() {
		init();
	
	}
	
	/**
	 * @return the endGame
	 */
	public boolean isEndGame() {
		return endGame;
	}

	/**
	 * @param endGame the endGame to set
	 */
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	public int getPlayerLives()
	{
		return playerLives;
		
	}
	public PlayerShip findPS()
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof PlayerShip)
			{
				return (PlayerShip) gameObjs.get(i);
			}
		}
		System.out.println("No Player Ship found!");
		return null;
	}
	
	public SpaceStation findSS()
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof SpaceStation)
			{
				return (SpaceStation) gameObjs.get(i);
			}
		}
		System.out.println("No Space Station found!");
		return null;
	}
	
	public MissileLauncher findML()
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof MissileLauncher)
			{
				return (MissileLauncher) gameObjs.get(i);
			}
		}
		System.out.println("No Missile Launcher found!");
		return null;
	}
	
	public EnemyShip findES()
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof EnemyShip)
			{
				return (EnemyShip) gameObjs.get(i);
			}
		}
		System.out.println("No Enemy Ship found!");
		return null;
	}
	
	public Asteroid findAst() //finds Asteroid and returns index of Asteroid
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof Asteroid)
			{
				return (Asteroid) gameObjs.get(i);
			}
		}
		System.out.println("No Asteroid found!");
		return null;
	}
	
	public Missile findMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof Missile)
			{
				return (Missile) gameObjs.get(i);
			}
		}
		System.out.println("No Missile found!");
		return null;
	}
	
	public Missile findPMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof Missile)
			{
				if(((Missile) gameObjs.get(i)).getisFriendly())
					return (Missile) gameObjs.get(i);
			}
		}
		System.out.println("No Player Missile found!");
		return null;
	}
	
	public Missile findEMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof Missile)
			{
				if(!((Missile) gameObjs.get(i)).getisFriendly())
					return (Missile) gameObjs.get(i);
			}
		}
		System.out.println("No Enemy Missile found!");
		return null;
	}
	
	
	public void init() 
	{
		score = 0;
		elapsedTime = 0;
		playerLives = 3;
		setEndGame(false);
		//code here to create the initial game objects/setup
	}
	
	/*
	 * additional methods here to manipulate world objects and related game state data
	 */

	
	
	public void addObj(char c) {
		// TODO Auto-generated method stub
		switch(c)
		{
		case 'a': 
			Asteroid  a = new Asteroid();
			gameObjs.add(a);
			System.out.println("An Asteroid has been created and added to game world!");
			break;
		case 'y':
			EnemyShip y = new EnemyShip();
			gameObjs.add(y);
			System.out.println("An Enemy Ship has been created and added to game world!");
			break;
		case 'b':
			SpaceStation b = new SpaceStation();
			gameObjs.add(b);
			System.out.println("A Space Station has been created and added to game world!");
			break;
		case 's':
			PlayerShip s = new PlayerShip();
			if(findPS() == null)
			{
			gameObjs.add(s);
			gameObjs.add(findPS().getMissileLauncher());
			System.out.println("A Player Ship and the Missile Launcher has been created and added to game world!");
			}
			else
				System.out.println("A player ship already exists!");
			break;
			
			
			 
		}
		
	}
	
	

	public void changeSpeed(char c) {
		if(findPS() != null)
		{
			findPS().changeSpeed(c); //finds player ship, and changes speed
		}
		else
			System.out.println("No Player Ship Exists!");
	}

	public void turnPS(char c) {
		if(findPS() != null)
		{
			findPS().turnPS(c); //finds player ship, and changes dir
		}		
	}

	public void turnML(int dir) {
		if(findML() != null)
		{
			findML().turn(dir); //finds missile launcher, turns it
			System.out.println("Turning Missile Launcher!");
		}			
	}

	public void firePMissile() {
		if(findML() != null && findPS().getMissileCount() != 0)
		{
			gameObjs.add(findPS().fireMissile()); //finds missile launcher, fires PS missile
		}			
		else
			System.out.println("Sorry! Player Ship is all out of missiles!");
	}

	public void fireEMissile() {
		if(findES() != null && findES().getMissileCount() != 0)
		{
			gameObjs.add(findES().fire()); //finds ES, fires missile
		}			
		else
			System.out.println("Enemy Ship is all out of missiles!");
	}

	public void resetPos() {
		if(findPS() != null)
		{
			findPS().resetPos(); //finds PS and resets position to center of screen		
		}		
	}
		
	

	public void loadPMissile() {
		if(findPS() != null)
		{
			findPS().reloadMissiles(); //finds PS and reloads PS missiles
		}		
	}

	public void removeAsteroid() {
		if(findAst() != null)
		{
			gameObjs.remove(findAst()); //finds first asteroid and removes that asteroid
		}		
	}
	

	public void missileStrikePS() {
		if(findPS() != null && findEMissile() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findEMissile());
		}
		if(playerLives <= 1)
		{
			gameOver();
		}
		else
		{
			System.out.println("Sorry, a missile struck your ship and destroyed it!");	
		playerLives--;
		addObj('s');
		}
		
	}
	
	public void missileStrikeAst() { //missileStrikeAst
		if(findAst() != null && findMissile() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findMissile());  //any missile
			score = score +1000;
		}

	}
	
	
	public void eliminate() { //missileStrikeNPS
		if(findES() != null && findPMissile() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findPMissile());
			score = score +1000;
		}

	}

	private void gameOver() {
		System.out.println("Sorry! Your ship was destroyed! Game OVER! \nYour Stats\n--------------------------------------------\n\n");
		endGameStats();
		setEndGame(true);
		

	}

	public void asteroidStrikePS() {
		if(findPS() != null && findAst() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findAst());
			if(playerLives == 1)
				gameOver();
			else
			{
				playerLives--;
				addObj('s');
			}
		}		
	}

	public void NPSStrikePS() {
		if(findES() != null && findPS() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findES());
			if(playerLives == 1)
				gameOver();
			else
			{
				playerLives--;
				addObj('s');
			}
		}				
	}

	public void asteroidCollision() {
		if(findAst() != null)
		{
			int astCount =0;
			for(int i=0;i<gameObjs.size();i++)
			{
				if(gameObjs.get(i) instanceof Asteroid)
					astCount++;
			}
			if(astCount >= 2) //require two or more asteroids for a collision
			{
				gameObjs.remove(findAst());
				gameObjs.remove(findAst());
			}
		}
		
	}

	public void asteroidStrikeNPS() {
		if(findES() != null && findAst() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findAst());
		}				
	}

	public void clkTick() {
     /*
      * Things to do when clock ticks-
      * - move objects, check fuel levels of missiles
      * - have spaceshipp blink
      * -tick the clock
      */
		elapsedTime++;
		
		for(int i=0; i < gameObjs.size(); i++)
		{
			if(gameObjs.get(i) instanceof MoveableGameObject)
			{
				((MoveableGameObject) gameObjs.get(i)).Move(); //finding each moveable object and moving it
				if(gameObjs.get(i) instanceof Missile)
					if(((Missile)gameObjs.get(i)).getFuel() == 0)
						gameObjs.remove(i); //if object is missile and fuel level is 0, remove it.
			}
			else if(gameObjs.get(i) instanceof SpaceStation)
			{
				((SpaceStation) gameObjs.get(i)).blinkCounter(); //increase blink counter on space ship
			}
		}
	}

	public void printGameState() {
		System.out.println("Score: "+ score);
		if(findPS() != null)
			System.out.println("Missiles Left: "+findPS().getMissileCount());
		System.out.println("Game Time: " + elapsedTime +"\n");
		System.out.println("Lives Left: "+ playerLives);
	}
	
	public void endGameStats()
	{
		System.out.println("Score:  "+ score);
		System.out.println("Game Time: "+elapsedTime);
		System.out.println("Lives left: "+playerLives);
	}

	public void printGameMap() {
		for(int i=0; i <  gameObjs.size(); i++)
		{
			if(!(gameObjs.get(i) instanceof MissileLauncher))
				System.out.println(gameObjs.get(i));
		}
		
	}

	public void exitGame() {
		System.out.println("Are you sure you want to exit the game?");
		
		// TODO Auto-generated method stub
		
	}

	public int getMissileCount() {
		return numMissiles;
	}

	public int getPoints() {
		return score;
	}

	public boolean getSoundSetting() {
		// TODO Auto-generated method stub
		return soundSetting;
	}

	public GameCollection getCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setGWHeight(double mapHeight) {
			GWHeight = mapHeight;
	}

	public void setGWWidth(double mapWidth) {
		// TODO Auto-generated method stub
		GWWidth = mapWidth;
	}

	public double getGWHeight() {
		// TODO Auto-generated method stub
		return GWHeight;
	}

	public double getGWWidth() {
		// TODO Auto-generated method stub
		return GWWidth;
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSound() {
		// TODO Auto-generated method stub
		
	}

	public void missileReload() {
			PlayerShip 	pS = findPS();
			SpaceStation sS = findSS();
			if(pS != null && sS != null)
			{
				pS.reloadMissiles();
				numMissiles = 10;
				//InformObservers();  //fix this 
			}
			
	}


}

