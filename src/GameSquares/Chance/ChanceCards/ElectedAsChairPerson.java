package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class ElectedAsChairPerson extends ChanceCard {

	private Player[] players = null;

	public ElectedAsChairPerson(Player[] players) {
		this.players = players;
	}

	@Override
	public void onDraw(Player pl) {
		for (int i = 0; i < players.length; i++) {
			if (pl == players[i])
				pl.reduceMoney((players.length - 1) * 50);
			else
				players[i].addMoney(50);

		}
	}
}
