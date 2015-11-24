package GameSquares.Cards.CommunityChestCards;

import java.io.Serializable;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Cards.CommunityChestCard;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;
import Main.Player;

public class RenovationSuccess extends CommunityChestCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
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
	
	@Override
	public String getName() {
		return "RenovationSuccess";
	}
}
