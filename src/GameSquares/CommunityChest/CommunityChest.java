package GameSquares.CommunityChest;

import GameSquares.GameSquare;
import Main.Player;

public class CommunityChest extends GameSquare {
	
	private CommunityDeck	CommunityDeck	= null;
	
	public CommunityChest(int id,CommunityDeck CommunityDeck) {
		this.id = id;
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
