package GameSquares.Chance;

import java.io.Serializable;
import java.util.Random;

import GameSquares.Chance.ChanceCards.*;
import Main.Player;

public class ChanceDeck implements Serializable {
	private static final long serialVersionUID = 1L;
	private ChanceCard[] cards = null;

	public ChanceDeck(Player[] players) {
		ChanceCard[] cards = { new AdvanceToSqueezePlay(), new AdvanceToStart(), new AdvanceToStCharlesPlace(),
				new AdvanceToTheNearestRailroad(), new AdvanceToTheNearestUtility(), new ElectedAsChairPerson(players),
				new GeneralRepairs(), new GetOutOfJail(), new GoToJail(), new SchoolFees(), new ThreeSpacesBack() };
		this.cards = cards;
	}

	public ChanceCard draw() {
		return cards[new Random().nextInt(cards.length)];
	}
}
