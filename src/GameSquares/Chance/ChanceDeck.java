package GameSquares.Chance;

import java.util.Random;
import GameSquares.Chance.Card.chanceCardType;

public class ChanceDeck {
	
	private int		positionCounter	= 0;												// Remembers the next card on
																						// queue.
	public Card[]	cards			= { new Card(chanceCardType.AdvanceToSqueezePlay),
									new Card(chanceCardType.AdvanceToSqueezePlay),
									new Card(chanceCardType.AdvanceToStart),
									new Card(chanceCardType.AdvanceToStart),
									new Card(chanceCardType.AdvanceToStCharlesPlace),
									new Card(chanceCardType.AdvanceToStCharlesPlace),
									new Card(chanceCardType.ElectedAsChairPerson),
									new Card(chanceCardType.ElectedAsChairPerson), };
	
	public ChanceDeck() {
		shuffle();
	}
	
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Swap
			Card a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}
	
	public Card draw() {
		return cards[positionCounter++];
	}
}
