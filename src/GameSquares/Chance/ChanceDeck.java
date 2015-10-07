package GameSquares.Chance;

import java.util.Random;
import GameSquares.Chance.ChanceCard.chanceCardType;

public class ChanceDeck {
	
	private int		positionCounter	= 0;												// Remembers the next card on
																						// queue.
	public ChanceCard[]	cards			= { new ChanceCard(chanceCardType.AdvanceToSqueezePlay),
									new ChanceCard(chanceCardType.AdvanceToSqueezePlay),
									new ChanceCard(chanceCardType.AdvanceToStart),
									new ChanceCard(chanceCardType.AdvanceToStart),
									new ChanceCard(chanceCardType.AdvanceToStCharlesPlace),
									new ChanceCard(chanceCardType.AdvanceToStCharlesPlace),
									new ChanceCard(chanceCardType.ElectedAsChairPerson),
									new ChanceCard(chanceCardType.ElectedAsChairPerson), };
	
	public ChanceDeck() {
		shuffle();
	}
	
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Swap
			ChanceCard a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}
	
	public ChanceCard draw() {
		return cards[positionCounter++];
	}
}
