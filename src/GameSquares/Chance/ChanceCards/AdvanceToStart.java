package GameSquares.Chance.ChanceCards;

import gui.CardShower;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStart extends ChanceCard {

	public AdvanceToStart() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveTo(0);
		
	}

	@Override
	public String toString() {
		return "You picked AdvanceToStart Card.";
	}
}
