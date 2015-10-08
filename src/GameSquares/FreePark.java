package GameSquares;

import Main.Player;

public class FreePark extends GameSquare {
	
	public FreePark(int id) {
		this.id = id;
	}
	
	@Override
	public void onArrive(Player pl) {
		// Do nothing, its FreePark and therefore is totally FREE!!!
		
	}
	
	@Override
	public String toString() {
		return "Free Park. Location: " + id;
	}
}
