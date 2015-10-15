package GameSquares.CommunityChest.CommunityChestCards;

import gui.CardShower;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RenovationSuccess extends CommunityChestCard {
	
	public RenovationSuccess() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addToInventory(CommunityChestCardType.RenovationSuccess);
	}
	
	@Override
	public String toString() {
		return "You picked RenovationSuccess Card.";
	}
}
