package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RecieveConsultancyFee extends CommunityChestCard {
	
	public RecieveConsultancyFee() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		pl.addMoney(25);
	}
}
