package GameSquares;

import GameSquares.Land.color;
import Main.Player;

public abstract class GameSquare {
	
	public int		xCoord;
	public int		yCoord;
	
	public int		id;
	public Player	owner;
	
	public GameSquare(int id) {
		this.id = id;
	}
	
	public abstract void onArrive(Player pl);
	
	public abstract String toString();
}
