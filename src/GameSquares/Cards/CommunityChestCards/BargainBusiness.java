package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.CommunityChestCard;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;
import Main.Player;

public class BargainBusiness extends CommunityChestCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public BargainBusiness() {
		super(CommunityChestCardType.BargainBusiness,false);
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addToInventory(CommunityChestCardType.BargainBusiness);
	}
	
	@Override
	public String toString() {
		return "You picked BargainBusiness Card.";
	}
	
	@Override
	public String getName() {
		return "Bargain Business";
	}
}
