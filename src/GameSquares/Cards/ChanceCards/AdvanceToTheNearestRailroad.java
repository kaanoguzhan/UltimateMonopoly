package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class AdvanceToTheNearestRailroad extends ChanceCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public AdvanceToTheNearestRailroad() {
        super(CardType.AdvanceToTheNearestRailroad, false);
    }
    
    @Override
    public void onDraw(Player pl) {
        new MessageDisplayer(toString());
        // moveTo nearest RailRoad
    }
    
    @Override
    public String toString() {
        return "You picked AdvanceToTheNearestRailRoad Card.";
    }
    
    @Override
    public String getName() {
        return "Advance to the nearest Railroad";
    }
}
