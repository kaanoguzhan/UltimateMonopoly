package GameSquares;

import java.util.Scanner;
import Main.Player;

public class Land extends GameSquare {
	
	private String	name, details;
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
			// Just for testing will be removed with GUI
			Scanner scan = new Scanner(System.in);
			buy = scan.nextBoolean();
			//
			if (buy) { // (GUI) If player want to play ==> buy = true
				if (pl.getMoney() >= price) {
					pl.reduceMoney(price);
					owner = pl;
					pl.getOwnership(this);
					System.out.println("Player bought " + this.name + ". Player has "
						+ pl.getNumberOfOwnedByColor(this.color) + " of this color");
					if (pl.getNumberOfOwnedByColor(this.color) == 3)
						System.out.println("Now player will get double rents!!!");
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (this.owner != pl)
				if (pl.getNumberOfOwnedByColor(this.color) == 3) {
					System.out.println(pl.getName() + " paid to " + owner.getName());
					pl.reduceMoney(2 * rent);
					owner.addMoney(2 * rent);
				} else {
					System.out.println(pl.getName() + " paid to " + owner.getName());
					pl.reduceMoney(rent);
					owner.addMoney(rent);
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
	public String toString() {
		if (doubleRent)
			return "Location: " + id + "\n Name: " + name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent * 2 + " (Doubled since a player owns all three of these colour.)"
				+ "\n Details: " + details;
		else
			return "Location: " + id + "\n Name: " + name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent + "\n Details: " + details;
	}
}
