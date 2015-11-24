package GameSquares;

import Main.Player;

public class GoToJail extends GameSquare {
	
	private static final long	serialVersionUID	= 1L;
	private int jailID = 10;
	
	public GoToJail(int id) {
		super(id, type.GotoJail);
	}
	
	@Override
	public void onArrive(Player pl) {
		System.out.println("Player:" + pl.getName() + " is now in jail for three rounds.");
		pl.setJailed(true);
		pl.moveTo(jailID);
	}
	
	@Override
	public String toString() {
		return "Go To Jail. Location: " + id;
	}
	
}
