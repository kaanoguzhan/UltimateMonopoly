package Main;

import java.util.Scanner;

import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;

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
		GameSquare[] gameSquares = new GameSquare[Properties.TotalSquares];
		gameSquares[1] = new Land("Oriental Ave", color.blue, 100);
		gameSquares[3] = new Land("Vermont Ave", color.blue, 100);
		gameSquares[4] = new Land("Connecticut", color.blue, 120);
		gameSquares[6] = new Land("St. Charles Place", color.pink, 140);
		gameSquares[8] = new Land("States Ave", color.pink, 140);
		gameSquares[9] = new Land("Virginia", color.pink, 160);
		gameSquares[11] = new Land("St. James Place", color.orange, 180);
		gameSquares[13] = new Land("Tennessee", color.orange, 180);
		gameSquares[14] = new Land("New York Ave", color.orange, 200);
		gameSquares[16] = new Land("Pacific", color.green, 300);
		gameSquares[17] = new Land("North Carolina", color.green, 300);
		gameSquares[19] = new Land("Pennsylvania", color.green, 320);
	}
}
