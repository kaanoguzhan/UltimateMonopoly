package GameSquares.Chance.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class GoToJail extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoToJail() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.setJailed(true);
		pl.moveTo(10);
	}

	@Override
	public String toString() {
		return "You picked GoToJail Card.";
	}

}
