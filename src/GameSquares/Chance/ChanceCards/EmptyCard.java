package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class EmptyCard extends ChanceCard {
	
	@Override
	public void onDraw(Player pl) {
		System.out.println("There are no more cards left");
	}
	
}
