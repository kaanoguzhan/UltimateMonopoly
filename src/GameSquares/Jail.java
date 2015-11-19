package GameSquares;

import Main.Player;

public class Jail extends GameSquare {

	private static final long serialVersionUID = 1L;

	public Jail(int id) {
		super(id, type.Jail);
	}

	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer("You are now in jail for one round.");
		//Method for waiting one round
	}

	@Override
	public String toString() {
		return "Jail. Location: " + id;
	}

}
