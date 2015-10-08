package GameSquares.CommunityChest;

import GameSquares.GameSquare;
import Main.Player;

public class CommunityChest extends GameSquare {
	
	private boolean			isCreated		= false;
	private CommunityDeck	CommunityDeck	= null;
	
	public CommunityChest(int id) {
		this.id = id;
		if (!isCreated)
			CommunityDeck = new CommunityDeck();
	}
	
	@Override
	public void onArrive(Player pl) {
		
		CommunityDeck.draw();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
