package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RecieveConsultancyFee extends CommunityChestCard {

	public RecieveConsultancyFee() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addMoney(25);
	}

	@Override
	public String toString() {
		return "You picked RecieveConsultancyFee Card.";
	}
}
