package GameSquares;

import Main.Player;

public abstract class GameSquare {
	
	protected int		xCoord;
	protected int		yCoord;
	
	protected int		id;
	protected type		cardType;
	protected Player	owner;
	
	
	protected GameSquare(int id, type type) {
		this.id = id;
		this.cardType = type;
	}
	
	public enum type {
		Chance, CommunityChest, FreePark, Land, RollOnce, StartSquare, SqueezePlay
	}
	
	public abstract void onArrive(Player pl);
	
	@Override
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
	
	public String getType() {
		return cardType.toString();
	}
	
	public int getID() {
		return id;
	}
}
