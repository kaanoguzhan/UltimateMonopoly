package GameSquares;

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
	
	public Land(String name, color color, int price) {
		Details = "If a player owns ALL the Lots of any Color-Group the rent is Doubled on Unimproved Lots in that group.";
		this.name = name;
	}
	
	public Land(String name, color color, int price, String details) {
		this.name = name;
	}
	
	@Override
	public void onArrive() {
		
	}
	
	@Override
	public String toString() {
		if (doubleRent)
			return "Name: " + name +
				"\n Color: " + color +
				"\n Price: " + price +
				"\n Rent: " + rent * 2
				+ "\n Details: " + Details;
		else
			return "Name: " + name +
				"\n Color: " + color +
				"\n Price: " + price +
				"\n Rent: " + rent +
				"\n Details: " + Details;
	}
}
