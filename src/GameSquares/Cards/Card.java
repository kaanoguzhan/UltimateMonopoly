package GameSquares.Cards;

import Main.Player;

public interface Card {
	
	public void onDraw(Player pl);
	public String toString();
	public String getName();
}
