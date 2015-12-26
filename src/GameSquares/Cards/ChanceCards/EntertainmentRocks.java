package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Cards.ChanceCard;
import Main.Player;

public class EntertainmentRocks extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public EntertainmentRocks() {
		super(CardType.EntertainmentRocks, false);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		//Stakeholders in Motion Pictures and General can immediately collect dividends
	}

	public String toString() {
		return "You picked EntertainmentRocks Card.";
	}

	@Override
	public String getName() {
		return "Entertainment Rocks";
	}

}
