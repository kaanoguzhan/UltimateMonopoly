package GameSquares;

public class Land extends GameSquare {

	private String name;
	private color color;
	private int price;
	private String Details;

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

}
