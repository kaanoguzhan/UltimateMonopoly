package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class BargainBusiness extends CommunityChestCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public BargainBusiness() {
		super();
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
		return "BargainBusiness";
	}
}
