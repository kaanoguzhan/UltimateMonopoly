package GameSquares;

import gui.AdditionalWindows.StockExcWindow;
import Main.Player;

public class StockExchange extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public StockExchange(int id) {
        super(id, type.StockExchange);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void onArrive(Player pl) {
        StockExcWindow ste = new StockExcWindow();
        ste.setVisible(true);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
