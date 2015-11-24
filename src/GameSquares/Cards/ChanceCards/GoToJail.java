package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import GameSquares.Cards.Chance.ChanceCardType;
import Main.Player;

public class GoToJail extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoToJail() {
		super(ChanceCardType.GoToJail, false);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.goToJail();
	}

	@Override
	public String toString() {
		return "You picked GoToJail Card.";
	}

	@Override
	public String getName() {
		return "Go to Jail";
	}
}
