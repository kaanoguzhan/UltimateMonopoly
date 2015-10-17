package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class EmptyCard extends CommunityChestCard {
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
	}
	
	@Override
	public String toString() {
		return "There are no more cards left";
	}
	
}
