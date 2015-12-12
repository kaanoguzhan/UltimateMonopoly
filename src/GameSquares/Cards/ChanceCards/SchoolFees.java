package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class SchoolFees extends ChanceCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public SchoolFees() {
        super(CardType.SchoolFees, false);
    }
    
    @Override
    public void onDraw(Player pl) {
        new MessageDisplayer(toString());
        // Pay the pool $150
    }
    
    @Override
    public String toString() {
        return "You picked SchoolFees Card.";
    }
    
    @Override
    public String getName() {
        return "School Fees";
    }
    
}
