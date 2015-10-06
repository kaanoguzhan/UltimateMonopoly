package GameSquares.Chance;

import GameSquares.GameSquare;
import GameSquares.CommunityChest.CommunityDeck;

public class Chance extends GameSquare {
	
	private boolean		isCreated	= false;
	private ChanceDeck	ChanceDeck	= null;
	
	public Chance(int id) {
		this.id = id;
		if (!isCreated)
			ChanceDeck = new ChanceDeck();
	}
	
	@Override
	public void onArrive() {
		CommunityDeck deck = new CommunityDeck();
		deck.draw();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
