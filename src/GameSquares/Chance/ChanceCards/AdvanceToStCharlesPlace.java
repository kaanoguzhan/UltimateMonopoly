package GameSquares.Chance.ChanceCards;

import gui.CardShower;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStCharlesPlace extends ChanceCard {
	
	public AdvanceToStCharlesPlace() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		pl.moveTo(6);
	}

	@Override
	public String toString() {
		return "You picked AdvanceToStCharlesPlace Card.";
	}
}
