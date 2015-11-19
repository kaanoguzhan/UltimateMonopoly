package GameSquares;

import Main.Player;

public class TransitStation extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	private int					connectedTransit;
	
	public TransitStation(int id, int connectedTransitID) {
		super(id, type.TransitStation);
		this.connectedTransit = connectedTransitID;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Transit station from " + id + " to " + connectedTransit;
	}
}
