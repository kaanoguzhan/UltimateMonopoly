package Main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Player pl = new Player(); // to be deleted

		initializePlayers();
		initializeGameSquares();

	}	

	private static void initializePlayers() {
		System.out.print("How many players?");
		Scanner scn = new Scanner(System.in);
		int numOfPlayers = Integer.parseInt(scn.next());
		scn.close();
		Player[] players = new Player[numOfPlayers];
		for (int i = 0; i < numOfPlayers; i++) {
			players[i] = new Player();
		}
	}

	private static void initializeGameSquares() {

	}
}
