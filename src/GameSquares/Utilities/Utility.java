package GameSquares.Utilities;

import gui.AdditionalWindows.MessageDisplayer;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import GameSquares.GameSquare;
import GameSquares.Ownable;
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
			boolean buy = new GetYesNoInput("For " + Properties.UTILITY_MONEY + " dollars", "Would you like to buy "
				+ name + " ?")
				.getValue();
			
			boolean bargain = false;
			if (pl.hasBargainBusiness())
				bargain = new GetYesNoInput("You can use BargainBusiness", "Do you want to use it ?")
					.getValue();
			
			if (buy) {
				if (pl.getMoney() >= Properties.UTILITY_MONEY) {
					int price = Properties.UTILITY_MONEY;
					if (bargain) {
						price = Properties.BARGAINBUSINESS_PRICE;
						pl.removeBargainBusinessCard();
					}
					pl.buySquare(this);
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (this.owner != pl) {
				int totalRent = amount*this.owner.numOfOwnedUtilities();
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
		return Properties.UTILITY_MONEY;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
