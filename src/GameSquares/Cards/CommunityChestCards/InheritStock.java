package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Cards.CommunityChestCard;
import Main.Player;

public class InheritStock extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public InheritStock() {
		super(CardType.InheritStock, false);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		//You may chose any 1 share of any unpurchased stock to add to your portfolio
	}

	public String toString() {
		return "You picked InheritStock Card.";
	}

	@Override
	public String getName() {

		return "Inherit Stock";
	}

}
