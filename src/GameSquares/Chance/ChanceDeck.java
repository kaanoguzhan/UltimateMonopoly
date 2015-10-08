package GameSquares.Chance;

import java.util.Random;
import GameSquares.Chance.ChanceCards.*;

public class ChanceDeck {
	
	private int				positionCounter	= 0;							// Remembers the next card on queue.
	private ChanceCard[]	cards			= { new AdvanceToSqueezePlay(),
											new AdvanceToSqueezePlay(),
											new AdvanceToStart(),
											new AdvanceToStart(),
											new AdvanceToStCharlesPlace(),
											new AdvanceToStCharlesPlace(),
											new ElectedAsChairPerson(),
											new ElectedAsChairPerson() };
	
	
	
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
