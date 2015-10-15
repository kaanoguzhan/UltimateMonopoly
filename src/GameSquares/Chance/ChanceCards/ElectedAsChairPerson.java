package GameSquares.Chance.ChanceCards;

import gui.CardShower;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class ElectedAsChairPerson extends ChanceCard {
	
	private Player[]	players	= null;
	
	public ElectedAsChairPerson(Player[] players) {
		this.players = players;
	}
	
	@Override
	public void onDraw(Player pl) {
		new CardShower(this);
		for (int i = 0; i < players.length; i++) {
			if (pl != players[i])
				pl.pay(players[i], 50);
		}
	}

	@Override
	public String toString() {
		return "You picked ElectedAsChairPerson Card. Now you will pay everyone.";
	}
}
