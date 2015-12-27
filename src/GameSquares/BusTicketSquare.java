package GameSquares;

import Main.Player;

public class BusTicketSquare extends GameSquare {
    private static final long serialVersionUID = 1L;
    
    public BusTicketSquare(int id) {
        super(id, type.BusTicket);
    }
    
    @Override
    public void onArrive(Player pl) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
        return "Bus Ticket";
    }
    
}
