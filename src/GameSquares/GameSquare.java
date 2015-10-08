package GameSquares;

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
	
	public void setCoordinates(int X, int Y) {
		xCoord = X;
		yCoord = Y;
	}
	
	public void setOwner(Player pl) {
		owner = pl;
	}
}
