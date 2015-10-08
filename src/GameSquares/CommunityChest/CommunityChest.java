package GameSquares.CommunityChest;

import GameSquares.GameSquare;
import Main.Player;

public class CommunityChest extends GameSquare {
	
	public enum CommunityChestCardType {
		BargainBusiness, RecieveConsultancyFee, RenovationSuccess
	}
	
	private CommunityChestDeck	CommunityDeck	= null;
	
	public CommunityChest(int id, CommunityChestDeck CommunityDeck) {
		super(id);
	}
	
	@Override
	public void onArrive(Player pl) {
		
		CommunityChestCard card = CommunityDeck.draw();
		card.onDraw(pl);
		
	}
	
	@Override
	public String toString() {
		return "Community Chest. Location: " + id;
	}
}
