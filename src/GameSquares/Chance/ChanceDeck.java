package GameSquares.Chance;

import java.io.Serializable;
import java.util.Random;
import GameSquares.Chance.ChanceCards.*;
import Main.Player;

public class ChanceDeck implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	private int				positionCounter	= 0;	// Remembers the next card on queue.
	private ChanceCard[]	cards			= null;
	
	public ChanceDeck(Player[] players) {
		ChanceCard[] cards = { new AdvanceToSqueezePlay(), new AdvanceToSqueezePlay(),
				new AdvanceToStart(), new AdvanceToStart(),
				new AdvanceToStCharlesPlace(), new AdvanceToStCharlesPlace(),
				new ElectedAsChairPerson(players), new ElectedAsChairPerson(players) };
		this.cards = cards;
		
		shuffle();
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Swap
			ChanceCard a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}
	
	public ChanceCard draw() {
		if (positionCounter < cards.length)
			return cards[positionCounter++];
		return new EmptyCard();
	}
}
