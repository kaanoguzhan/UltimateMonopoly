package GameSquares.Chance.ChanceCards;

import gui.CardShower;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToSqueezePlay extends ChanceCard {

	public AdvanceToSqueezePlay() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		pl.moveTo(15);
	}

	@Override
	public String toString() {
		return "You picked AdvanceToSqueezePlay Card.";
	}
}
