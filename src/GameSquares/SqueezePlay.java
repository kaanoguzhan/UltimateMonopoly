package GameSquares;

import javax.swing.JFrame;

import Main.Dice;
import Main.Player;

public class SqueezePlay extends GameSquare {
	
	private static Player[]	players;
	public static int rolled;
	public static volatile boolean	rolledEven = false;
	
	public SqueezePlay(int id, Player[] players) {
		super(id);
		SqueezePlay.players = players;
	}
	
	@Override
	public void onArrive(Player pl) {
		
		gui.SqueezePlay r = new gui.SqueezePlay(pl);
		r.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		r.setSize(350, 200);
		r.setVisible(true);		
		
			}
	
	public static void isRolledEven(Player pl){
	rolled = new Dice().roll();
	
	if ((rolled % 2) == 0) {
		rolledEven = true;
		for (int i = 0; i < players.length; i++) {
			if (pl != players[i])
				players[i].pay(pl, 200);
	
		}
	} else rolledEven = false;
	}
	
	@Override
	public String toString() {
		return "Squeeze Play. Location: " + id;
	}
	
}
