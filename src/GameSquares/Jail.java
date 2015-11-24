package GameSquares;

import Main.Player;

public class Jail extends GameSquare {

	private static final long serialVersionUID = 1L;

	public Jail(int id) {
		super(id, type.Jail);
	}

	@Override
	public void onArrive(Player pl) {
		if (pl.isJailed()) {
			
		} else
			System.out.println("You are visiting jail.");
	}

	@Override
	public String toString() {
		return "Jail. Location: " + id;
	}

}
