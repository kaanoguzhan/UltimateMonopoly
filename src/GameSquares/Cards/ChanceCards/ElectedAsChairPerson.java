package GameSquares.Cards.ChanceCards;

import java.io.Serializable;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class ElectedAsChairPerson extends ChanceCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	private Player[]	players	= null;
	
	public ElectedAsChairPerson(Player[] players) {
		this.players = players;
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
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
