package GameSquares.CommunityChest;

import GameSquares.GameSquare;

public class CommunityChest extends GameSquare {
	
	public CommunityChest() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive() {
		Deck deck = new Deck();
		deck.draw();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


