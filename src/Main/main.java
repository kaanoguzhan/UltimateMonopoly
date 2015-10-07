package Main;

import java.util.Scanner;

import GameSquares.FreePark;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.Chance.Chance;
import GameSquares.CommunityChest.CommunityChest;

public class main {

	public static void main(String[] args) {
		initializePlayers();
		initializeGameSquares();
	}

	private static void initializePlayers() {
		System.out.println("How many players?");
		Scanner scn = new Scanner(System.in);
		int numOfPlayers = Integer.parseInt(scn.next());
		System.out.println("Write names seperated with spaces");
		Player[] players = new Player[numOfPlayers];
		for (int i = 0; i < numOfPlayers; i++) {
			String name = scn.next();
			players[i] = new Player(name);
		}
		scn.close();
	}

	private static void initializeGameSquares() {
		GameSquare[] gameSquares = new GameSquare[Properties.TotalSquares];

		gameSquares[1] = new Land("Oriental Ave", color.blue, 100);
		gameSquares[2] = new CommunityChest(2);
		gameSquares[3] = new Land("Vermont Ave", color.blue, 100);
		gameSquares[4] = new Land("Connecticut", color.blue, 120);
		gameSquares[6] = new Land("St. Charles Place", color.pink, 140);
		gameSquares[7] = new Chance(7);
		gameSquares[8] = new Land("States Ave", color.pink, 140);
		gameSquares[9] = new Land("Virginia", color.pink, 160);
		gameSquares[10] = new FreePark(10);
		gameSquares[11] = new Land("St. James Place", color.orange, 180);
		gameSquares[12] = new CommunityChest(12);
		gameSquares[13] = new Land("Tennessee", color.orange, 180);
		gameSquares[14] = new Land("New York Ave", color.orange, 200);
		gameSquares[16] = new Land("Pacific", color.green, 300);
		gameSquares[17] = new Land("North Carolina", color.green, 300);
		gameSquares[18] = new Chance(18);
		gameSquares[19] = new Land("Pennsylvania", color.green, 320);
	}
}
