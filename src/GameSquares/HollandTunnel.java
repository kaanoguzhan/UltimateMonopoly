package GameSquares;

import Main.Player;

public class HollandTunnel extends GameSquare {

	private static final long serialVersionUID = 1L;
	private final int firstHollandTunnel = 54;
	private final int secondHollandTunnel = 114;

	public HollandTunnel(int id) {
		super(id, type.HollandTunnel);
	}

	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer("You are directly moving to the other Holland Tunnel.");
		if (id == firstHollandTunnel)
			pl.moveTo(secondHollandTunnel);
		else
			pl.moveTo(firstHollandTunnel);
	}

	@Override
	public String toString() {
		return "Holland Tunnel. Location: " + id;
	}

}
