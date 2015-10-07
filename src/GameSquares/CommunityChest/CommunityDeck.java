package GameSquares.CommunityChest;

import java.util.Random;
import GameSquares.CommunityChest.CommunityCard.CommunityCardType;

public class CommunityDeck {
	
	private int		positionCounter	= 0;												// Remembers the next card on
																						// queue.
	public CommunityCard[]	cards			= { new CommunityCard(CommunityCardType.BargainBusiness),
									new CommunityCard(CommunityCardType.BargainBusiness),
									new CommunityCard(CommunityCardType.RecieveConsultancyFee),
									new CommunityCard(CommunityCardType.RecieveConsultancyFee),
									new CommunityCard(CommunityCardType.RenovationSuccess),
									new CommunityCard(CommunityCardType.RenovationSuccess), };
	
	public CommunityDeck() {
		shuffle();
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Swap
			CommunityCard a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}
	
	public CommunityCard draw() {
		return cards[positionCounter++];
	}
}
