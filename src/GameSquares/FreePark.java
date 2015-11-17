package GameSquares;

import Main.Player;

public class FreePark extends GameSquare {
	private static final long	serialVersionUID	= 1L;

	public FreePark(int id) {
		super(id,type.FreePark);
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
