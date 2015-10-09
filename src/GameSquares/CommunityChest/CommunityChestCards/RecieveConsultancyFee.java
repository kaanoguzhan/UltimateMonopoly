package GameSquares.CommunityChest.CommunityChestCards;

import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class RecieveConsultancyFee extends CommunityChestCard {
	
	public RecieveConsultancyFee() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName()+" picked RecieveConsultancyFee Card.");
		pl.addMoney(25);
	}
}
