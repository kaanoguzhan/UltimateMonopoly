package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class GetOutOfJail extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public GetOutOfJail() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
	}

	@Override
	public String toString() {
		return "You picked GetOutOfJail Card.";
	}

}
