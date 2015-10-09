package GameSquares;

import Main.Dice;
import Main.Player;

public class SqueezePlay extends GameSquare {
	
	private Player[]	players	= null;
	
	public SqueezePlay(int id, Player[] players) {
		super(id);
		this.players = players;
	}
	
	@Override
	public void onArrive(Player pl) {
		Dice dice = new Dice();
		
		System.out.println("Please roll a die and get $200 from everyone if the number is even.");
		
		int roll = dice.roll();
		System.out.println("You rolled: " + roll); // GUI rolling die
		if ((roll % 2) == 0) {
			System.out.println(pl.getName() + " rolled even number" +
				"\n" + pl.getName() + " will get money from everyone");
			for (int i = 0; i < players.length; i++) {
				if (pl == players[i])
					pl.addMoney((players.length - 1) * 200);
				else
					players[i].reduceMoney(200);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Squeeze Play. Location: " + id;
	}
	
}
