package GameSquares;

import Main.Player;

public class Land extends GameSquare {

	private String name, details;
	private color color;
	private int price, rent;
	private boolean doubleRent;
	private boolean buy;

	public enum color {
		blue, pink, orange, green
	}

	public Land(int id, String name, color color, int price) {
		super(id);
		this.name = name;
		this.color = color;
		this.price = price;
		details = "If a player owns ALL the Lots of any Color-Group the rent is Doubled on Unimproved Lots in that group.";
	}

	public Land(int id, String name, color color, int price, String details) {
		super(id);
		this.name = name;
	}

	@Override
	public void onArrive(Player pl) {
		if (this.owner == null) {
			if (buy) { // (GUI) If player want to play ==> buy = true
				if (pl.getMoney() >= price) {
					pl.reduceMoney(price);
					owner = pl;
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (doubleRent) {
				pl.reduceMoney(2 * rent);
				owner.addMoney(2 * rent);
			} else {
				pl.reduceMoney(rent);
				owner.addMoney(rent);
			}
		}
	}

	@Override
	public String toString() {
		if (doubleRent)
			return "Land. Location: " + id + "\n Name: " + name + "\n Color: " + color + "\n Price: " + price
					+ "\n Rent: " + rent * 2 + " (Doubled since a player owns all three of these colour.)"
					+ "\n Details: " + details;
		else
			return "Land. Location: " + id + "\n Name: " + name + "\n Color: " + color + "\n Price: " + price
					+ "\n Rent: " + rent + "\n Details: " + details;
	}
}
