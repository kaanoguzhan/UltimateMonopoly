package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import gui.AdditionalWindows.StockExcWindow;
import java.io.Serializable;
import GameSquares.Cards.CommunityChestCard;
import Main.Player;

public class InheritStock extends CommunityChestCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public InheritStock() {
        super(CardType.InheritStock, false);
    }
    
    @Override
    public void onDraw(Player pl) {
        new MessageDisplayer(toString());
        StockExcWindow ste = new StockExcWindow(pl, 1);
        ste.setVisible(true);
    }
    
    public String toString() {
        return "You picked InheritStock Card.";
    }
    
    @Override
    public String getName() {
        
        return "Inherit Stock";
    }
    
}
