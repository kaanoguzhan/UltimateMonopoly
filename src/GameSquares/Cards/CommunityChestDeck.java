package GameSquares.Cards;

import java.io.Serializable;
import java.util.Random;
import GameSquares.Cards.CommunityChestCards.HouseCondemned;
import GameSquares.Cards.CommunityChestCards.OnlinePricing;
import GameSquares.Cards.CommunityChestCards.StreetRepair;

public class CommunityChestDeck implements Serializable, Deck {
    private static final long    serialVersionUID = 1L;
    private CommunityChestCard[] cards            = null;
    
    public CommunityChestDeck() {
        CommunityChestCard[] cards = {				// new BargainBusiness(),
        new HouseCondemned(), new OnlinePricing(),
                // new RecieveConsultancyFee(), new RenovationSuccess(),
                new StreetRepair() };
        this.cards = cards;
    }
    
    public CommunityChestCard draw() {
        return cards[new Random().nextInt(cards.length)];
    }
    
    public CommunityChestCard[] getDeck() {
        return cards;
    }
}
