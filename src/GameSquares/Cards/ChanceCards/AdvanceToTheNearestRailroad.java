package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class AdvanceToTheNearestRailroad extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdvanceToTheNearestRailroad() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		// moveTo nearest RailRoad
	}

	@Override
	public String toString() {
		return "You picked AdvanceToTheNearestRailRoad Card.";
	}

}
