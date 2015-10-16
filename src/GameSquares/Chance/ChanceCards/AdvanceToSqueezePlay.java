package GameSquares.Chance.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToSqueezePlay extends ChanceCard {

	public AdvanceToSqueezePlay() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveTo(15);
	}

	@Override
	public String toString() {
		return "You picked AdvanceToSqueezePlay Card.";
	}
}
