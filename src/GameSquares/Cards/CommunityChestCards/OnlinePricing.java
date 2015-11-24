package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.CommunityChestCard;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;
import Main.Player;

public class OnlinePricing extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public OnlinePricing() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addToInventory(CommunityChestCardType.OnlinePricing);
		//Next time you land on anyone else's railroad only pay 1/2 the rent.
		//RailRoad onArrive calls this.
	}

	@Override
	public String toString() {
		return "You picked Special Online Pricing Card. Next time you land on anyone else's railroad only pay 1/2 the rent.";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
