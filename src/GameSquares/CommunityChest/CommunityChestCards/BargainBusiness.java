package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class BargainBusiness extends CommunityChestCard {
	
	public BargainBusiness() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		pl.addToInventory(CommunityChestCardType.BargainBusiness);
	}
}
