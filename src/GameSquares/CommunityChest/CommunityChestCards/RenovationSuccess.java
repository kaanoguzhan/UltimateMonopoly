package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RenovationSuccess extends CommunityChestCard {
	
	public RenovationSuccess() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		pl.addToInventory("RenovationSuccess");
	}
}
