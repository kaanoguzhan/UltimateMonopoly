package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RenovationSuccess extends CommunityChestCard {
	
	public RenovationSuccess() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName() + " picked RenovationSuccess Card.");
		pl.addToInventory(CommunityChestCardType.RenovationSuccess);
	}
}
