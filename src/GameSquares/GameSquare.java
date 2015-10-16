package GameSquares;

import Main.Player;

public abstract class GameSquare {
	
	protected int		xCoord;
	protected int		yCoord;
	
	protected int		id;
	protected Player	owner;
	
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
	
	public Player getOwner() {
		return owner;
	}
	
	public int getID(){
		return id;
	}
}
