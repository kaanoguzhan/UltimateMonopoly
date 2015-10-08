package Main;

public class Test {
	
	private Player[]	players;
	private Dice		dice	= new Dice();
	
	public Test(Player[] players) {
		this.players = players;
	}
	
	public void playForRound(int round) {
		for (int i = 1; i < round + 1; i++) {
			System.out.println("Round " + i + " -----------------------------------------------------");
			for (int j = 0; j < players.length; j++) {
				int[] rolls = { dice.roll(), dice.roll() };
				System.out.println("Player " + j + " ********** rolled:" + rolls[0] + "," + rolls[1]);
				players[j].moveBy(rolls[0] + rolls[1]);
			}
		}
		System.out.println("==============================================0");
		for (int j = 0; j < players.length; j++) {
			System.out.println(players[j]);
		}
	}
}