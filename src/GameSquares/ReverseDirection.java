package GameSquares;

import Main.Player;

public class ReverseDirection extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public ReverseDirection(int id) {
        super(id, type.ReverseDirection);
    }
    
    @Override
    public void onArrive(Player pl) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
        return "Reverse Direction";
    }
    
}
