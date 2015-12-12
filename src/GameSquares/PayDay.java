package GameSquares;

import Main.Player;

public class PayDay extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public PayDay(int id) {
        super(id, type.Payday);
    }
    
    @Override
    public void onArrive(Player pl) {
        // Nothing to do, you only get money if you pass...
    }
    
    @Override
    public String toString() {
        return "Pay Day. Location: " + id;
    }
}
