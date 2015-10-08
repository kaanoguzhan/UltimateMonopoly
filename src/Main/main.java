package Main;

import java.util.Scanner;
import GameSquares.FreePark;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.RollOnce;
import GameSquares.SqueezePlay;
import GameSquares.StartSquare;
import GameSquares.Chance.Chance;
import GameSquares.Chance.ChanceDeck;
import GameSquares.CommunityChest.CommunityChest;
import GameSquares.CommunityChest.CommunityChestDeck;

public class main {
	
	public static void main(String[] args) {
		initializePlayers();
		initializeDecks();
		initializeGameSquares();
	}
	
	static ChanceDeck			ChanceDeck		= null;
	static CommunityChestDeck	CommunityDeck	= null;
	static GameSquare[]			gameSquares		= null;
	
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
	
	private static void initializeDecks() {
		ChanceDeck = new ChanceDeck();
		CommunityDeck = new CommunityChestDeck();
	}
	
	
	private static void initializeGameSquares() {
		GameSquare[] gameSquares = new GameSquare[Properties.TotalSquares];
		
		gameSquares[0] = new StartSquare(0);
		gameSquares[1] = new Land(1, "Oriental Ave", color.blue, 100);
		gameSquares[2] = new CommunityChest(2, CommunityDeck);
		gameSquares[3] = new Land(3, "Vermont Ave", color.blue, 100);
		gameSquares[4] = new Land(4, "Connecticut", color.blue, 120);
		gameSquares[5] = new RollOnce(5);
		gameSquares[6] = new Land(6, "St. Charles Place", color.pink, 140);
		gameSquares[7] = new Chance(7, ChanceDeck);
		gameSquares[8] = new Land(8, "States Ave", color.pink, 140);
		gameSquares[9] = new Land(9, "Virginia", color.pink, 160);
		gameSquares[10] = new FreePark(10);
		gameSquares[11] = new Land(11, "St. James Place", color.orange, 180);
		gameSquares[12] = new CommunityChest(12, CommunityDeck);
		gameSquares[13] = new Land(13, "Tennessee", color.orange, 180);
		gameSquares[14] = new Land(14, "New York Ave", color.orange, 200);
		gameSquares[15] = new SqueezePlay(15);
		gameSquares[16] = new Land(16, "Pacific", color.green, 300);
		gameSquares[17] = new Land(17, "North Carolina", color.green, 300);
		gameSquares[18] = new Chance(18, ChanceDeck);
		gameSquares[19] = new Land(19, "Pennsylvania", color.green, 320);
	}
}
