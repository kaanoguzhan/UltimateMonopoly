package GameSquares.Cards.ChanceCards;

import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class GeneralRepairs extends ChanceCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public GeneralRepairs() {
        super(CardType.GeneralRepairs, false);
    }
    
    @Override
    public void onDraw(Player pl) {
        // Repairs
    }
    
    @Override
    public String toString() {
        return "You picked General Repairs Card.";
    }
    
    @Override
    public String getName() {
        return "General repairs";
    }
}
