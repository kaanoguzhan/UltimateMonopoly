package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Cards.ChanceCard;
import GameSquares.Cards.Chance.ChanceCardType;
import Main.Player;

public class GetOutOfJail extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public GetOutOfJail() {
		super(ChanceCardType.GetOutOfJail, true);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addToInventoryC(ChanceCardType.GetOutOfJail);
	}

	@Override
	public String toString() {
		return "You picked GetOutOfJail Card.";
	}

	@Override
	public String getName() {
		return "Get out of Jail";
	}
}
