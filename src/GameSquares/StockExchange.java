package GameSquares;

import gui.AdditionalWindows.StockExcWindow;
import Main.Player;

public class StockExchange extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public StockExchange(int id) {
        super(id, type.StockExchange);
    }
    
    public enum stockType {
        AcmeMotors(0, 100),
        UnitedRailways(1, 110),
        GeneralRadIO(2, 120),
        NationalUtilities(3, 130),
        AlliedSteamships(4, 140),
        MotionPictures(5, 150);
        
        private int order;
        private int price;
        
        stockType(int order, int price) {
            this.order = order;
            this.price = price;
        }
        public int getOrder() {
            return order;
        }
        public int getPrice() {
            return price;
        }
    }
    
    @Override
    public void onArrive(Player pl) {
        StockExcWindow ste = new StockExcWindow(pl);
        ste.setVisible(true);
    }
    
    @Override
    public String toString() {
        return "Stock Exchange Square";
    }
}
