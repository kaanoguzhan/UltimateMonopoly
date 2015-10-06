package GameSquares;

import Main.Player;

public abstract class GameSquare {

	public int xCoord;
	public int yCoord;

	public int id;
	public Player owner;

	public abstract void onArrive();
}
