package GameSquares;

import Main.Player;

public abstract class GameSquare {

	int xCoord;
	int yCoord;

	int id;
	Player owner;

	public abstract void onArrive();
}
