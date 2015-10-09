package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class ElectedAsChairPerson extends ChanceCard {
	
	private Player[]	players	= null;
	
	public ElectedAsChairPerson(Player[] players) {
		this.players = players;
	}
	
	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName() + " picked ElectedAsChairPerson Card. Now " + pl.getName()
			+ " will pay everyone");
		for (int i = 0; i < players.length; i++) {
			if (pl != players[i])
				pl.pay(players[i], 50);
		}
	}
}
