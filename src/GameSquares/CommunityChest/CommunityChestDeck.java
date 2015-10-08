package GameSquares.CommunityChest;

import java.util.Random;
import GameSquares.CommunityChest.CommunityChestCards.*;

public class CommunityChestDeck {
	
	private int						positionCounter	= 0;	// Remembers the next card on queue.
	private CommunityChestCard[]	cards			= null;
	
	public CommunityChestDeck() {
		CommunityChestCard[] cards = { new BargainBusiness(), new BargainBusiness(),
				new RecieveConsultancyFee(), new RecieveConsultancyFee(),
				new RenovationSuccess(), new RenovationSuccess(), };
		this.cards = cards;
		
		shuffle();
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Swap
			CommunityChestCard a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}
	
	public CommunityChestCard draw() {
		if (positionCounter < cards.length)
			return cards[positionCounter++];
		return new EmptyCard();
	}
}
