package GameSquares;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;

public class Land extends GameSquare {
	
	private String	name;
	private color	color;
	private int		price, rent;
	private boolean	doubleRent;
	public boolean	buy;
	
	public enum color {
		blue, pink, orange, green
	}
	
	public Land(int id, String name, color color, int price, int rent) {
		super(id);
		this.name = name;
		this.color = color;
		this.price = price;
		this.rent = rent;
	}
	
	@Override
	public void onArrive(Player pl) {
		if (this.owner == null) {
			boolean buy = new GetYesNoInput(name, price).getValue();
			
			if (buy) {
				if (pl.getMoney() >= price) {
					pl.buyLand(this);
					System.out.println("Player bought " + this.name + ". Player has "
						+ pl.getNumberOfOwnedByColor(this.color) + " of this color");
					if (pl.getNumberOfOwnedByColor(this.color) == 3)
						System.out.println("Now player will get double rents!!!");
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (this.owner != pl) {
				System.out.println("This land is owned by " + owner.getName());
				if (owner.getNumberOfOwnedByColor(this.color) == 3)
					pl.pay(owner, 2 * rent);
				else
					pl.pay(owner, rent);
			}
			else
				System.out.println("Player already owns this land!");
		}
	}
	public color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void setOwner(Player player) {
		this.owner = player;
	}
	
	public void sell() {
		this.owner.sellLand(this);
	}
	
	@Override
	public Player getOwner() {
		return this.owner;
	}
	
	// ////////// DO NOT USE THESE METHODS - THESE ARE JUST FOR DEBUGGING ////////// //
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(color color) {
		this.color = color;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	// ///////////////////////////////////////////////////////////////////////////// //
	
	@Override
	public String toString() {
		return name;
	}
	
	public String toString2() {
		if (doubleRent)
			return name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent * 2 + " (Doubled since a player owns all three of these colour.)";
		else
			return name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent;
	}
}
