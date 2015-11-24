package GameSquares.Cards;

import GameSquares.GameSquare;
import Main.Player;

public class CommunityChest extends GameSquare {
	private static final long serialVersionUID = 1L;

	public enum CommunityChestCardType {
		BargainBusiness, HouseCondemned, OnlinePricing, RecieveConsultancyFee, RenovationSuccess, StreetRepair
	}

	private CommunityChestDeck CommunityDeck = null;

	public CommunityChest(int id, CommunityChestDeck CommunityDeck) {
		super(id, type.CommunityChest);
		this.CommunityDeck = CommunityDeck;
	}

	@Override
	public void onArrive(Player pl) {
		CommunityChestCard card = CommunityDeck.draw();
		card.onDraw(pl);
	}

	@Override
	public String toString() {
		return "Community Chest at Location: " + id;
	}
}
