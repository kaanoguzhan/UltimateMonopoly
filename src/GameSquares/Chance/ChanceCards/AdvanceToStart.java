package GameSquares.Chance.ChanceCards;

import gui.CardShower;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStart extends ChanceCard {

	public AdvanceToStart() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		pl.moveTo(0);
		
	}

	@Override
	public String toString() {
		return "You picked AdvanceToStart Card.";
	}
}
