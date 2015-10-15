package GameSquares;

import javax.swing.JFrame;

import Main.Dice;
import Main.Player;

public class RollOnce extends GameSquare {
	boolean rolledSame;
	int     winningPrize = 100;
	
	public RollOnce(int id) {
		super(id);
	}

	@Override
	public void onArrive(Player pl) {
		
		gui.RollOnce r = new gui.RollOnce();
		r.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		r.setSize(350,200);
		r.setVisible(true);
		
		rolledSame = r.isRolledSame();
		
		if(rolledSame){
			pl.addMoney(winningPrize);
		} 
		
		
	}

	@Override
	public String toString() {
		return "Roll Once. Location: " + id;
	}

}
