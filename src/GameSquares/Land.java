package GameSquares;

import Main.Player;

public class Land extends GameSquare {
	
	private String	name;
	private color	color;
	private int		price;
	private int		rent;
	private boolean	doubleRent;
	private String	Details;
	
	public enum color {
		blue, pink, orange, green
	}
	
	public Land(int id, String name, color color, int price) {
		Details = "If a player owns ALL the Lots of any Color-Group the rent is Doubled on Unimproved Lots in that group.";
		this.id = id;
		this.name = name;
	}
	
	public Land(String name, color color, int price, String details) {
		this.name = name;
	}
	
	@Override
	public void onArrive(Player pl) {
		
	}
	
	@Override
	public String toString() {
		if (doubleRent)
			return "Name: " + name +
				"\n Color: " + color +
				"\n Price: " + price +
				"\n Rent: " + rent * 2 + " (Doubled since a player owns all three of these colour.)"
				+ "\n Details: " + Details;
		else
			return "Name: " + name +
				"\n Color: " + color +
				"\n Price: " + price +
				"\n Rent: " + rent +
				"\n Details: " + Details;
	}
}
