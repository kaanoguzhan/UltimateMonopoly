package GameSquares.Chance.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class EmptyCard extends ChanceCard {
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
	}
	
	@Override
	public String toString() {
		return "There are no more cards left.";
	}
	
}
