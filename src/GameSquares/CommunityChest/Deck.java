package GameSquares.CommunityChest;

import java.util.Random;
import GameSquares.CommunityChest.Card.cardType;

public class Deck {
	
	private int		positionCounter	= 0;										// Remembers the next card on queue.
	public Card[]	cards			= { new Card(cardType.BargainBusiness),
									new Card(cardType.BargainBusiness),
									new Card(cardType.RecieveConsultancyFee),
									new Card(cardType.RecieveConsultancyFee),
									new Card(cardType.RenovationSuccess),
									new Card(cardType.RenovationSuccess), };
	
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
