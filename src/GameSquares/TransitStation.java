package GameSquares;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class TransitStation extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	private int					price				= Properties.TRANSITSTATION_PRICE;
	private int					depotCost			= Properties.TRANSITSTATION_DEPOT_COST;
	private int					rent				= Properties.TRANSITSTATION_RENT;
	private int					DeportCount			= 0;
	private int					connectedTransit;
	private String				name;
	
	public TransitStation(int id, String name, int connectedTransitID) {
		super(id, type.TransitStation);
		this.connectedTransit = connectedTransitID;
		this.name = name;
	}
	
	@Override
	public void onArrive(Player pl) {
		if (this.owner == null) {
			boolean buy = new GetYesNoInput("For " + price + " dollars", "Would you like to buy " + name + "Railroad ?")
				.getValue();
			if (buy) {
				if (pl.getMoney() >= price)
					pl.buySquare(this);
				else
					System.out.println("You don't have enough money!");
			}
		} else if (this.owner != pl) {
			pl.pay(this.getOwner(), rent * 2 ^ (DeportCount));
		} else if (new GetYesNoInput("Build Train Depot", "Do you want to pay " + depotCost + "$ to build Cab Stand ?")
			.getValue()) {
			pl.reduceMoney(depotCost);
			this.DeportCount++;
		}
	}
	
	@Override
	public String toString() {
		return "Transit station from " + id + " to " + connectedTransit;
	}
}
