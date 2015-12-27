package GameSquares;

import Main.Player;

public class Auction extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public Auction(int id) {
        super(id, type.Auction);
    }
    
    @Override
    public void onArrive(Player pl) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
        return "Auction";
    }
    
}
