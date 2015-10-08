package GameSquares.CommunityChest;

import GameSquares.GameSquare;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class CommunityChest extends GameSquare {
	
	private CommunityChestDeck	CommunityDeck	= null;
	
	public CommunityChest(int id, CommunityChestDeck CommunityDeck) {
		this.id = id;
	}
	
	@Override
	public void onArrive(Player pl) {
		
		CommunityChestCard card = CommunityDeck.draw();
		card.onDraw();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
