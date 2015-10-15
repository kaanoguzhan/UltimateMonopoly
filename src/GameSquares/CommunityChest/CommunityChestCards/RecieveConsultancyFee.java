package GameSquares.CommunityChest.CommunityChestCards;

import gui.CardShower;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RecieveConsultancyFee extends CommunityChestCard {

	public RecieveConsultancyFee() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		pl.addMoney(25);
	}

	@Override
	public String toString() {
		return "You picked RecieveConsultancyFee Card.";
	}
}
