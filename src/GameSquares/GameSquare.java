package GameSquares;

import java.io.Serializable;
import Main.Player;

public abstract class GameSquare implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected int             id;
    protected type            cardType;
    protected Player          owner;

    protected GameSquare(int id, type type) {
        this.id = id;
        this.cardType = type;
    }
    
    public enum type {
        Chance, CommunityChest, FreePark, Land, RollOnce, StartSquare, SqueezePlay, Cab,
        LuxuryTax, TransitStation, Jail, ElectricCompany, WaterWorks, Subway, BusTicket,
        CableCompany, Tunnel, Auction, InternetServiceProvider, Payday, TrashCollector,
        StockExchange, TaxRefund, GasCompany, HollandTunnel, ReverseDirection, IncomeTax,
        GotoJail, Bus, SewegeSystem, BirthdayGift, TelephoneCompany, Bonus
    }
    
    public abstract void onArrive(Player pl);
    
    @Override
    public abstract String toString();
    
    public void setOwner(Player pl) {
        owner = pl;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public String getType() {
        return cardType.toString();
    }
    
    public int getID() {
        return id;
    }
    
    public boolean repOK(){
    	return (120>id)&&(id>=0);
    }
}
