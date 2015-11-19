package GameSquares;

import Main.Player;

public class TransitStation extends GameSquare {
	private static final long serialVersionUID = 1L;
	
	public int destinationId;

	public TransitStation(int id, int desinationId) {
		super(id, type.TransitStation);
		this.destinationId = desinationId;
	}

	@Override
	public void onArrive(Player pl) {
	}

	@Override
	public String toString() {
		return "transit station";
	}

}
