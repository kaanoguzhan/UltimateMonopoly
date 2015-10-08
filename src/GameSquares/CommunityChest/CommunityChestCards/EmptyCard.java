package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class EmptyCard extends CommunityChestCard {
	
	@Override
	public void onDraw(Player pl) {
		System.out.println("There are no more cards left");
	}
	
}
