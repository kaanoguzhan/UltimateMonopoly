package GameSquares.Chance;

import GameSquares.GameSquare;
import Main.Player;

public class Chance extends GameSquare {
	
	private ChanceDeck	ChanceDeck	= null;
	
	public Chance(int id, ChanceDeck ChanceDeck) {
		this.id = id;
	}
	
	@Override
	public void onArrive(Player pl) {
		
		ChanceDeck.draw();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}