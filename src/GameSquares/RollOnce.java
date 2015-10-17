package GameSquares;

import javax.swing.WindowConstants;
import Main.Dice;
import Main.Player;

public class RollOnce extends GameSquare {
	public static volatile boolean	rolledSame		= false;
	static int						winningPrize	= 100;
	public static int				rolled, randomRoll;
	
	
	public RollOnce(int id) {
		super(id);
	}
	
	@Override
	public void onArrive(Player pl) {
		gui.AdditionalWindows.RollOnce r = new gui.AdditionalWindows.RollOnce(pl);
		r.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		r.setSize(350, 200);
		r.setVisible(true);
	}
	
	public static void isRolledSame(Player pl, int randomRoll) {
		rolled = new Dice().roll();
		if (rolled == randomRoll) {
			rolledSame = true;
			pl.addMoney(winningPrize);
		} else
			rolledSame = false;
		
	}
	
	@Override
	public String toString() {
		return "Roll Once. Location: " + id;
	}
}
