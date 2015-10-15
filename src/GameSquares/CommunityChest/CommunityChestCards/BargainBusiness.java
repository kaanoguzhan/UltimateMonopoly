package GameSquares.CommunityChest.CommunityChestCards;

import gui.CardShower;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class BargainBusiness extends CommunityChestCard {

	public BargainBusiness() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		pl.addToInventory(CommunityChestCardType.BargainBusiness);
	}

	@Override
	public String toString() {
		return "You picked BargainBusiness Card.";
	}
}
