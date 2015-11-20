package GameSquares;

import Main.Player;

public class GoToJail extends GameSquare {

	private static final long serialVersionUID = 1L;

	public GoToJail(int id) {
		super(id, type.GotoJail);
	}

	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer("You are now in jail for one round.");
		// Method for waiting one round
	}

	@Override
	public String toString() {
		return "Go To Jail. Location: " + id;
	}

}
