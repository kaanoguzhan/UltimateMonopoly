package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import gui.AdditionalWindows.InputReaders.GetTextInput;
import java.io.Serializable;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class BusTicket extends ChanceCard implements Serializable {
    private static final long serialVersionUID = 1L;
    private int               sideStart, sideEnd, moveTo;
    private Integer           trackStart;
    
    public BusTicket() {
        super(CardType.BusTicket, false);
    }
    
    @Override
    public void onDraw(Player pl) {
        new MessageDisplayer(toString());
        for (CardType c : pl.getCardsInventory()) {
            if (c.isChanceCard())
                pl.getCardsInventory().remove(c);
        }
        trackStart = null;
        if (pl.getLocation() == 7) {
            sideStart = 0;
            sideEnd = 10;
        } else if (pl.getLocation() == 22) {
            sideStart = 20;
            sideEnd = 30;
        } else if (pl.getLocation() == 36) {
            sideStart = 30;
            sideEnd = 39;
            trackStart = 0;
        } else if (pl.getLocation() == 50) {
            sideStart = 40;
            sideEnd = 54;
        } else if (pl.getLocation() == 61) {
            sideStart = 54;
            sideEnd = 68;
        } else if (pl.getLocation() == 70) {
            sideStart = 68;
            sideEnd = 82;
        } else if (pl.getLocation() == 94) {
            sideStart = 82;
            sideEnd = 95;
            trackStart = 40;
        } else if (pl.getLocation() == 112) {
            sideStart = 108;
            sideEnd = 114;
        }
        if (trackStart == null) {
            new gui.AdditionalWindows.MessageDisplayer("You are at Square " + pl.getLocation()
                + ". You can go to Square " + sideStart + "-" + sideEnd);
            moveTo = -1;
            while (!(moveTo >= sideStart && moveTo <= sideEnd))
                moveTo = new GetTextInput("Enter the square you want to go!").getInt();
        } else {
            new gui.AdditionalWindows.MessageDisplayer("You are at Square " + pl.getLocation()
                + ". You can go to Square " + sideStart + "-" + sideEnd + " and " + trackStart);
            moveTo = -1;
            while (!(moveTo >= sideStart && moveTo <= sideEnd) || moveTo != trackStart)
                moveTo = new GetTextInput("Enter the square you want to go!").getInt();
        }
        pl.moveTo(moveTo);
    }
    
    public String toString() {
        return "You picked BusTicket Card.";
    }
    
    @Override
    public String getName() {
        return "Bus Ticket";
    }
    
}
