package GameSquares;

import java.util.Random;

import javax.swing.JFrame;

import Main.Dice;
import Main.Player;



public class RollOnce extends GameSquare {
	public static boolean	rolledSame;
	static int		winningPrize	= 100;
	public static int rolled;
	
	
	public RollOnce(int id) {
		super(id);
	}
	
	@Override
	public void onArrive(Player pl) {
		
		gui.RollOnce r = new gui.RollOnce(pl);
		r.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		r.setSize(350, 200);
		r.setVisible(true);
		

	}
	
	public static void isRolledSame(Player pl){
		rolled = new Dice().roll();
		int roll = new Random().nextInt(6) +1;
		
		if (rolled == roll) {
			rolledSame = true;
			pl.addMoney(winningPrize);
		} else {
			rolledSame = false;			
		}
		
		
		
	}
	
	@Override
	public String toString() {
		return "Roll Once. Location: " + id;
	}
}
