package GameSquares;

import Main.Player;

public class IncomeTax extends GameSquare {
	private static final long serialVersionUID = 1L;

	protected IncomeTax(int id) {
		super(id, type.IncomeTax);
	}
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "income tax";
	}

}