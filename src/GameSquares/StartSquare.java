package GameSquares;

import Main.Player;

public class StartSquare extends GameSquare {
	
	public StartSquare(int id) {
		super(id);
	}
	
	@Override
	public void onArrive(Player pl) {
		// Start Square does nothing!
	}
	
	@Override
	public String toString() {
		return "Start Square. Location: " + id;
	}
	
}
