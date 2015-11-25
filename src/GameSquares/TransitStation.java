package GameSquares;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class TransitStation extends GameSquare implements Ownable {
	private static final long serialVersionUID = 1L;
	private int price = Properties.TRANSITSTATION_PRICE/2;
	private int depotCost = Properties.TRANSITSTATION_DEPOT_COST;
	private int rent = Properties.TRANSITSTATION_RENT;
	private int DeportCount = 0;
	private int connectedTransit;
	private boolean onlinePricing = false;
	private String name;

	public TransitStation(int id, int connectedTransitID, String name) {
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
				if (pl.getMoney() >= price){
					pl.buySquare(this);
					pl.buySquare(Main.Main.gameSquares[connectedTransit]);
				}
				else
					System.out.println("You don't have enough money!");
			}
		} else if (this.owner != pl) {
			if (pl.hasOnlinePricing()) {
				if (onlinePricing = new GetYesNoInput("You can use OnlinePricing", "Do you want to use it ?")
						.getValue())
					pl.pay(this.getOwner(), rent * (int) Math.pow(2, DeportCount) / 2);
				pl.removeOnlinePricingCard();
			}
			if (!onlinePricing)
				pl.pay(this.getOwner(), rent * (int) Math.pow(2, DeportCount));
		} else if (new GetYesNoInput("Build Train Depot", "Do you want to pay " + depotCost + "$ to build Cab Stand ?")
				.getValue()) {
			pl.reduceMoney(depotCost);
			this.DeportCount++;
		}
	}

	@Override
	public void sell() {
		this.owner.sellSquare(this);
	}

	public int getConnectedTransit(){
		return connectedTransit;		
	}
	
	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name + " Railroad";
	}

	@Override
	public String toString() {
		return "Transit station from " + id + " to " + connectedTransit;
	}
	public boolean isOwned() {
		if (this.owner != null)
			return true;
		else
			return false;
	}
}
