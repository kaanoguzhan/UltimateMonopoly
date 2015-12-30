package GameSquares;

import Main.Player;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import gui.Board.RollingTheDice;

public class BirthdayGiftSquare extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    private final int         giftMoney        = 100;
    private final int         nearestCabId     = 46;
    
    public BirthdayGiftSquare(int id) {
        super(id, type.BirthdayGift);
    }
    
    @Override
    public void onArrive(Player pl) {
        RollingTheDice.logAdd(pl.getName() + " moved to " + toString());
        boolean birthdayGiftChoice = new GetYesNoInput("You can get " + giftMoney + "$ or go to the nearest cab",
            "Do you want get the " + giftMoney + "$?").getValue();
        
        if (birthdayGiftChoice) {
            pl.addMoney(giftMoney);
            RollingTheDice.logAdd(pl.getName() + " got gift money.");
        }
        else {
            pl.moveTo(nearestCabId);
            RollingTheDice.logAdd(pl.getName() + " went to the nearest Cab");
        }
    }
    @Override
    public String toString() {
        return "Bithday Gift Square";
    }
    
}
