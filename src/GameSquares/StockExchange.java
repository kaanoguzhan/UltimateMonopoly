package GameSquares;

import gui.AdditionalWindows.StockExcWindow;
import Main.Player;

public class StockExchange extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public StockExchange(int id) {
        super(id, type.StockExchange);
        // TODO Auto-generated constructor stub
    }
    
    public enum stockType {
        AcmeMotors(0),
        UnitedRailways(1),
        GeneralRadIO(2),
        NationalUtilities(3),
        AlliedSteamships(4),
        MotionPictures(5);
        
        private int order;
        
        stockType(int order) {
            this.order = order;
        }
        public int getOrder() {
            return order;
        }
    }
    
    @Override
    public void onArrive(Player pl) {
        StockExcWindow ste = new StockExcWindow(pl);
        ste.setVisible(true);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
