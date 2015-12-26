package GameSquares;

import gui.AdditionalWindows.StockExcWindow;
import Main.Player;

public class StockExchange extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public StockExchange(int id) {
        super(id, type.StockExchange);
    }
    
    public enum stockType {
        AcmeMotors(0, 100,"AcmeMotors Stock Share"),
        UnitedRailways(1, 110,"UnitedRailways Stock Share"),
        GeneralRadIO(2, 120,"GeneralRadIO Stock Share"),
        NationalUtilities(3, 130,"NationalUtilities Stock Share"),
        AlliedSteamships(4, 140,"AlliedSteamships Stock Share"),
        MotionPictures(5, 150,"MotionPictures Stock Share");
        
        private int order;
        private int price;
        private String value;
        
        stockType(int order, int price,String value) {
            this.order = order;
            this.price = price;
            this.value = value;
        }
        public static stockType getStock(int i){
        	for(stockType st:stockType.values())
        		if(st.order==i)
        			return st;
        	return null;
        }
        public int getOrder() {
            return order;
        }
        public int getPrice() {
            return price;
        }
        public String getValue(){
        	return value;
        }
        
        @Override
        public String toString(){
        	return value;
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
