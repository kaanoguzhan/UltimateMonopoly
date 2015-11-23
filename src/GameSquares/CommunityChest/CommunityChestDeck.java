package GameSquares.CommunityChest;

import java.io.Serializable;
import java.util.Random;

import GameSquares.CommunityChest.CommunityChestCards.BargainBusiness;
import GameSquares.CommunityChest.CommunityChestCards.HouseCondemned;
import GameSquares.CommunityChest.CommunityChestCards.OnlinePricing;
import GameSquares.CommunityChest.CommunityChestCards.RecieveConsultancyFee;
import GameSquares.CommunityChest.CommunityChestCards.RenovationSuccess;
import GameSquares.CommunityChest.CommunityChestCards.StreetRepair;

public class CommunityChestDeck implements Serializable {
	private static final long serialVersionUID = 1L;
	private CommunityChestCard[] cards = null;

	public CommunityChestDeck() {
		CommunityChestCard[] cards = { new BargainBusiness(), new HouseCondemned(), new OnlinePricing(),
				new RecieveConsultancyFee(), new RenovationSuccess(), new StreetRepair() };
		this.cards = cards;
	}

	public CommunityChestCard draw() {
		return cards[new Random().nextInt(cards.length)];
	}
}
