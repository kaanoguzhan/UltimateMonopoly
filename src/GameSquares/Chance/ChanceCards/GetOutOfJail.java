package GameSquares.Chance.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class GetOutOfJail extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public GetOutOfJail() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		// Out of Jail method
	}

	@Override
	public String toString() {
		return "You picked GetOutOfJail Card.";
	}

}
