package GameSquares;

import Main.Player;

public class StartSquare extends GameSquare {

	public StartSquare(int id) {
		this.id = id;
	}

	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Start Square. Location: " + id;
	}

}
