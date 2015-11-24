package GameSquares;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class Utility extends GameSquare implements Ownable {
	private static final long	serialVersionUID	= 1L;
	private String				name;
	
	public Utility(int id, String name, type type) {
		super(id, type);
		this.name = name;
	}
	
	public void onArrive(Player pl, int amount) {
		if (this.owner == null) {
			boolean buy = new GetYesNoInput("For " + Properties.UTILITY_PRICE + " dollars", "Would you like to buy "
				+ name + " ?")
				.getValue();
			
			if (buy) {
				if (pl.getMoney() >= Properties.UTILITY_PRICE) {
					pl.buySquare(this);
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (this.owner != pl) {
				int totalRent = amount;
				switch (this.owner.numOfOwnedUtilities()) {
					case 1:
						totalRent *= 4;
						break;
					case 2:
						totalRent *= 10;
						break;
					case 3:
						totalRent *= 20;
						break;
					case 4:
						totalRent *= 40;
						break;
					case 5:
						totalRent *= 80;
						break;
					case 6:
						totalRent *= 100;
						break;
					case 7:
						totalRent *= 120;
						break;
					case 8:
						totalRent *= 150;
						break;
				}
				System.out.println("This Utility is owned by " + owner.getName());
				
				pl.pay(owner, totalRent);
			}
			else
				System.out.println("Player already owns this land!");
		}
	}
	@Override
	public void onArrive(Player pl) {
		// Use other onArrive for this GameSquare
	}
	
	
	@Override
	public void sell() {
		this.owner.sellSquare(this);
	}
	
	@Override
	public int getPrice() {
		return Properties.UTILITY_PRICE;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}