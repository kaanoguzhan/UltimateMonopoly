package GameSquares.Utilities;

import GameSquares.GameSquare;
import GameSquares.GameSquare.type;
import Main.Player;

public class TrashCollector extends GameSquare {
	private static final long	serialVersionUID	= 1L;

	public TrashCollector(int id) {
		super(id, type.ThrashCollector);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}